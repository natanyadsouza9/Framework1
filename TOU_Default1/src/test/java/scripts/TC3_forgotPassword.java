package scripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Excel;
import pom.LoginPage;

public class TC3_forgotPassword extends BaseTest {
	
	public static Logger log =LogManager.getLogger(TC3_forgotPassword.class.getName());

	public WebDriver driver;

	@Test
	public void forgotPassword() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		
		test = extent.createTest("forgotPassword");
		extentTest.set(test);
		try {
			driver=initializeDriver();
			extentTest.get().log(Status.INFO, "URL launched successfullly", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"initializeDriver")).build());
			log.info("URL launched successfully");

			}
			
			catch(Exception e) {
				
				extentTest.get().log(Status.INFO, "URL not launched successfullly", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"initializeDriver")).build());
				log.error("URL not launched successfully");

			}
		
		LoginPage l=new LoginPage(driver);
		//extentTest.get().log(Status.INFO, l.clickForgotPassword());
		extentTest.get().log(Status.INFO, l.clickForgotPassword(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"clickForgotPassword")).build());

	}
}
