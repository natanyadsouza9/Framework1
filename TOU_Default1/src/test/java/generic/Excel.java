package generic;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel extends BaseTest {
	
	public   String readData(String testdata,String TestScriptName ) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		String path=System.getProperty("user.dir")+"\\data\\TestData.xlsx";
		File f=new File(path);
		Workbook wb=WorkbookFactory.create(f);
		System.out.println("Excel method:Test case being run is "+TestScriptName);
		//String testData=wb.getSheet(Sheet).getRow(rowNo).getCell(columnNo).toString();
		int lastRowNo=wb.getSheet("Sheet1").getLastRowNum();
		int rowNoOfTestCaseRun=0;
		
		for(int i=1;i<=lastRowNo;i++){
			
			String testcaseName=wb.getSheet("Sheet1").getRow(i).getCell(0).toString();
			if(testcaseName.equals(TestScriptName)){
				rowNoOfTestCaseRun=i;
				break;
				
			}
		}

		
		int columnNoOfTestData=0;
		int count=1;
		String testdataHeader="";
		while(!testdata.equals(testdataHeader)){
			
			columnNoOfTestData++;
             testdataHeader=wb.getSheet("Sheet1").getRow(0).getCell(count).toString();

             count++;
            
			
		}

		String value=wb.getSheet("Sheet1").getRow(rowNoOfTestCaseRun).getCell(columnNoOfTestData).toString();

		return value;
		
	}

}
