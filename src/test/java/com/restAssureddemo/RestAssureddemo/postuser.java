package com.restAssureddemo.RestAssureddemo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postuser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://reqres.in/";

        // Create request specification
        RequestSpecification req = RestAssured.given();

        // Create JSON object for request body
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "head");
        requestParams.put("job", "QA Eng");

        // Add request body to the request
        req.body(requestParams.toJSONString());

        // Send POST request and get response
        Response response = req.post("/api/users");

        // Print response body and status line
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
        System.out.println("Status Line:");
        System.out.println(response.getStatusLine());

	}

}
