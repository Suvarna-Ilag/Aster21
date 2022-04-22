package com.Dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
	@DataProvider(name = "Data")
	public Object[][] dataprovider() throws IOException {
		String[][] data = null;
	

		FileInputStream fis = new FileInputStream("E:\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		XSSFRow row = sh.getRow(1);
		int noOfRows = sh.getLastRowNum();
		int noOfCols = row.getLastCellNum();
		Cell cell;
		data = new String[noOfRows][noOfCols-1];
		for (int i = 1; i < noOfRows; i++) {
			for (int j = 1; j < noOfCols; j++) {
				row = sh.getRow(i);
				cell = row.getCell(j);
				data[i-1][j-1] = cell.getStringCellValue();
			}
		}

		return data;

	}
}
