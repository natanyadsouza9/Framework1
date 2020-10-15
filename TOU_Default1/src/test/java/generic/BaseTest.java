package generic;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class BaseTest implements AutoConst {
	public  WebDriver driver;
	public static String TestScriptName="";
	public static ExtentTest test;
	public static ExtentReports extent=ExtentReporter.getReportObject();
	public static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public WebDriver initializeDriver() throws InterruptedException{


		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver=new ChromeDriver();

		/*	String GECKO_KEY="webdriver.gecko.driver";
		String GECKO_VALUE="./drivers/geckodriver.exe";
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		 driver=new FirefoxDriver();
		 */
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public void handleTestScriptName(Method method)
	{
		TestScriptName= method.getName(); 
		System.out.println("Test SCript  run is "+TestScriptName);
	}

	@AfterMethod
	public void postcondition(ITestResult result){
		//driver.close();
		if(result.getStatus() == ITestResult.SUCCESS)
			extentTest.get().log(Status.PASS, "Test Case Passed successfully");

		if(result.getStatus() == ITestResult.FAILURE)
			extentTest.get().fail(result.getThrowable());

		extent.flush();

	}


}
