package com.arvin.spring6.payload;

public class RequestResponse {
	private boolean result = false;
	private String message;
	private String path;
	
	public RequestResponse(){}
	
	public RequestResponse(String message){
		this.message = message;
	}
	
	public RequestResponse(boolean result, String message){
		this.result = result;
		this.message = message;
	}
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String env, String path) {
		this.path = path;
	}
}
