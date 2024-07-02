package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelUsingMap {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("D:\\ANITHA\\ADVANCE SELENIUM\\ExcelTestData.xlsx");
        Workbook book = WorkbookFactory.create(fis);
        Sheet sheet = book.getSheet("Sheet3");
//
//        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//        map.put("10", "hyd");
//        map.put("20", "Bangalore");
//        map.put("30", "Goa");
//        map.put("40", "pune");
//        
//        int rowNo=0;
//        for (Entry<String, String> m : map.entrySet()) 
//        {
//        	Row row = sheet.createRow(rowNo++);
//        	row.createCell(0).setCellValue((String)m.getKey());
//        	row.createCell(1).setCellValue((String)m.getValue());
//		}
//        FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\ExcelTestData.xlsx");
//        book.write(fos);
//        book.close();
       // -----------------------------------------------------------------------------------------

        
        LinkedHashMap<Integer, String> mp = new LinkedHashMap<Integer, String>();
        mp.put(10, "Swetha");
        mp.put(20, "Shobha");
        mp.put(30, "Dileep");
        mp.put(40, "Chetna");
        
        int rowNm=0;
        for (Entry<Integer, String> mmm : mp.entrySet()) 
        {
			Row row = sheet.createRow(rowNm++);
			row.createCell(0).setCellValue((Integer)mmm.getKey());
			row.createCell(1).setCellValue((String)mmm.getValue());
		}
        
        FileOutputStream fos1 = new FileOutputStream("D:\\ANITHA\\ADVANCE SELENIUM\\ExcelTestData.xlsx");
        book.write(fos1);
        book.close();
        System.out.println("data added successfully");
	}

}
