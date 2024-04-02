package com.main.java.utilities;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserLibs {

	
	public static Page GetPageObject(String browserName) {
		Playwright playwright = Playwright.create();
		LaunchOptions launchOptions = new LaunchOptions();
		launchOptions.headless= false;
		/*switch(browserName) {
		case "Chrome" :*/
		return playwright.chromium().launch(launchOptions).newPage();
		/*default:
			return null;*/
		
	}
	
	
}
