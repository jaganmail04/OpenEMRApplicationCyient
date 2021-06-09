package com.cyient.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.helpers.HSSFColumnShifter;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;

public class DemoTest {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("src\\test\\resources\\data\\OpenEMRData.xls");
		HSSFWorkbook book=new HSSFWorkbook(file);
		HSSFSheet sheet=book.getSheet("ValidCredentialTest");
				
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int columCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
	
				Object[][] main=new Object[rowCount-1][columCount];	
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<columCount;j++) {
				HSSFRow row=sheet.getRow(i);
				HSSFCell cell=row.getCell(j);
				
				DataFormatter format=new DataFormatter();
				
		
				String cellValue=format.formatCellValue(cell);
				System.out.println(cellValue);
				main[i-1][j]=cellValue;								
				
			
		}
		
		
		}
		System.out.println(main);
				
	}

}
