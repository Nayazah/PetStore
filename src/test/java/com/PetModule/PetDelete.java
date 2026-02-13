package com.PetModule;

import org.testng.annotations.Test;

 

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PetDelete {
	
	String uri = "https://petstore.swagger.io";
	String baseurl = "/v2/pet/126";
	
	RequestSpecification reqspec = new RequestSpecBuilder().setBaseUri(uri)
			 .setContentType(ContentType.JSON).build();
	 
	 RequestSpecification res = RestAssured.given().log().all().spec(reqspec);
	 
	  ResponseSpecification resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
	           .expectStatusCode(200).build();
	
	  @Test
	  
		 public void deletePet() {
			 
			 Response resp = res.when().delete(baseurl)
			          .then().spec(resspec).extract().response();
			 
			 System.out.println(resp.asString());
		 }
	  
      
	

}
