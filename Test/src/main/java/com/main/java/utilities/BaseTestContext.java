package com.main.java.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

public class BaseTestContext {

	private ExtentTest extent;
	private Page page;
	
	public ExtentTest getExtent() {
		return extent;
	}

	public void setExtent(ExtentTest extent) {
		this.extent = extent;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public BaseTestContext(ExtentTest extent, Page page) {
		this.extent = extent;
		this.page = page;
	}
	
}
