

package StepDefinition1;

import org.junit.Assert;

//import org.junit.Assert;

//import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class user {
	RequestSpecification req;
	Response res;
	JsonPath path;
	
	
	@Given("is on reqres url")
	public void is_on_reqres_url() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		RestAssured.baseURI="https://reqres.in/";
		req=RestAssured.given();
		System.out.println("Given");
	}

	@When("user click users API")
	public void user_click_users_api() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		res=req.get("api/users?page=2");
		System.out.println("When");
	}

	@Then("all the users is displayed")
	public void all_the_users_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		String data=res.asPrettyString();
		
		JsonPath path=res.jsonPath();
		String id=path.getString("data[1].id");
		//Assert.assertEquals(id,"8");
		//Assert.assertEquals(id, "8", "mismatch");
		Assert.assertEquals(id,"8");
		System.out.println("Then");
	}
	

}

