package com.url.manager;

import java.io.IOException;

public class UrlManager {
	private UrlParser urlParser;
	private UrlStore urlStore;
	
	UrlManager() {
		urlParser = new UrlParser();
		urlStore = new UrlStore();
	}
	
	// For testing only.
	UrlManager(UrlParser urlParser, UrlStore urlStore) {
		this.urlParser = urlParser;
		this.urlStore = urlStore;
	}
	
	public boolean scanAndStoreUrl(final String url, final int retry) throws IOException {
		if(urlParser.isValid(url)) {
			urlStore.update(url);
			return true;
		}
		return false;
	}
		
	public String get() throws IOException {
		return urlStore.get();
	}	
}
