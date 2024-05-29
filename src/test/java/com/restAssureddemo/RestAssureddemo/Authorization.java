package com.restAssureddemo.RestAssureddemo;

import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class Authorization {
    RequestSpecification req;
    Response res;
    JSONObject obj = new JSONObject();

    @BeforeTest
    public void beforeTest() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com/";
        req = RestAssured.given().header("Content-Type", "application/json");
        obj.put("userName", "postman");
        obj.put("password", "Testpassword@123");
    }

    @Test
    public void auth() {
        res = req.auth().basic("postman", "Testpassword@123").body(obj.toJSONString()).post("Account/v1/Authorized");
        System.out.println(res.asPrettyString());
        System.out.println(res.statusLine());
    }

    @Test
    public void generateToken() {
        res = req.body(obj.toJSONString()).post("Account/v1/GenerateToken");
        System.out.println(res.asPrettyString());
        System.out.println(res.statusLine());
    }

    @AfterTest
    public void afterTest() {
        req = null;
        res = null;
    }
}
