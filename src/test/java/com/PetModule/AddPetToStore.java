package com.PetModule;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
 
import utilities.Petdatapaylaod;


public class AddPetToStore {
	
	
	String uri = "https://petstore.swagger.io";
	String baseurl = "/v2/pet";
	
	@Test
	
	public void AddPetToStores() {
		
		RequestSpecification reqspec = new RequestSpecBuilder().setContentType(ContentType.JSON)
		.setBaseUri(uri).build();
		
		RequestSpecification Trigger = RestAssured.given().log().all().spec(reqspec).body(Petdatapaylaod.Catpayload());
		
		 ResponseSpecification resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				 .expectStatusCode(200).build();
		 
		 
		 Response  response = Trigger.when().post(baseurl).then().spec(resspec).extract().response();
		  
		  System.out.println(response.asString());
		  
		  String resp = response.asString();
			
			JsonPath jpath = new JsonPath(resp);
			
		String	nameval = jpath.get("name");
			
			 System.out.println("actual name of anmial is:" + nameval);	
		
				
	}

}
