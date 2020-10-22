package generic;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	public static Logger log =LogManager.getLogger(BaseTest.class.getName());

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
			log.info(PageName+" is displayed ");
			text1=PageName+" is displayed ";
		}

		catch(Exception e){
			text1=PageName+" is not displayed ";
			log.error(PageName+" is not displayed ");
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
		log.info(text+" has been entered in "+elementName);
			//logsGeneration(text+" has been entered in "+elementName);

		}

		catch(Exception e){
			text1=text+" has not been entered in "+elementName;
			log.error(text+" has not been entered in "+elementName);
			Assert.fail(text1);		

		}
		return text1;
	}

	public static String clickOnElement(WebElement element,String elementName){

		String text1;

		try{
			element.click();
			log.info(elementName+" has been clicked");
			text1=elementName+" has been clicked";
		}

		catch(Exception e){

			text1=elementName+" has not been clicked";

			log.error(elementName+" has not been clicked ");
			Assert.fail(text1);		

		}

		return text1;

	}

	public static void verifyElementIsPresent(WebDriver driver){

		String text1;

		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.info("element  is  present ");
			text1="element  is  present ";

		}

		catch(Exception e){
			text1="element  is not  present ";
			log.error("element  is  not present ");
			Assert.fail(text1);		

		}
	}

	public static String clickForgotPassword(WebElement element,String elementName){

		String text1;

		try{
			element.click();
			log.info(elementName+" has been clicked");
			text1=elementName+" has been clicked";
		}

		catch(Exception e){

			text1=elementName+" has not been clicked";

			log.error(elementName+" has not been clicked ");
			Assert.fail(text1);		

		}

		return text1;

	}

}
