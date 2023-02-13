package com.qa.hs.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SearchUsingAPITest {
	
	
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://global.hitachi-solutions.com";
	}
	
	@Test
	public void searchUsingAPI() {
		
		Response response = RestAssured.given()
		        .param("s", "Construction")
		        .param("post_type", "page")
		        .get("/");

		    // Validate that the response has a 200 (OK) status code
		    response.then().statusCode(200);

		    // Validate that the search term "Construction" appears in the response body
		    response.then().body(containsString("Construction"));
							
	}

}
