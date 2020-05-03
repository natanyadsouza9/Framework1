package scripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerGuru {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		WebElement e=driver.findElement(By.linkText("Click Here"));
		e.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		
		for(String wh:windows){
			
			if(mainWindow.equalsIgnoreCase(wh)){
				
				continue;
			}
			
			else{
				
				driver.switchTo().window(wh);
				
			}
		}
		
		WebElement emailAddress=driver.findElement(By.name("emailid"));
		emailAddress.sendKeys("test123@gmail.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	

		driver.close();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		driver.switchTo().window(mainWindow);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		driver.close();
	}

}
