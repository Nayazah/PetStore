package utilities;

public enum ApiRresource {
	
	AddpetAPI("/v2/pet"),
	GetPetAPI("/v2/pet/"),
	DeletePetAPI("/v2/pet");
	private String resource;
	
	ApiRresource(String resource) {
		// TODO Auto-generated constructor stub
		 this.resource = resource;
	}
 
	 public String getresource() {
		return resource;
		 
	 }
	
     
}
