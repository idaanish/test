package com.restAssureddemo.RestAssureddemo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deluser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		JSONObject obj=new JSONObject();
//		obj.put("name", "B");
//		obj.put("job", "Developer");
		req.body(obj.toJSONString());
		Response res=req.delete("api/users/2");
		System.out.println(res.asPrettyString());
		System.out.println(res.getStatusLine());

	}

}
