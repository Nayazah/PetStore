package api.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints1;
import api.endpoints.userendpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
	
	@Test(priority=1,dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd, String phone) throws FileNotFoundException
	{

		User userPayload = new User();

		userPayload.setId((userId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone((phone));
		
		Response response = Userendpoints1.CreateUser(userPayload);

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2,dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void TEstDeleteuser(String username) {
   	 
		
		 Response response =   Userendpoints1.Deleteruser(username); 
		  response.then().log().all();		 
		  Assert.assertEquals(response.getStatusCode(), 200);		  	
   	
   }

	
}
