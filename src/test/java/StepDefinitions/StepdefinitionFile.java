package StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.ApiRresource;
import utilities.CommonSpecs;
 
import utilities.Petdatapaylaod;
 


public class StepdefinitionFile extends CommonSpecs {
	
	String uri = "https://petstore.swagger.io";
	String baseurl = "/v2/pet";
	 
  Response  response;
  RequestSpecification res;
  ResponseSpecification resspec;
  String nameval;
  int idvalue;

  @Given("add PET API is there with {string} {string} {string}")
  public void add_pet_api_is_there_with(String id, String name, String status) throws FileNotFoundException {
      
		
	  
		 res = RestAssured.given().spec(requestSpecification()).body((Petdatapaylaod.AddPetPayload(id, name, status)));
		 			 
	   
	}
	
  @When("I post the {string} with http {string} request")
  public void i_post_the_with_http_request(String resource, String method) {
		
		ApiRresource resourceAPI=  ApiRresource.valueOf(resource);
		System.out.println(resourceAPI.getresource());
		//ResponseSpecification resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
			//	 .expectStatusCode(200).build();		
		
		if (method.equalsIgnoreCase("Post"))
		 
		    response = res.when().post(resourceAPI.getresource());
		    else if(method.equalsIgnoreCase("GET"))
		    	response = res.when().get(resourceAPI.getresource());
                 System.out.println("payload is" + response.asString());
	  
	}
	@Then("API call got success with return code {int}")
	public void api_call_got_success_with_return_code(Integer int1) {
		
		assertEquals(response.getStatusCode(), 200);
	     
	}
	@Then("{string} in response body is {string}")
	public void status_code_is_ok(String key, String value) {
		
		String val =  response.asString();
		JsonPath jpath = new JsonPath(val);
		assertEquals(jpath.get(key).toString(),value);
		idvalue = jpath.get("id");
	 
		
	     
	}

	
	@Then("verify id is mapped to animal {string} using {string}")
	public void verify_id_is_mapped_to_animal_using(String expname, String resource) throws FileNotFoundException {
	     
		
		  //String baseurl = "/v2/pet" + "/" + idvalue;
				  				
				RequestSpecBuilder reqBuilder  = new RequestSpecBuilder();
				reqBuilder.setBaseUri("https://petstore.swagger.io");
				reqBuilder.setBasePath("/v2/pet" + "/" + idvalue);
				
				RequestSpecification reqspec = reqBuilder.build();
				
				
			     Response response =  reqspec.when().get();
		
		  System.out.println("payload is" + response.asString());
			//System.out.println("actual name of animal is:" + nameval);	
		
	}
	
}
