package tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class LocalApis {

	//@Test
	public void test1() {
		
		baseURI="http://localhost:3000/";
		given().get("0").then().statusCode(200).log().all();

	}
	@Test
	public void test2() {
		JSONObject request=new JSONObject();
		request.put("first_name", "Divya");
		request.put("last_name", "vani");
		request.put("email", "ddivya@123");
		request.put("gender", "female");
		request.put("ip_address", "180.66.162.255");
		baseURI="http://localhost:3000/Employee";
		given().body(request.toJSONString()).when().post().then().statusCode(201).log().all();

	}
	
}
