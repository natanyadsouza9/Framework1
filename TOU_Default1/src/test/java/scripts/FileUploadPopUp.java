package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/selenium/upload/");
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\n1db\\Downloads\\New Text Document.txt");
		driver.findElement(By.id("submitbutton")).click();
		
	}

}
