package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Excel;
import pom.LoginPage;

public class TC2_launchOrangeHRM extends BaseTest {

	public WebDriver driver;

	@Test
	public void launchOrangeHRM() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		
		test = extent.createTest("launchOrangeHRM");
		extentTest.set(test);
		try {
			driver=initializeDriver();
			extentTest.get().log(Status.INFO, "URL launched successfullly", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"initializeDriver")).build());

			}
			
			catch(Exception e) {
				
				extentTest.get().log(Status.INFO, "URL not launched successfullly", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"initializeDriver")).build());
			
			}
		
		LoginPage l=new LoginPage(driver);
		extentTest.get().log(Status.INFO, l.setUserName(Excel.readData("Username")), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"setUserName")).build());
		extentTest.get().log(Status.INFO,l.setPassword(Excel.readData("Password")),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"setPassword")).build());
		extentTest.get().log(Status.INFO,l.clickLoginButton(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"clickLoginButton")).build());
		extentTest.get().log(Status.INFO,l.hoverOnPIM(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"hoverOnPIM")).build());
	
	}
}
