package tests;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class PatchExample {

	@Test
	public void test1() {
		
		JSONObject request=new JSONObject();
		request.put("first_name", "Heshika");
		baseURI="http://localhost:3000/Employee";
		given().body(request.toJSONString()).when().patch("1").then().statusCode(200).log().all();
		
		
	}
}
