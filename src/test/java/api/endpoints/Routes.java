package api.endpoints;

public class Routes {
	
	// creatue = 'https://petstore.swagger.io/v2/user
	// getuser ='https://petstore.swagger.io/v2/user/{username}' 
	//  -H 'accept: application/json' \
	//  -H 'Content-Type: application/json' \
	//post = https://petstore.swagger.io/v2/user/createWithArray' 
  // update = 'https://petstore.swagger.io/v2/user/{username}'
	// delete = https://petstore.swagger.io/v2/user/{username}
	
	
	public static String base_url = "https://petstore.swagger.io/v2" ;
	public static String post_url = base_url + "/user";
	public static String GET_url =   base_url + "/user/{username}";
	public static String Put_url =   base_url + "/user/{username}";
	public static String Delete_url =   base_url + "/user/{username}";
	
	
	
	
	
	
	
	
	
}
