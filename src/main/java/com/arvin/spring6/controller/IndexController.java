package com.arvin.spring6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index() {
		return "index";
    }
	
	@RequestMapping(value = {"/userLogin"}, method = RequestMethod.GET)
    public String login() {
		return "index";
    }
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logout() {
		return "index";
	}
	
	@RequestMapping(value = {"/secured/home"}, method = RequestMethod.GET)
    public String home() {
		return "index";
    }
}
