This is a utility UrlManager to store a valid URL in a file. The utility provides two options, update and get. Option “update” validates and updates the existing URL which is stored by default at /tmp/url. Option “get” is to retrieve the URL from the storage. Make sure that the path /tmp/url is both readable and writable for the user running the utility.

Modules:

UrlManager
	update() - validates and updates the new URL.
	get() - retrieves the URL from the URL store.

UrlParser
	isValid() - validates the URL. Returns true if valid else false.

UrlStore
	store() - stores the URL into the file (default located at /tmp/url).
	get() - retrieves the URL from the file (default located at /tmp/url).

UrlUtility
	main() - contains the main function of the utility.

Building:

The default package of the files is "com.url.manager". Create a directory path "com/url/manager" and copy the *.java files into the directory. From the directory where the com directory exists, issue the command "javac com/url/manager/*.java" then run "java com.url.manager.UrlUtility" to run the utility.

Usage:
	java com.url.manager.UrlUtility - prints the usage of the utility
	java com.url.manager.UrlUtility update - update the URL in the store (max 3 retries)
	java com.url.manager.UrlUtility get - retrieves the URL stored in the store
	
Created a jar file to run from a command line. Issue the command java -jar CodingTest.jar 

Usage : 
	java -jar CodingTest.jar update
	java -jar CodingTest.jar get

Tests:

I used the Junit framework for the tests. All the tests are available in the file "UrlManagerTest". There are tests for each of the modules for different combinations of inputs.
