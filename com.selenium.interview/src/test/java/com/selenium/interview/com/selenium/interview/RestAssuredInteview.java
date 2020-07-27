package com.selenium.interview.com.selenium.interview;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class RestAssuredInteview {
	public static HashMap map = new HashMap();

	@Test
	public void getRequest() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7))
				.body("data.first_name", hasItems("Michael", "Lindsay")).statusCode(200).statusLine("HTTP/1.1 200 OK")
				.log().all();
	}

	@Test
	public void postRequest() {
		map.put("FirstName", "Abhishek");
		map.put("LastName", "Singh");
		given().contentType("application/json").body(map).when().post("https://reqres.in/api/users").then()
				.statusCode(201).statusLine("HTTP/1.1 201 Created").log().all();
	}
}
