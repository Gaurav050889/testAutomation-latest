package com.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public Object[][] getExcelData(String fileName, String sheetName) throws IOException {

		Workbook workbook = null;
		Object[][] obj = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(1);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfColumns = row.getPhysicalNumberOfCells();
			Cell cell;
			obj = new Object[noOfRows - 1][noOfColumns];
			System.out.println("The number of rows is " + noOfRows);
			System.out.println("The number of columns is " + noOfColumns);

			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);

					switch (cell.getCellType()) {

					case STRING:
						obj[i - 1][j] = cell.getStringCellValue();
						break;

					case NUMERIC:
						obj[i - 1][j] = cell.getNumericCellValue();
						break;
					case BLANK:
						obj[i - 1][j] = "";
						break;
					default:
						obj[i - 1][j] = null;
						break;

					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
