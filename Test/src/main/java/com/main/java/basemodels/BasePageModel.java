package com.main.java.basemodels;

import com.aventstack.extentreports.Status;
import com.main.java.utilities.BaseTestContext;

public class BasePageModel {
	
    BaseTestContext baseTestContext;


	public BasePageModel(BaseTestContext baseTestContext) {
		this.baseTestContext = baseTestContext;
	}

	public void info(String message) {
		baseTestContext.getExtent().info(message);
	}

	public void log(Status status, String message) {
		baseTestContext.getExtent().log(status, message);
	}

	public void error(String message) {
		baseTestContext.getExtent().warning(message);
	}

}
