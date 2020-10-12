package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericUtils extends BaseTest {
	
	public static void mouseHover(WebElement element,String elementName){
		
		try{
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();
		Reporter.log("Mouse hovered on element "+elementName,true);
		}
		
		catch(Exception e){
			Reporter.log("Mouse was not hovered on element "+elementName,true);
			Assert.fail();

		}
	
}	
	
	public static void dragDrop(WebElement src,WebElement dest){
		
		try{
	Actions action=new Actions(driver);
	action.dragAndDrop(src, dest).build().perform();
		Reporter.log("Element "+src+"has been dragged and dropped to "+dest,true);
		}
		
		catch(Exception e){
			Reporter.log("Element was not dragged and dropped "+src,true);
			Assert.fail();

		}
	
}
	
	public static void selectDropDownValueByIndex(WebElement element,int index){
		
		try{
	Select select=new Select(element);
	select.selectByIndex(index);
		Reporter.log("Dropdown value selected at index"+index,true);
		}
		
		catch(Exception e){
			Reporter.log("Dropdown value not selected at index"+index,true);
			Assert.fail();

		}
	
}
	
public static void sortListBox(WebElement element){
		
		try{
	Select select=new Select(element);
	List<WebElement> list=select.getOptions();
	List<String> arrayList1=new ArrayList<String>();
	List<String> arrayList2=new ArrayList<String>();
	
	for(int i=1;i<list.size();i++){
		
		//System.out.println(list.get(i).getText());
		arrayList1.add(list.get(i).getText());
		arrayList2.add(list.get(i).getText());

	}
	Collections.sort(arrayList1);
	int flag=0;

	for(int i=0;i<arrayList1.size();i++){
		//System.out.println("array1 "+arrayList1.get(i));
		//System.out.println("array2 "+arrayList2.get(i));

		if(!((arrayList1.get(i)).equals(arrayList2.get(i)))){

			Reporter.log("Listbox is not sorted",true);
			flag=1;
			break;
		}
				}

	if(flag==0){
		Reporter.log("Listbox is  sorted",true);
	
		
	}
		}
		
		catch(Exception e){
			Reporter.log("exception",true);
			Assert.fail();

		}
}
	
}
