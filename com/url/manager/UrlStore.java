package com.url.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class UrlStore {
	private String urlFileName = "/tmp/urlText.txt";
	
	public UrlStore() {}
	
	// For testing only.
	UrlStore(String urlFileName) {
		this.urlFileName = urlFileName;
	}
    
	public void update(String url) throws IOException {
        File urlFile = new File(urlFileName);
		if (!urlFile.exists()) {
			urlFile.createNewFile();
		}
		FileOutputStream urlFileOutputStream = new FileOutputStream(urlFile);
		urlFileOutputStream.write(url.getBytes());
		urlFileOutputStream.flush();		 
	}

	public String get() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(urlFileName));
		String currentLine = bufferedReader.readLine();	
		bufferedReader.close();
		return currentLine;
	}

}
