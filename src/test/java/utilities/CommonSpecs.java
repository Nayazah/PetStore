package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CommonSpecs {
	
	static RequestSpecification reqspecification;
	 static ResponseSpecification resspec;
		static String uri = "https://petstore.swagger.io";
		static String baseurl = "/v2/pet";
	
	public  RequestSpecification requestSpecification() throws FileNotFoundException {
			
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		  try {
			reqspecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
					 
					  .addFilter(RequestLoggingFilter.logRequestTo(log))
					  .addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setBaseUri(uri).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				RequestSpecification Trigger = RestAssured.given().log().all().spec(reqspecification);
					
		return Trigger;
		
		
	}
	
	public  RequestSpecification getcommonspec() throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addFilter(RequestLoggingFilter.logRequestTo(log));
		builder.addFilter(ResponseLoggingFilter.logResponseTo(log));
		builder.setBaseUri(uri);
		builder.setContentType(ContentType.JSON);
		builder.setBasePath(baseurl);
		builder.build();
		
		RequestSpecification requestpspec = builder.build();		
		return requestpspec;
		
		
	}
		public  ResponseSpecBuilder commonspec() {
				 
		ResponseSpecBuilder respbuilder = new ResponseSpecBuilder();	
		 respbuilder.expectStatusCode(200);
		respbuilder.expectContentType(ContentType.JSON);
		
		ResponseSpecification respspec = respbuilder.build();
		return (ResponseSpecBuilder) respspec;
		
	}

	
}
