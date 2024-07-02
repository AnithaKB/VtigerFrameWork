package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Generic_Utilities.Excel_Utility;

public class InsertSingleDataToExcel {

	public static void main(String[] args) throws Throwable {
//		//step-1 path connections
//		FileInputStream fis = new FileInputStream("./src\\test\\resources\\ExcelTestData.xlsx");
//		
//		//step-2 open workbook in read mode
//		Workbook book = WorkbookFactory.create(fis);
//		
//		//step-3 get the control of the sheet
//		Sheet sheet = book.getSheet("Sheet1");
//		
//		//step-4
//		Row row = sheet.createRow(5);
//		
//		Cell cell = row.createCell(5);
//		
//		cell.setCellValue("Welcome");
//		
//		 FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\ExcelTestData.xlsx");
//		 book.write(fos);
//		 book.close();
		
		Excel_Utility elib = new Excel_Utility();
		elib.insertDataToExcel(null, 0, 0, null);
		

	}

}
