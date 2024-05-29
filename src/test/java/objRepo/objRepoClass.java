package objRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class objRepoClass {
	RequestSpecification req;
	Response res;
	//private Object name;
	File file;
	FileInputStream fis;

  @BeforeTest
  public void init() {
	  RestAssured.baseURI="https://reqres.in/";
  }
  @Test()
  //@Parameters({"name","job"})
  public void addData() throws IOException{
	  file =new File("C:\\Users\\SHAIKINB\\eclipse-workspace\\RestAssureddemo\\src\\test\\java\\objRepo\\postdata.properties");
	  fis=new FileInputStream(file);
	  Properties p=new Properties();
	  p.load(fis);
	  String name=p.getProperty("name");
	  String job=p.getProperty("job");
	  
	  req=RestAssured.given();
	  JSONObject obj=new JSONObject();
	  	obj.put("name",name);
		obj.put("job",job);
		req.headers("Content-Type","application/json");
		res=req.body(obj.toJSONString()).post("/api/users");
		System.out.println(res.asPrettyString());
		//System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(),201);
		JsonPath data=res.jsonPath();
		String j=data.getString("job");
		System.out.println(j);
		String id=data.getString("id");
		System.out.println(id);
		String n=data.getString("name");
		System.out.println(n);
		Assert.assertEquals(n,name);
		Assert.assertEquals(n,name);
		Assert.assertEquals(j,job);
		Assert.assertEquals(j,job);

  }

  @AfterTest
  public void deallocateMemory() {
	  req=null;
	  res=null;
  }
 

}
