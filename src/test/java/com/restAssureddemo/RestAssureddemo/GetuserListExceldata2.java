package com.restAssureddemo.RestAssureddemo;

import org.testng.annotations.Test;

//package com.restAssureddemo.RestAssureddemo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
 
public class GetuserListExceldata2 {
	RequestSpecification req;
	Response res;
	JSONObject obj=new JSONObject();
	JsonPath data;
	File file;
	FileInputStream fis;
	//XSSFWorkbook w;
	//XSSFSheet s;
	XSSFWorkbook w;
	XSSFSheet s;
	
	@DataProvider(name="createuser")
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
	//Return data1;
  @BeforeTest
  
  public void init() {
	  RestAssured.baseURI="https://reqres.in/";
	  //req=RestAssured.given();
  }
  //@SuppressWarnings("deprecation")
@Test(dataProvider="createuser")
  public void adddata(String name,String job) {
	  req=RestAssured.given();
	 // JSONObject obj=JSONObject();
	  obj.put("name", name);
	  obj.put("job", job);
	  
	  req.headers("Content-Type","application/json");
	  res=req.body(obj.toJSONString()).post("api/users");
	  System.out.println(obj);
	  data=res.jsonPath();
	  String jobdata=data.getString("job");
	  System.out.println(jobdata);
	  //Assert.assertEquals(jobdata, job);
	  AssertJUnit.assertEquals(jobdata, job);
	  
  }
//  private JSONObject JSONObject() {
//	// TODO Auto-generated method stub
//	return null;
//} 
/*
  @Test
  public void createUser() throws Exception{
	  file=new File("C:\\Users\\SHAIKINB\\eclipse-workspace\\RestAssureddemo\\src\\test\\resource\\Excel\\Exceldemo.xlsx");
	  fis=new FileInputStream(file);
	  w=new XSSFWorkbook(fis);
	  s=w.getSheetAt(0);
	  //s=w.getSheet("userdata");
	  String name=s.getRow(1).getCell(0).toString();
	  String job=s.getRow(1).getCell(1).toString();
	  obj.put("name", name);
	  obj.put("job", job);
	  req.headers("Content-Type","application/json");
	  res=req.body(obj.toJSONString()).post("api/users");
	  data=res.jsonPath();
	  int row=s.getPhysicalNumberOfRows();
	  int column=s.getRow(0).getPhysicalNumberOfCells();
	  System.out.println(row);
	  System.out.println(column);
	  System.out.println(res.asPrettyString());
	  System.out.println(res.statusLine());
	  AssertJUnit.assertEquals(data.getString("name"), name);
  }
  */
 
  @AfterTest
  public void afterTest() {
	  req=null;
	  res=null;
	  data=null;
	  file=null;
	  fis=null;
  }
 
}