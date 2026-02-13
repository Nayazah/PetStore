package api.utilities;

import java.io.FileNotFoundException;

 
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userendpoints;
import io.restassured.response.Response;

 
public class GetuserdataTest {
	
	 
	 @Test(dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	 
	
	public void testGetUserData(String username) throws FileNotFoundException
	{

		Response response = userendpoints.GetUser(username);

		//System.out.println("Get User Data.");
           
		System.out.println(response.asPrettyString());
		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);


	}

}
