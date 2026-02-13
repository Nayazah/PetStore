package com.PetModule;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPetfromstore {
	
	String uri = "https://petstore.swagger.io";
	String baseurl = "/v2/pet/125";
	
	@Test
	
	public void Getpet() {
		
		RestAssured.baseURI=uri;

		Response res= RestAssured.given().queryParam("id", "125").header("Content-Type","application/json")
		.when()
		. get("/v2/pet/").
		then().log().all().assertThat().statusCode(200).contentType("application/json").extract().response();

		 System.out.println("resposne" + res.asString()) ;
		
		
	}

}
