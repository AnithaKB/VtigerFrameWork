package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * its used to read the data from Excel 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Anitha
	 */

	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis2 = new FileInputStream("./src\\test\\resources\\VtigerExcelTestData.xlsx");
	 	   
        //step2:-open workbook in read mode
 	Workbook book = WorkbookFactory.create(fis2);
 	
 	  //step3:-get the control of the Sheet
 	Sheet sheet = book.getSheet(sheetName);
 	
 	//step4:- get control of the row
 	Row row = sheet.getRow(rowNum);
 	
 	//step5:- get control of the cell
 	Cell cell = row.getCell(cellNum);
 	
 	String ExcelData = cell.getStringCellValue();
 	return ExcelData;
 	}
	/**
	 * This method is used to read data from Excel using DataFormatter approach 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Anitha
	 */

	public String readExcelDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis2 = new FileInputStream("./src\\test\\resources\\VtigerExcelTestData.xlsx");
	 	   
        //step2:-open workbook in read mode
 	Workbook book = WorkbookFactory.create(fis2);
 	
 	  //step3:-get the control of the Sheet
 	Sheet sheet = book.getSheet(sheetName);
 	
 	//step4:- get control of the row
 	Row row = sheet.getRow(rowNum);
 	
 	//step5:- get control of the cell
 	Cell cell = row.getCell(cellNum);
 	
 	DataFormatter format = new DataFormatter();
 	String ExcelData = format.formatCellValue(cell);
 	return ExcelData;
	}
	/**
	 * This method is used to write data to Excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void insertDataToExcel(String sheetName,int rowNum,int cellNum, String data ) throws Throwable {
FileInputStream fis = new FileInputStream("./src\\test\\resources\\ExcelTestData.xlsx");
		
		//step-2 open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step-3 get the control of the sheet
		Sheet sheet = book.getSheet(sheetName);
		
		//step-4
		Row row = sheet.createRow(rowNum);
		
		Cell cell = row.createCell(cellNum);
		
		cell.setCellValue(data);
		
		 FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\ExcelTestData.xlsx");
		 book.write(fos);
		 book.close();

	}

}
