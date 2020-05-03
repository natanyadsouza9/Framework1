package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		WebElement src=driver.findElement(By.xpath("//a[text()=' SALES ']"));
		WebElement dest=driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).build().perform();

	}

}
