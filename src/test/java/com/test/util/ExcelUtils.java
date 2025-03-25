package com.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public XSSFRow getRowData(int row) throws IOException {
	
	String fileLocation = "./datasource/USERDETAILS.xlsx";
	FileInputStream fileStream = new FileInputStream(fileLocation);
	XSSFWorkbook workBook = new XSSFWorkbook(fileStream);
	XSSFSheet sheet = workBook.getSheetAt(0);
	XSSFRow rowData = sheet.getRow(row);
	return rowData;
	
	
//	if(iterator.hasNext()) {
//		iterator.next();
//	}
//	while(iterator.hasNext()) {
//		XSSFRow row = (XSSFRow) iterator.next();
//		Iterator cellIterator = row.iterator();
//		while(cellIterator.hasNext()) {
//			XSSFCell cell = (XSSFCell) cellIterator.next();
//			switch(cell.getCellType()) {
//			case STRING: System.out.print(cell.getStringCellValue()+"  ");break;
//			case NUMERIC: System.out.print(cell.getNumericCellValue()+"  ");break;
//			case BOOLEAN : System.out.print(cell.getBooleanCellValue()+"  ");break;
//			}
//			
//		}
//		System.out.println();
//	}
	}
	
	
	

}
