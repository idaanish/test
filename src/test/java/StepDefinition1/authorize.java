package StepDefinition1;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class authorize {
	RequestSpecification req;
	Response res;
	JSONObject obj=new JSONObject(); //for request for we use JSONObject 
	JsonPath path;                   // for response purpose we use the JsonPath
	
	@Given("user open the bookstore api web")
	public void user_open_the_bookstore_api_web() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		RestAssured.baseURI="https://bookstore.toolsqa.com/";
		req=RestAssured.given().header("Content-Type","application/json");
		
	}

	@When("use click on the authorize option")
	public void use_click_on_the_authorize_option() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		obj.put("userName", "postman");
		obj.put("password","Testpassword@123");
		req.auth().basic("postman", "TestPassword@123").body(obj.toJSONString());
		  res=req.post("Account/v1/Authorized");
		  
		//res=req.body(obj.toJSONString()).auth().basic("Kumardip1", "TestPassword@123")
		//		  .post("Account/v1/Authorized");
	}

	@Then("it should authorize the user")
	public void it_should_authorize_the_user() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Authorized successfully");
		System.out.println(res.statusLine());
		System.out.println(res.asPrettyString());
		//Assert.assertEquals(200,res.asPrettyString(), true);
		Assert.assertEquals(200, res.getStatusCode());
	}


}
