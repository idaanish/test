package com.testng1;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUser {
	RequestSpecification req;
	Response res;
	@BeforeTest
	public void init()
	{
		RestAssured.baseURI="https://reqres.in/";
	}
  @Test(priority=-1)
  public void getData() 
  {
	  req=RestAssured.given();
	  res=req.get("api/users?page=2");
	  System.out.println(res.asString());
	  JsonPath data=res.jsonPath();
	  String email=data.getString("data[1].email");
	  System.out.println(email);
	  Assert.assertEquals(email, "lindsay.ferguson@reqres.in");
	  String first_name=data.getString("data[0].first_name");
	  System.out.println(first_name);
	  Assert.assertEquals(first_name, "Michael");
	  String id=data.getString("data[0].id");
	  System.out.println(id);
	  Assert.assertEquals(id, "7");
	  String page=data.getString("page");
	  System.out.println(page);
	  Assert.assertEquals(page, "2");
	  }
  @Test(priority=0)
  public void addData()
  {
	  req=RestAssured.given();
	  JSONObject obj=new JSONObject();
	  obj.put("name", "B");
	  obj.put("job", "analyst");
	  req.header("Content-Type", "application/json");
	  res=req.body(obj.toJSONString()).post("api/users");
	  System.out.println(obj);
	  JsonPath data=res.jsonPath();
	  String name=data.getString("name");
	  System.out.println(name);
	  Assert.assertEquals(name, "B");
	  String job=data.getString("job");
	  System.out.println(job);
	  Assert.assertEquals(job, "analyst");

	  req.body(obj.toJSONString());
	  res=req.post("api/users");
	  System.out.println(res.asPrettyString());

  }
  @AfterTest
  public void deallocateMem()
  {
	  req=null;
	  res=null;
  }
}
