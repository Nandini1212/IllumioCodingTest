package com.url.manager;

public class UrlParser {
	String urlValidationRegEx = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]" ;
	
	public UrlParser() {}
	
	UrlParser(String urlValidationRegEx) {
		this.urlValidationRegEx = urlValidationRegEx;
	}
	
	public boolean isValid(String url) {
		return url.matches(urlValidationRegEx);
	}
}

