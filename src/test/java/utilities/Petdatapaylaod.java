package utilities;

public class Petdatapaylaod {
	
	 
		
		public static String  AddPetPayload(String key, String nameval, String status) {
			
			 
			
			return "{\r\n"
					+ "  \"id\": \"" +key+"\",\r\n"
					+ "  \"category\": {\r\n"
					+ "    \"id\":\" "+key+ "\",\r\n" 
					+ "    \"name\": \"name\"\r\n"
					+ "  },\r\n"
					+ "  \"name\": \" " + nameval +"\",\r\n"
					+ "  \"photoUrls\": [\r\n"
					+ "    \"photo_4_url\"\r\n"
					+ "  ],\r\n"
					+ "  \"tags\": [\r\n"
					+ "    {\r\n"
					+ "      \"id\": 644754,\r\n"
					+ "      \"name\": \"Lazy_star\"\r\n"
					+ "    }\r\n"
					+ "  ],\r\n"
					+ "  \"status\": \"" +status+ "\"\r\n"
					+ "}";
			
		}
		
		
		
		public static String Catpayload() {
			return "{\r\n"
					+ "    \"id\": 126,\r\n"
					+ "    \"category\": {\r\n"
					+ "        \"id\": 23077,\r\n"
					+ "        \"name\": \"Muffin Parrot\"\r\n"
					+ "    },\r\n"
					+ "    \"name\": \"Parrot\",\r\n"
					+ "    \"photoUrls\": [\r\n"
					+ "        \"photo_4_url\"\r\n"
					+ "    ],\r\n"
					+ "    \"tags\": [\r\n"
					+ "        {\r\n"
					+ "            \"id\": 644754,\r\n"
					+ "            \"name\": \"Lazy_star\"\r\n"
					+ "        }\r\n"
					+ "    ],\r\n"
					+ "    \"status\": \"Available\"\r\n"
					+ "}\r\n"
					+ " ";
		}

	}



