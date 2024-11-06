package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class RequestMethods {
	int id;

	@Test(priority = 1)
	public void getUser() {

		when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("total", equalTo(12)).log().all();

	}

	@Test(priority = 2)
	public void postUser() {
		baseURI = "https://reqres.in/";
		JSONObject request = new JSONObject();
		request.put("name", "Divyasri");
		request.put("job", "QA");
		id = given().body(request.toJSONString()).when().post("api/users").jsonPath().getInt("id");
		// then().statusCode(201).log().all();

	}

	@Test(priority = 3)
	public void putUser() {

		HashMap data = new HashMap();
		data.put("name", "Divyavani");
		data.put("job", "Developer");

		given().contentType("application/json").body(data).when().put("https://reqres.in/api/users/2" + id).then()
				.statusCode(200).log().all();

	}

	@Test(priority = 4)
	public void deleteUser() {
		when().delete("https://reqres.in/api/users/2" + id).then().statusCode(204).log().all();

	}
	//commented this line

}
