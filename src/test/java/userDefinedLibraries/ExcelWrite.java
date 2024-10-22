package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***********************************************************************************
*                                                                                  *
* Class Name     : ExcelWrite                                                      * 
* Description    : To Write the output on the excel sheet.                         *
*                                                                                  *
************************************************************************************/

public class ExcelWrite {

	public static FileOutputStream fileOP;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet = null;
	public static XSSFCell cell = null;
	public static XSSFCell cell2 = null;
	public static XSSFRow row = null;
	public static String exFilePath1 = "./src/test/java/dataTables/BookShelvesBelow15000.xlsx";
	public static String exFilePath2 = "./src/test/java/dataTables/ByAtHomeBookShelves.xlsx";
	
	public static void below15000BookShelves(String[] bookShelves , String[] prices , int x) {

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Below_15000");

		for (int i = 1; i <= x; i++) {
			
			row = ExcelWrite.sheet.getRow(i);
			
			if (row == null)
				row = ExcelWrite.sheet.createRow(i);
		
			cell = row.getCell(0);
			
			if (cell == null)
				cell = row.createCell(0);
			
			cell.setCellValue(bookShelves[i-1]);
			
			cell2 = row.getCell(1);
			
			if (cell2 == null)
				cell2 = row.createCell(1);
			
			cell2.setCellValue(prices[i-1]);
			
		}
		
		try {

			fileOP = new FileOutputStream(new File(exFilePath1));
			workbook.write(fileOP);
			fileOP.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	public static void byAtHomeBookshelves(String[] bookShelves , String[] prices , int x) {
		
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("By@Home");

		for (int i = 1; i <= x; i++) {
			
			row = ExcelWrite.sheet.getRow(i);
			
			if (row == null)
				row = ExcelWrite.sheet.createRow(i);
		
			cell = row.getCell(0);
			
			if (cell == null)
				cell = row.createCell(0);
			
			cell.setCellValue(bookShelves[i-1]);
			
			cell2 = row.getCell(1);
			
			if (cell2 == null)
				cell2 = row.createCell(1);
			
			cell2.setCellValue(prices[i-1]);
			
		}
		
		try {

			fileOP = new FileOutputStream(new File(exFilePath2));
			workbook.write(fileOP);
			fileOP.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
	}
	
}
