package api.endpoints;

import org.apache.logging.log4j.core.osgi.BundleContextSelector;

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
import java.util.ResourceBundle;
public class Userendpoints1 {
	
	
	   
	 
	static ResourceBundle get_URL() 
	  {
		    ResourceBundle bundle = ResourceBundle.getBundle("Routes");
			return bundle;
	  }
	
	
	public static Response CreateUser(User payload) throws FileNotFoundException {
		
		String post_url = get_URL().getString("Post_url");
		PrintStream log = new PrintStream(new FileOutputStream("Createuserlogging.txt"));
		 Response response = given()
				 .filter(RequestLoggingFilter.logRequestTo(log))
				  .filter(ResponseLoggingFilter.logResponseTo(log))
				 .accept(ContentType.JSON)
					.contentType(ContentType.JSON)
				 
		 .body(payload)
		 
		.when()
		.post(post_url);
	 
	 return response;
		
	}
	
	
	public static Response GetUser(String username) throws FileNotFoundException {
		
		String Get_url = get_URL().getString("Get_url");
		
		PrintStream log = new PrintStream(new FileOutputStream("Getuserlogging.txt"));
		 Response response = given()
				 .accept(ContentType.JSON)
					.contentType(ContentType.JSON)
				 .filter(RequestLoggingFilter.logRequestTo(log))
				  .filter(ResponseLoggingFilter.logResponseTo(log))
				  
			.pathParam("username", username)	   
			 
			.when()
			.get(Get_url);
		 
		 return response;
			
		}

	public static Response UpdateUser(String username, User payload) throws FileNotFoundException {
		
		String Put_url = get_URL().getString("Put_url");
		
		PrintStream log = new PrintStream(new FileOutputStream("Updateuserlogging.txt"));
		 Response response = given()
				 .accept(ContentType.JSON)
					.contentType(ContentType.JSON)
				 .filter(RequestLoggingFilter.logRequestTo(log))
				  .filter(ResponseLoggingFilter.logResponseTo(log))
			
			.pathParam("username", username)
			.body(payload)
			 
			.when()
			.put(Put_url);
		 
		 return response;
			
		}
	
	public static Response Deleteruser(String username) {
		
		String Delete_url = get_URL().getString("Delete_url");
		
		 Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("username", username)
			 
			.when()
			.delete(Delete_url);
		 
		 return response;
			
		}
	 

}
