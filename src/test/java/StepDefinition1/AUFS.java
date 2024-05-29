package StepDefinition1;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AUFS {
	RequestSpecification req;
	Response res;
	JsonPath path;
	JSONObject obj;
	String expN,expJ;
	
	
	//---------------scenarios1--------------------------
	/*
	 *  created by: inthiyaz smy
	 *  reviewed by: kkkkk
	 *  Description: this scenario is adding the user
	 *  
	 */
	@Given("user1 is on reqres URL")
	public void user1_is_on_reqres_url1() {
		RestAssured.baseURI="https://reqres.in/";
		req=RestAssured.given();
		System.out.println("Given ");


	}

	@When("user1 enters the {string} and {string}")
	public void user1_enters_the_and(String name, String job) {
		obj=new JSONObject();
		obj.put("name",name);
		obj.put("job",job);
		expN=name;
		expJ=job;
		req.headers("Content-Type","application/json");
		System.out.println(obj);
		System.out.println("When ");
	    
	}

	@And("user1 hit the users API")
	public void user1_hit_the_users_api() {
		res=req.body(obj.toJSONString()).post("/api/users");
		System.out.println("And ");
	    
	}

	@Then("users1 are added to list")
	public void users1_are_added_to_list() {
		System.out.println(res.asPrettyString());
		path=res.jsonPath();
		String job1=path.getString("job");
		System.out.println(job1);
		Assert.assertEquals(job1,expJ);
		System.out.println("then");
	    
	}
	
	

	
	
	
	//--------------Scenarios-2-----------------------------
	/*
	 *     created by: inthiyaz smy
	 *     reviewed by: kkkkk
	 *     Description: This step is used to update the user
	 * 
	 */
	//@Given("user1 is on reqres ")
	//public void user1_is_on_reqres_url() {
	    
	//}
	@When("user1 enters name and job")
	public void user1_enters_name_and_job(DataTable data) {
		List<List<String>> userdata= data.asLists(String.class);
		String name=userdata.get(0).get(0);
		String job=userdata.get(0).get(1);
		
		
		obj=new JSONObject();
		obj.put("name", name);
		obj.put("job", job);
		expN=name;
		expJ=job;
		
		req.header("Content-Type","application/json");
		System.out.println(obj);
		System.out.println("When step");
		
		
		
		
	    
	}
	@And("user1 click the the api")
	public void user1_click_the_the_api() {
		res=req.body(obj.toJSONString()).put("api/users/2");
		System.out.println(obj);
		System.out.println("And step");
		
	    
	}

	@Then("user data is updated")
	public void user_data_is_updated() {
		System.out.println(res.asPrettyString());
		path=res.jsonPath();
		String job1=path.getString("job"); //written expj got error and and error in output
		System.out.println(job1);
		Assert.assertEquals(job1, expJ);
		System.out.println("Then step");
	    
	}

	

}
