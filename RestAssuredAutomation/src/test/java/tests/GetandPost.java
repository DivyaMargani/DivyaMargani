package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetandPost {
	/*@Test(priority=1)
	public void test2() {
		baseURI="https://reqres.in/api";
		
		given().
		get("/users?page=2").
		then().statusCode(200).
		body("data[4].first_name",equalTo("George") );
		//body("data.first_name",hasItems("Geaorge","rachel"));
		
	}*/

@Test
public void test2() {
	
	JSONObject request=new JSONObject();
	request.put("name", "Divya");
	request.put("job", "Engineer");
	
	System.out.println(request.toJSONString());
	
	baseURI="https://reqres.in/api";
	given().body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();

}
		
}
