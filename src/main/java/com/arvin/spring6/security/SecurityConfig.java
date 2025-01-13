package com.arvin.spring6.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthenticatedPrincipalOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.arvin.spring6.services.CustomOAuth2UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * SecurityConfig configures Spring Security for the web application.
 * It enables web security, method-level security, OAuth2 login integration,
 * and customizes HTTP security settings including CORS, CSRF, authorization rules,
 * login/logout handlers, and exception handling.
 *
 * <p>This configuration class extends WebSecurityConfigurerAdapter to override default
 * security settings. It registers OAuth2 client details for Google integration using
 * an in-memory client registration repository.</p>
 * 
 * Author Yu Zhou
 * 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{
	// Logger for logging security configuration and events
	private final static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
	private CustomOAuth2UserService oauthUserService; // Custom OAuth2 user service to load user information after authentication
	
	/**
     * Configures HTTP security for the application, defining which endpoints require
     * authentication, customizing OAuth2 login flow, and handling logout and exceptions.
     *
     * @param http the HttpSecurity object to configure.
     */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		logger.info("Processing HttpSecurity configure");
		
		httpSecurity
			.cors(cors -> cors.disable())
			.csrf(csrf -> {csrf.disable();})
			.authorizeHttpRequests(auth -> {
                auth.requestMatchers("/**").permitAll();
                auth.requestMatchers("/authenticate/**").permitAll();
                auth.requestMatchers("/resources/**").permitAll();
                auth.requestMatchers("/secured/**").authenticated(); // Require authentication for endpoints under /secured/**
            }).oauth2Login(oauth2 -> oauth2
			    .loginPage("/login")
			    .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
		    		.userService(oauthUserService)
			    )
			).formLogin(form -> form
                .successHandler(
                	new AuthenticationSuccessHandler() {
						public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
							logger.info("AuthenticationSuccessHandler invoked");
							logger.info("Authentication name: " + authentication.getName());
							
							// Process the OAuth2 user information and create a LoginUser object
//    							CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
//    							LoginUser loginUser = userService.processOAuthPostLogin(oauthUser);
//    							
//    							// If environment is local, adjust the login path accordingly
//    							if(systemValueConfig.getEnv().equals(Content.LOCAL)) {
//    								loginUser.setPath(
//    									Content.DOMAIN_LOCAL + 
//    									Content.FORWARD_SLASH + 
//    									Content.PROJECT_NAME
//    								);
//    							}
							
							// Store the logged-in user in the session
//    							request.getSession().setAttribute(Content.LOGIN_USER, loginUser);
							
							// Redirect to the secured home page after login
//    							response.sendRedirect("/oop/secured/home");
						}
                	}
                )
                .failureHandler(
            		new AuthenticationFailureHandler() {
						public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
							logger.info("AuthenticationFailureHandler invoked");
							logger.info("AuthenticationException Message: " + exception.getMessage());
							
							// Redirect to an error page on authentication failure
//    							response.sendRedirect("/oop/error");
						}
					}
                )
            );
		
		return httpSecurity.build();
	}
	
	/**
     * Defines an in-memory ClientRegistrationRepository bean that holds OAuth2 client
     * registration information. This example registers a Google client.
     *
     * @return a ClientRegistrationRepository containing the Google client registration.
     */
	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
	}
	
	/**
     * Defines an in-memory OAuth2AuthorizedClientService bean for storing authorized
     * client information after successful authentication.
     *
     * @param clientRegistrationRepository the repository containing client registration details.
     * @return an OAuth2AuthorizedClientService instance.
     */
	@Bean
	public OAuth2AuthorizedClientService authorizedClientService(ClientRegistrationRepository clientRegistrationRepository) {
		logger.info("Processing Authorized Client Service");
		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
	}

	/**
     * Defines an OAuth2AuthorizedClientRepository bean that links the authorized client
     * service with the currently authenticated principal.
     *
     * @param authorizedClientService the service that stores authorized client details.
     * @return an OAuth2AuthorizedClientRepository instance.
     */
	@Bean
	public OAuth2AuthorizedClientRepository authorizedClientRepository(OAuth2AuthorizedClientService authorizedClientService) {
		logger.info("Processing Authorized Client Repository");
		return new AuthenticatedPrincipalOAuth2AuthorizedClientRepository(authorizedClientService);
	}

	/**
     * Creates a ClientRegistration object for Google OAuth2 authentication.
     * This includes client ID, client secret, authorization and token URIs, and scopes.
     *
     * @return a ClientRegistration configured for Google OAuth2.
     */
	private ClientRegistration googleClientRegistration() {
		logger.info("Processing Google Client Registration");
		
		return ClientRegistration.withRegistrationId("google")
			// TODO: Set the Google client ID and secret appropriately.
			.clientId("<Google OAuth2 Client Id>")
			.clientSecret("<Google OAuth2 Secret>")
			// Use basic client authentication method
			.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
			// Set the authorization grant type
			.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
			// Set the redirection URI template for OAuth2 callbacks
			.redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
			// Specify the scopes required
			.scope("profile", "email")
			// Google OAuth2 endpoints
			.authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
			.tokenUri("https://www.googleapis.com/oauth2/v4/token")
			.userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
			// Define the user name attribute and JWK Set URI for token verification
			.userNameAttributeName(IdTokenClaimNames.SUB)
			.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
			.clientName("Google")
			.build();
	}
}
