package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		//step-1 path connections
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\ExcelTestData.xlsx");
		
		//step-2 open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step-3 get the control of the sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//step-4 get control of the row
		Row row = sheet.getRow(0);
		
		//step-5 get control of the cell
		Cell cell = row.getCell(0);
		
		String ExcelData = cell.getStringCellValue();
		System.out.println(ExcelData);
	}

}
