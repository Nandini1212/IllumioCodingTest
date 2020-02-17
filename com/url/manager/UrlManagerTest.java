package com.url.manager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class UrlManagerTest {
	UrlParser urlParser = new UrlParser();
	UrlStore urlStore = new UrlStore();
	UrlManager urlManager = new UrlManager();
	
	@Test	
	public void testValidLongUrl() throws Exception {		
		boolean result = urlParser.isValid("https://www.google.com/search?sxsrf=ACYBGNQ1W-iqqZQzchPAN4LDScmUMtExEQ%3A1581473929021&ei=iWBDXqJnydv6BMyBq5gD&q=+get+all+employees+java&oq=+get+all+employees+java&gs_l=psy-ab.3..0i8i30.8639.8639..8934...0.1..0.82.82.1......0....1..gws-wiz.......0i71.KlXKwa80dYg&ved=0ahUKEwjiz4q--crnAhXJrZ4KHczACjMQ4dUDCAs&uact=5");		
		assertTrue("valid url id passed", result);	
	}
	@Test	
	public void testValidShortUrl() throws Exception {		
		boolean result = urlParser.isValid("https://www.geeksforgeeks.org/");		
		assertTrue("valid url id passed", result);	
	}
	@Test	
	public void testInValidUrl() throws Exception {			
		boolean result = urlParser.isValid("http:www.example.com/main.html");		
		assertFalse("Invalid url passed", result);	
	}
	@Test	
	public void testWithOutHttpInValidUrl() throws Exception {			
		boolean result = urlParser.isValid("www.example.com/main.html");		
		assertFalse("Invalid url passed", result);	
	}
	@Test	
	public void testWithsquareBracketspInValidUrl() throws Exception {			
		boolean result = urlParser.isValid("http://[2001:db8:85a3::8a2e:370:7334]/foo/bar");		
		assertFalse("Invalid url passed", result);	
	}
	@Test	
	public void testSpaceAfterHttps() throws Exception{			
		boolean result = urlParser.isValid("https:// www.geeksforgeeks.org/");		
		assertFalse("Invalid url passed", result);	
	}
	@Test	
	public void testEmptyUrl() throws Exception {		
		boolean result = urlParser.isValid("");		
		assertFalse("Empty url passed", result);	
	}
	@Test	
	public void testUpdate() throws Exception {
		urlStore.update("https://www.facebook.com/Learn-the-Net-330002341216/");		
		String value = urlStore.get();		
		assertNotSame("https://www.facebook.com/Learn-the-Net-330002341216/", value);	
	}
	@Test	
	public void testStoreUrlWithDifferentUrl() throws Exception {		
		urlStore.update("https://websitebuilders.com");		
		String value = urlStore.get();		
		assertNotNull(value, "https://www.facebook.com/Learn-the-Net-330002341216/");	
	}
	@Test	
	public void testGetExisitngUrl() throws Exception {		
		urlStore.update("https://websitebuilders.com");		
		urlStore.update("https://www.facebook.com/Learn-the-Net-330002341216/");		
		String value = urlStore.get();
		assertNotNull("Returned null for existing url", value);	
	}
	@Test
	public void testStoreUrl() throws IOException{
		urlStore.update("https://www.geeksforgeeks.org/java/");
		
	}
	@Test
	public void testStoreMethodGet() throws IOException {
		String value = urlStore.get();
		Assert.assertNotNull("Returned not null value", value);
		
	}
	@Test
	public void testScanAndStoreUrl() throws Exception {
		boolean value = urlManager.scanAndStoreUrl("https://www.geeksforgeeks.org/", 1);
		Assert.assertEquals(value, true);
		//urlManager.scanAndStoreUrl("https://www.geeksforgeeks.org/java/", 2);
	}
	@Test
	public void testGet() throws IOException {
		String value = urlManager.get();
		assertNotNull("Returned not null value", value);
	}
	
}
