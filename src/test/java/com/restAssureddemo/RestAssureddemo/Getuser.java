package com.restAssureddemo.RestAssureddemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getuser{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		
		Response res=req.get("api/users?page=2");
		
		System.out.println(res.asPrettyString());
		System.out.println(res.asString());
		System.out.println(res.statusCode());
		System.out.println(res.getStatusLine());

	}

}
