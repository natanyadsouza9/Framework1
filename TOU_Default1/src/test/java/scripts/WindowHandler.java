package scripts;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//using window handler and window handles method we close all 
//of the child browsers and not the parent window

public class WindowHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		int count=driver.getWindowHandles().size();
		System.out.println("no of windows open are "+count);
		//driver.switchTo().window(driver.getWindowHandle()).close();
		Set<String> windows=driver.getWindowHandles();
		
        String mainWindow=driver.getWindowHandle();
        
        for(String wh:windows){
        	
        	if(wh.equalsIgnoreCase(mainWindow)){
        		
        		continue;
        	}
        	else{
        	driver.switchTo().window(wh);
        	driver.close();
        	}
        }
	}

}
