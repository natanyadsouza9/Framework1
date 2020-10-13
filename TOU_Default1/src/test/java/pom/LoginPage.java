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
	
	BasePage p=new BasePage(driver);
	public LoginPage(WebDriver driver){
		
		super(driver);
		PageFactory.initElements(driver, this);	
		
	}
	
	public String setUserName(String username){
		
		return p.enterText(username, userName,"UsernameTextBox");
	}
	
public void setPassword(String pwd){
		
	p.enterText(pwd, password,"PasswordTextbox");
	}

public void clickLoginButton(){
	
	BasePage.clickOnElement(loginButton, "LoginButton");
	
}

public void hoverOnPIM(){
	
	GenericUtils.mouseHover(pimModule,"PIM_Module");
}

public void clickEmployeeListSubMenu(){
	
	BasePage.clickOnElement(employeeListSubMenu, "employeeList_SubMenu");
	
}

public void clickOnEmployeeId(){
	
BasePage.clickOnElement(employeeId, "Employee_ID");
}

public void clickEditButton(){
	
	BasePage.clickOnElement(editButton, "EditButton");
	
}

public void editFirstName(String name){
	
	//firstName.clear();
	p.enterText(name, firstName, "firstNameTextBox");
	
}

public void clickSaveButton(){
	
	BasePage.clickOnElement(saveButton, "SaveButton");
	
}



public void clickWelcomeMenu(){
	
BasePage.clickOnElement(welcomeMenu, "Welcome_Menu");;	
}

public void clickLogoutButton(){
	
BasePage.clickOnElement(logoutButton, "Logout_Button");;	
}

public void verifyListBoxIsSorted(){
	
GenericUtils.sortListBox(jobTitle_ListBox);
}


}
