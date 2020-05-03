package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://mtst6.pge.com/#login");
		Thread.sleep(5000);
		WebElement username=driver.findElement(By.xpath("//input[@id='usernameField']"));
		username.sendKeys("touweb_1");
		WebElement password=driver.findElement(By.xpath("//input[@id='passwordField']"));
		password.sendKeys("password");
		WebElement loginButton=driver.findElement(By.xpath("//button[@id='home_login_submit']"));
		loginButton.click();
		//Thread.sleep(9000);
		WebDriverWait wait=new WebDriverWait(driver,20);
		//WebElement EditAlertsButton=driver.findElement(By.xpath("//a[@id='utag-salutation-block-edit-profile']"));

       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='utag-salutation-block-edit-profile']")));
       //EditAlertsButton.click();
       Thread.sleep(5000);
       WebElement EditAlertsButton=driver.findElement(By.xpath("//a[@id='utag-salutation-block-edit-profile']"));
       EditAlertsButton.click();
         	boolean status = EditAlertsButton.isDisplayed();

	// if else condition
	if (status) {
		System.out.println("===== EditAlertsButton is visible======");
	} else {
		System.out.println("===== EditAlertsButton is not visible======");
	}		
		//String currentTitle=driver.getTitle();
        driver.close();

	}

	}

