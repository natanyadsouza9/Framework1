package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GlobalParameters {

	public static HashMap<String, String> getGlobalParameters() throws IOException {

		FileInputStream fis=null;
		String path=System.getProperty("user.dir")+"\\data\\GlobalParameters.xlsx";
		File f=new File(path);
		try {
			 fis=new FileInputStream(f);
		} 

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		Iterator<Row> row=sheet.iterator();
		
		HashMap<String,String> map=new HashMap<String, String>();

		int i=0;
		while(row.hasNext()) {
			
			row.next();
			String key=sheet.getRow(i).getCell(0).toString();
			//System.out.println(key);
			String value=sheet.getRow(i).getCell(1).toString();
			//System.out.println(value);
			map.put(key, value);
			i++;

		}
		
		return map;
		
	}

}
