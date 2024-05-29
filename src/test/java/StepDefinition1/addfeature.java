package StepDefinition1;

//public class addfeature {

//}

//package Steps;

import org.json.simple.JSONObject;
import org.testng.Assert;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class addfeature {
	RequestSpecification req;
	Response res;
	JsonPath path;
	JSONObject obj;
	String expN,expJ;
	@Given("user is on reqres url")
	public void user_is_on_reqres_url() {
		RestAssured.baseURI="https://reqres.in/";
		req=RestAssured.given();
		System.out.println("Given Step");
	}
 
	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String name, String job) {
		obj=new JSONObject();
		obj.put("name",name);
		obj.put("job",job);
		expN=name;
		expJ=job;
		req.headers("Content-Type","application/json");
		System.out.println(obj);
		System.out.println("When step");

	}
 
	@And("user hit the users API")
	public void user_hit_the_users_api() {
		res=req.body(obj.toJSONString()).post("/api/users");
		System.out.println("And step");
	}
 
	@Then("users are added to list")
	public void users_are_added_to_list() {
		System.out.println(res.asPrettyString());
		path=res.jsonPath();
		String job1=path.getString("job");
		System.out.println(job1);
		Assert.assertEquals(job1,expJ);

	}
 
 
}