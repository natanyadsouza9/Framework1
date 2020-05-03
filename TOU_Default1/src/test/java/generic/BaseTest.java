package generic;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements AutoConst {
	public static WebDriver driver;
	public static String TestScriptName="";
	
	@BeforeMethod
	public void precondition() throws InterruptedException{
		
	
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		 driver=new ChromeDriver();
	
	/*	String GECKO_KEY="webdriver.gecko.driver";
		String GECKO_VALUE="./drivers/geckodriver.exe";
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		 driver=new FirefoxDriver();
		 */
         driver.get("https://opensource-demo.orangehrmlive.com/");
         driver.manage().window().maximize();
	}
	
	 @BeforeMethod
	    public void handleTestScriptName(Method method)
	    {
		 TestScriptName= method.getName(); 
	        System.out.println("Test SCript  run is "+TestScriptName);
	    }
	
	@AfterMethod
	public void postcondition(){
		driver.close();
	}

}
