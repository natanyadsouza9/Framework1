package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Excel;
import pom.LoginPage;

public class TC3_forgotPassword extends BaseTest {
	
	
	public WebDriver driver;

	@Test
	public void forgotPassword() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		driver=initializeDriver();

		test = extent.createTest("forgotPassword");
		extentTest.set(test);
		LoginPage l=new LoginPage(driver);
		extentTest.get().log(Status.INFO, l.clickForgotPassword());

	}
}
