package scripts;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.GlobalParameters;
import generic.TestData;
import pom.LoginPage;

public class TC2_launchOrangeHRM extends BaseTest {

	public static Logger log =LogManager.getLogger(TC2_launchOrangeHRM.class.getName());

	public WebDriver driver;
	@Test
	public void launchOrangeHRM() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		
		test = extent.createTest("launchOrangeHRM");
		extentTest.set(test);
		HashMap<String,String> testdata=TestData.getTestData("editEmployeeDetails");
		HashMap<String,String> globalParameters=GlobalParameters.getGlobalParameters();
		String URL=globalParameters.get("OrangeHRM_URL");

		try {
			driver=initializeDriver(URL);
			extentTest.get().log(Status.INFO, "URL launched successfullly", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"initializeDriver")).build());
			log.info("URL launched successfully");

			}
			
			catch(Exception e) {
				
				extentTest.get().log(Status.INFO, "URL not launched successfullly", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"initializeDriver")).build());
				log.error("URL not launched successfully");

			}
		
		LoginPage l=new LoginPage(driver);
		extentTest.get().log(Status.INFO, l.setUserName(testdata.get("Username")), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"setUserName")).build());
		extentTest.get().log(Status.INFO,l.setPassword(testdata.get("Password")),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"setPassword")).build());
		extentTest.get().log(Status.INFO,l.clickLoginButton(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"clickLoginButton")).build());
		extentTest.get().log(Status.INFO,l.hoverOnPIM(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"hoverOnPIM")).build());
	
	}
}
