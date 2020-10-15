package generic;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

public class BasePage extends BaseTest {

	public  WebDriver driver;
	static SoftAssert soft=new SoftAssert();

	public BasePage(WebDriver driver){

		this.driver=driver;
	}

	public static void verifyTitle(String expectedTitle,String PageName, WebDriver driver){

		String text1;

		try{
			WebDriverWait wait=new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.titleIs(expectedTitle));
			Reporter.log(PageName+" is displayed ",true);
			text1=PageName+" is displayed ";
		}

		catch(Exception e){
			text1=PageName+" is not displayed ";
			Reporter.log(PageName+" is not displayed ",true);
			Assert.fail(text1);		

		}
	}

	public  String enterText(String text,WebElement element,String elementName){

		String text1;
		try{
			//Thread.sleep(5000);	
			element.clear();
			element.sendKeys(text);
			text1=text+" has been entered in "+elementName;
			Reporter.log(text+" has been entered in "+elementName,true);
			//logsGeneration(text+" has been entered in "+elementName);

		}

		catch(Exception e){
			text1=text+" has not been entered in "+elementName;
			Reporter.log(text+" has not been entered in "+elementName,false);
			Assert.fail(text1);		

		}
		return text1;
	}

	public static String clickOnElement(WebElement element,String elementName){

		String text1;

		try{
			element.click();
			Reporter.log(elementName+" has been clicked",true);
			text1=elementName+" has been clicked";
		}

		catch(Exception e){

			text1=elementName+" has not been clicked";

			Reporter.log(elementName+" has not been clicked ",false);
			Assert.fail(text1);		

		}

		return text1;

	}

	public static void verifyElementIsPresent(WebDriver driver){

		String text1;

		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Reporter.log("element  is  present ",true);
			text1="element  is  present ";

		}

		catch(Exception e){
			text1="element  is not  present ";
			Reporter.log("element  is  not present ",true);
			Assert.fail(text1);		

		}
	}



}
