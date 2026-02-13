package api.endpoints;

import org.htmlunit.javascript.host.ApplicationCache;

import api.payload.User;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userendpoints {
	
	
	public static Response CreateUser(User payload) throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new FileOutputStream("Createuserlogging.txt"));
		 Response response = given()
				 .filter(RequestLoggingFilter.logRequestTo(log))
				  .filter(ResponseLoggingFilter.logResponseTo(log))
				 .accept(ContentType.JSON)
					.contentType(ContentType.JSON)
				 
		 .body(payload)
		 
		.when()
		.post(Routes.post_url);
	 
	 return response;
		
	}
	
	
	public static Response GetUser(String username) throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new FileOutputStream("Getuserlogging.txt"));
		 Response response = given()
				 .accept(ContentType.JSON)
					.contentType(ContentType.JSON)
				 .filter(RequestLoggingFilter.logRequestTo(log))
				  .filter(ResponseLoggingFilter.logResponseTo(log))
				  
			.pathParam("username", username)	   
			 
			.when()
			.get(Routes.GET_url);
		 
		 return response;
			
		}

	public static Response UpdateUser(String username, User payload) throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new FileOutputStream("Updateuserlogging.txt"));
		 Response response = given()
				 .accept(ContentType.JSON)
					.contentType(ContentType.JSON)
				 .filter(RequestLoggingFilter.logRequestTo(log))
				  .filter(ResponseLoggingFilter.logResponseTo(log))
			
			.pathParam("username", username)
			.body(payload)
			 
			.when()
			.put(Routes.Put_url);
		 
		 return response;
			
		}
	
	public static Response Deleteruser(String username) {
		
		 Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("username", username)
			 
			.when()
			.delete(Routes.Put_url);
		 
		 return response;
			
		}
	 

}
