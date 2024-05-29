package com.restAssureddemo.RestAssureddemo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Putuser {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		JSONObject obj=new JSONObject();
		obj.put("name", "A");
		obj.put("job", "software");
		req.body(obj.toJSONString());
		Response res=req.put("api/users/2");
		System.out.println(res.asPrettyString());
		System.out.println(res.getStatusLine());
	}
}


