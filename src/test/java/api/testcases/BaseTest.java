package api.testcases;

 

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payload.User;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

public class BaseTest {
	
	Faker faker;
	User payload;
	
	@BeforeClass
	 public void GenerateTestData() {
		 
		 faker = new Faker();		
		 payload = new User();
		 
		// payload.setId(faker.idNumber().hashCode());
		 payload.setUsername(faker.name().username());
		 payload.setFirstName(faker.name().firstName());
		 payload.setLastName(faker.name().firstName());
		 payload.setEmail(faker.internet().safeEmailAddress());
		 payload.setPassword(faker.internet().password(5,10));
		  payload.setPhone(faker.phoneNumber().cellPhone());
	 }
	
	@Test(priority = 1)
	 public void TestCreateuser() throws FileNotFoundException {
	
		
	 Response response =   userendpoints.CreateUser(payload);
	 
	  response.then().log().all();
	 
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
	 
	 }
	
    @Test(priority = 2)
	 public void Getuser() throws FileNotFoundException {
    	
     
			Response response =   userendpoints.GetUser(this.payload.getUsername());		
			 response.then().log().all();		
			 System.out.println(response.asString());
			  Assert.assertEquals(response.getStatusCode(), 200);
		 	 
		  
		 }
	
    @Test(priority = 3)
    public void Updateuser() throws FileNotFoundException {
    	
    	 payload.setFirstName(faker.name().firstName());
		 Response response =   userendpoints.UpdateUser(this.payload.getUsername(),payload);		 
		  response.then().log().all();		 
		  Assert.assertEquals(response.getStatusCode(), 200);		  		 
		 }
    
    @Test(priority = 4)
    public void Deleteuser() {
    	 
		 Response response =   userendpoints.Deleteruser(this.payload.getUsername());		 
		  response.then().log().all();		 
		  Assert.assertEquals(response.getStatusCode(), 200);		  	
    	
    }
    
}
