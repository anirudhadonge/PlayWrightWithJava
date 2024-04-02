package automattion.Test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.main.java.utilities.BaseTestContext;
import com.main.java.utilities.BrowserLibs;
import com.main.java.utilities.Environment;
import com.main.java.utilities.ExtentReportClass;

public class DemoTest extends BaseTest {

	@Test
	public void firstTest() {
		baseTestContext.get().getExtent().info("Navigating to google.com");
		baseTestContext.get().getPage().navigate("https:\\wwww.google.com");
	}
}
