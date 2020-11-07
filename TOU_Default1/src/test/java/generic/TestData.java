package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public  class TestData extends BaseTest {


	public static  HashMap<String,String> getTestData(String testcaseName) throws IOException{

		FileInputStream fis = null;

		String path=System.getProperty("user.dir")+"\\data\\TestData.xlsx";
		File f=new File(path);
		//FileInputStream fis="";
		try {
			fis=new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		Iterator<Row> row=sheet.iterator();

		int i=0;
		int rowNo;
		
		//find the row no of testcase being executed
		while(row.hasNext()) {

			row.next();
			String data=sheet.getRow(i).getCell(0).toString();
			
			if(data.equalsIgnoreCase(testcaseName)) {
				rowNo=i;

				break;
			}
			i++;

		}

		HashMap<String,String> map=new HashMap<>();
		
		Iterator<Cell> cell=sheet.getRow(0).cellIterator();
		int k=0;
		while(cell.hasNext()) {
			
			cell.next();
			String key=sheet.getRow(0).getCell(k).toString();
			String value=sheet.getRow(i).getCell(k).toString();
		

			map.put(key, value);
			k++;

		}
		
		wb.close();

		return map;

	}

}
