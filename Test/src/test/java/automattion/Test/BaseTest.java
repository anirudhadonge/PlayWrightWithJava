package automattion.Test;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.main.java.utilities.BaseTestContext;
import com.main.java.utilities.BrowserLibs;
import com.main.java.utilities.Environment;
import com.main.java.utilities.ExtentReportClass;
import com.microsoft.playwright.Page;


public class BaseTest {

	public static ThreadLocal<BaseTestContext> baseTestContext = new ThreadLocal<BaseTestContext>();
	Environment environment;
	public static Properties projProperties;
	Page page;
	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("BaseTest Before method invoked");
		ExtentTest extentTest = ExtentReportClass.getExtentReporter().createTest(method.getName());
		getProperties();
		page = BrowserLibs.GetPageObject(projProperties.getProperty("Browser"));
		baseTestContext.set(new BaseTestContext(extentTest,page));
		environment = new Environment();
		log(Status.PASS,"Navigating to Url :"+environment.getUrl());
		//webDriver.get().getDriver().navigate().to(environment.getUrl());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		baseTestContext.get().getExtent().info("BaseTest After method invoked");
		baseTestContext.get().getExtent().info("Close the driver " + baseTestContext.get().getPage());
		baseTestContext.get().getPage().close();
		baseTestContext.get().getExtent().info("Driver closed");
		ExtentReportClass.getExtentReporter().flush();
	}
	
	public void info(String message) {
		baseTestContext.get().getExtent().info(message);
	}

	public void log(Status status, String message) {
		baseTestContext.get().getExtent().log(status, message);
	}

	public void error(String message) {
		//baseTestContext.get().getExtent().(message);
	}
	
	public void fail(String message) {
		baseTestContext.get().getExtent().fail(message);
	}
	
	public void getProperties() {
	/*	if(projProperties != null) {*/
		projProperties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\ProjectProperties.properties");
				projProperties.load(fileInputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			projProperties = null;
		}
	}
}
