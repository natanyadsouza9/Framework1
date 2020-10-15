package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;
import generic.GenericUtils;

public class LoginPage extends BasePage {
	
	@FindBy(id="txtUsername")
	private WebElement userName;
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement password;
	@FindBy(xpath="//input[@id='btnLogin']")
	private WebElement loginButton;
	@FindBy(linkText="PIM")
	private WebElement pimModule;
	@FindBy(xpath="//a[text()='Employee List']")
	private WebElement employeeListSubMenu;
	@FindBy(xpath="//a[contains(text(),'0006')]")
	private WebElement employeeId;
	@FindBy(xpath="//input[@value='Edit']")
	private WebElement editButton;
	@FindBy(xpath="//input[@title='First Name']")
	private WebElement firstName;
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveButton;
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcomeMenu;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logoutButton;
	@FindBy(xpath="//select[@id='empsearch_job_title']")
	private WebElement jobTitle_ListBox;
	@FindBy(xpath="//div[@id='forgotPasswordLink'] //a")
	private WebElement forgotPassword_Link;
	
	BasePage p=new BasePage(driver);
	public LoginPage(WebDriver driver){
		
		super(driver);
		PageFactory.initElements(driver, this);	
		
	}
	
	public String setUserName(String username){
		
		return p.enterText(username, userName,"UsernameTextBox");
	}
	
public String setPassword(String pwd){
		
	return p.enterText(pwd, password,"PasswordTextbox");
	}

public String clickLoginButton(){
	
	return BasePage.clickOnElement(loginButton, "LoginButton");
	
}

public String hoverOnPIM(){
	
	return GenericUtils.mouseHover(pimModule,"PIM_Module", driver);
}

public String clickEmployeeListSubMenu(){
	
	return BasePage.clickOnElement(employeeListSubMenu, "employeeList_SubMenu");
	
}

public String clickOnEmployeeId(){
	
return BasePage.clickOnElement(employeeId, "Employee_ID");
}

public String clickEditButton(){
	
	return BasePage.clickOnElement(editButton, "EditButton");
	
}

public String editFirstName(String name){
	
	//firstName.clear();
	return p.enterText(name, firstName, "firstNameTextBox");
	
}

public String clickSaveButton(){
	
	return BasePage.clickOnElement(saveButton, "SaveButton");
	
}



public String clickWelcomeMenu(){
	
return BasePage.clickOnElement(welcomeMenu, "Welcome_Menu");
}

public String clickLogoutButton(){
	
return BasePage.clickOnElement(logoutButton, "Logout_Button");

}

public void verifyListBoxIsSorted(){
	
GenericUtils.sortListBox(jobTitle_ListBox);
}

public String clickForgotPassword(){
	
	return BasePage.clickOnElement(forgotPassword_Link,"forgotPassword_Link");
}

}
