package generic;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	public    String TestScriptName;
	public static ExtentTest test;
	public static ExtentReports extent=ExtentReporter.getReportObject();
	public static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public WebDriver initializeDriver(){


		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver=new ChromeDriver();

		
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
		WebDriver driver =null;

		if(result.getStatus() == ITestResult.SUCCESS)
			extentTest.get().log(Status.PASS, "Test Case Passed successfully");

		if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.get().fail(result.getThrowable());
		
			try {
				driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch(Exception e)
			{
				
			}
		try {
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(driver,result.getMethod().getMethodName()), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

		extent.flush();

	}

	public String takeScreenshot(WebDriver driver,String testcaseName) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		try {
			FileUtils.copyFile(source, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dest;
		
	}
	

}
