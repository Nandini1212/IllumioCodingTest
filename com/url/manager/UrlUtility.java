package com.url.manager;

import java.io.IOException;
import java.util.Scanner;

public class UrlUtility {

	public static void main(String[] args) {
		UrlManager urlManager = new UrlManager();
		int maxUrlRetries = 3;
		Scanner inputScanner = new Scanner(System.in);
		if (args[0].contentEquals("update")) {
			try {
				for (int retries = 0; retries < maxUrlRetries; retries++) {
					System.out.println("Enter URL to update : ");
					String url = inputScanner.nextLine();
					if (urlManager.scanAndStoreUrl(url, retries)) {
						System.out.println("Url successfully updated to: " + url);
						System.exit(0);
					}
					System.out.println("Invalid URL (Retry " + retries + ").");
				}
				System.out.println("Maximum retries exceeded.");

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (args[0].contentEquals("get")) {
			try {
				String url = urlManager.get();
				System.out.println("Url is: " + url);
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Usage: java UrlUtility.java (update | get)");
			System.exit(0);
		}
	}
}


