
package com.espocrm.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

	public static Object[][] getSheetData(String excelPath, String sheetName) {
		Object[][] data;

		try (FileInputStream fis = new FileInputStream(excelPath); 
				Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getLastCellNum();

			data = new Object[rows - 1][cols];

			for (int i = 1; i < rows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < cols; j++) {
					Cell cell = row.getCell(j);

					if (cell == null) {
						data[i - 1][j] = "";
					} else if (cell.getCellType() == CellType.STRING) {
						data[i - 1][j] = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.BOOLEAN) {
						data[i - 1][j] = cell.getBooleanCellValue();
					} else {
						data[i - 1][j] = String.valueOf(cell);
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to read Excel file: " + excelPath, e);
		}

		return data;
	}
}
