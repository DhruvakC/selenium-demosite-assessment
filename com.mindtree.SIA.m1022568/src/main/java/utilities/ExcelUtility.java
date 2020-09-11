package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class ExcelUtility {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	public static String[][] getExcelValue(String fileName, String sheetName) {
		String[][] arrayExcelData = null;

		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int lastRowCount = sh.getLastRowNum();
			org.apache.poi.ss.usermodel.Row r = sh.getRow(0);
			int lastColumnCount = r.getLastCellNum();

			arrayExcelData = new String[lastRowCount + 1][lastColumnCount];

			for (int i = 0; i <= lastRowCount; i++) {
				r = sh.getRow(i);

				arrayExcelData = new String[lastRowCount + 1][lastColumnCount];
				for (int j = 0; j < lastColumnCount; j++) {
					String temp = r.getCell(j, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK)
							.getStringCellValue();
					arrayExcelData[i][j] = temp;
				}
			}

		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayExcelData;

	}
}
