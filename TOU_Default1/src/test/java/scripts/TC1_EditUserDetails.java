package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import pom.LoginPage;

public class TC1_EditUserDetails extends BaseTest {
	
	@Test(enabled=true)
	public void editEmployeeDetails() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
		LoginPage l=new LoginPage(driver);
		l.setUserName(Excel.readData("Username"));
		l.setPassword(Excel.readData("Password"));
		l.clickLoginButton();
		//BasePage.verifyTitle("OrangeHRM","HomePage");
		l.hoverOnPIM();
		l.clickEmployeeListSubMenu();
		//BasePage.verifyTitle("OrangeHRM","EmployeeList_Page");
		Thread.sleep(5000);
		//BasePage.verifyElementIsPresent();
		l.clickOnEmployeeId();
		//BasePage.verifyTitle("OrangeHRM","EmployeeDetailsPage");
		Thread.sleep(5000);
        l.clickEditButton();
		//BasePage.verifyElementIsPresent();
        l.editFirstName(Excel.readData("FirstName"));
        l.clickSaveButton();
		//BasePage.verifyElementIsPresent();
        l.clickWelcomeMenu();
		//BasePage.verifyElementIsPresent();
		Thread.sleep(7000);
        l.clickLogoutButton();
		
	}
	
	@Test(enabled=false)
	public void verifyListBox() throws InterruptedException{
		
		LoginPage l=new LoginPage(driver);
		l.setUserName("Username");
		l.setPassword("Password");
		l.clickLoginButton();
		BasePage.verifyTitle("OrangeHRM","HomePage");
		l.hoverOnPIM();
		l.clickEmployeeListSubMenu();
		BasePage.verifyTitle("OrangeHRM","EmployeeList_Page");
		l.verifyListBoxIsSorted();
		//BasePage.verifyElementIsPresent();
			
	}


}
