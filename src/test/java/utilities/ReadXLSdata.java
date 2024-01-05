package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {


	
	@DataProvider(name="testdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException

	{
        String excelSheetName = m.getName();
		File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheetName=wb.getSheet(excelSheetName);

		int totalRows=sheetName.getLastRowNum();  //we need to get the dynamic no of rows and coulumn
		System.out.println(totalRows);

		Row rowCells=sheetName.getRow(0); // To get the column count> we need to get the total cells that are there in the row
		int totalCols=rowCells.getLastCellNum();
		System.out.println(totalCols);

		DataFormatter format=new DataFormatter();   //DataFormatter is used format all different types of data (i.e) int, double,char etc

		String testdata[][]=new String[totalRows][totalCols]; // we need nested loops to iterate through the data , 1st loop iterate through the rows and 2ndloop will iterate through the column
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalCols; j++) {
				testdata[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);            
			}
		}
		return testdata;
	}
}