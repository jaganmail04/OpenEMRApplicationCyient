package com.cyient.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelUtils {
	
	public static Object[][] getSheetIntoObjectArray(String filepath,String sheetname) throws IOException
	{
		FileInputStream file=new FileInputStream(filepath);
		HSSFWorkbook book=new HSSFWorkbook(file);
		HSSFSheet sheet=book.getSheet(sheetname);
				
		
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
		return main;
	}

}
