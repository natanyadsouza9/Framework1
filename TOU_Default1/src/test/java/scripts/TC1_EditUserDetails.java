package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import pom.LoginPage;

public class TC1_EditUserDetails extends BaseTest {

	public WebDriver driver;
	@Test(enabled=true)
	public void editEmployeeDetails() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		test = extent.createTest("editEmployeeDetails");
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
		extentTest.get().log(Status.INFO,l.clickEmployeeListSubMenu(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,"clickEmployeeListSubMenu")).build());
		/*		
		//BasePage.verifyTitle("OrangeHRM","EmployeeList_Page");
		Thread.sleep(5000);
		//BasePage.verifyElementIsPresent();
		extentTest.get().log(Status.INFO,l.clickOnEmployeeId());

		//BasePage.verifyTitle("OrangeHRM","EmployeeDetailsPage");
		Thread.sleep(5000);
		extentTest.get().log(Status.INFO,l.clickEditButton());

		//BasePage.verifyElementIsPresent();
		extentTest.get().log(Status.INFO,l.editFirstName(Excel.readData("FirstName")));
		extentTest.get().log(Status.INFO,l.clickSaveButton());

        //l.clickSaveButton();
		//BasePage.verifyElementIsPresent();
		extentTest.get().log(Status.INFO,l.clickWelcomeMenu());
		Thread.sleep(7000);

		extentTest.get().log(Status.INFO,l.clickLogoutButton());

		//BasePage.verifyElementIsPresent();

		 */
	}

	@Test(enabled=false)
	public void verifyListBox() throws InterruptedException{

		LoginPage l=new LoginPage(driver);
		l.setUserName("Username");
		l.setPassword("Password");
		l.clickLoginButton();
		BasePage.verifyTitle("OrangeHRM","HomePage", driver);
		l.hoverOnPIM();
		l.clickEmployeeListSubMenu();
		BasePage.verifyTitle("OrangeHRM","EmployeeList_Page", driver);
		l.verifyListBoxIsSorted();
		//BasePage.verifyElementIsPresent();

	}


}
