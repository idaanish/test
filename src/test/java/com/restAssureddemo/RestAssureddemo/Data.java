package com.restAssureddemo.RestAssureddemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data {
	File file;
	FileInputStream fis;
	XSSFWorkbook w;
	XSSFSheet s;
	
	//@DataProvider(name="createuser")
	@DataProvider
	public Object[][] getData() throws IOException{
		file=new File("C:\\Users\\SHAIKINB\\eclipse-workspace\\RestAssureddemo\\src\\test\\resource\\Excel\\Exceldemo.xlsx");
		fis=new FileInputStream(file);
		w=new XSSFWorkbook(fis);
		s=w.getSheetAt(0);
		int row=s.getPhysicalNumberOfRows();
		int col=s.getRow(0).getPhysicalNumberOfCells();		
		Object[][] data=new Object[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				data[i][j]=s.getRow(i).getCell(j).toString();				
			}
		}
		return data;		
	}
}
