package com.restAssureddemo.RestAssureddemo;

import org.testng.annotations.Test;



import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
 
public class reportsHtml {
	RequestSpecification req;
	Response res;
	JSONObject obj=new JSONObject();
	JsonPath data;
	File file;
	FileInputStream fis;
	XSSFWorkbook w;
	XSSFSheet s;
	ExtentReports report;
	ExtentTest test;
	/*
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
	*/

  @BeforeTest
  public void beforeTest() {
	  RestAssured.baseURI="https://reqres.in/";
	  req=RestAssured.given();
	  report=new ExtentReports("C:\\Users\\SHAIKINB\\Desktop\\report\\api.html");
	  test=report.startTest("Getting Data from Excel", "This is description");
  }
  //@Test(dataProvider="createuser")
  @Test(dataProvider="getData",dataProviderClass=Data.class)
  public void addUser(String name,String job) {
	  obj.put("name", name);
	  obj.put("job", job);
	  req.headers("Content-Type","application/json");
	  res=req.body(obj.toJSONString()).post("api/users");
	  data=res.jsonPath();
	  System.out.println(res.asPrettyString());
	  System.out.println(res.statusLine());
	  AssertJUnit.assertEquals(data.getString("name"),name);
	  if(name.equals(data.getString("name"))) {
		  test.log(LogStatus.PASS, "Data is valid for Expected "+name+" and actual is "+data.getString("name"));
	  }
	  else {
		  test.log(LogStatus.FAIL, "Data is invalid for "+name+" and actual is "+data.getString("name"));
	  }
  }
 
  @AfterTest
  public void afterTest() {
	  req=null;
	  res=null;
	  fis=null;
	  file=null;
	  obj=null;
	  data=null;
	  report.endTest(test);
	  report.flush();
  }
 
}