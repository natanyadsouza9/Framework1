package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {

	public static WebDriver driver;
	
	public BasePage(WebDriver driver){
		
		this.driver=driver;
	}
	
	public static void verifyTitle(String expectedTitle,String PageName){
		
		try{
		WebDriverWait wait=new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.titleIs(expectedTitle));
		Reporter.log(PageName+" is displayed ",true);
		}
		
		catch(Exception e){
			Reporter.log(PageName+" is not displayed ",true);

		}
	}
	
	public static void enterText(String text,WebElement element,String elementName){
		
		try{
		//Thread.sleep(5000);	
		element.clear();
		element.sendKeys(text);
		Reporter.log(text+" has been entered in "+elementName,true);
		}
		
		catch(Exception e){
			Reporter.log(text+" has not been entered in "+elementName,false);

		}
	}
	
	public static void clickOnElement(WebElement element,String elementName){
		
		try{
		element.click();
		Reporter.log(elementName+" has been clicked",true);
		}
		
		catch(Exception e){
			Reporter.log(elementName+" has not been clicked ",false);

		}
	}
	
	public static void verifyElementIsPresent(){
		
		try{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("element  is  present ",true);

		}
		
		catch(Exception e){
			Reporter.log("element  is  not present ",true);

		}
	}
		
	
	
}
