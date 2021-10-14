package restfulApiDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateRecord {
	
	public static void main(String[] args) {
		
//		//Build Request
//		RequestSpecification rs = RestAssured.given();
//		rs = rs.log().all();
//		rs.baseUri("http://localhost:8080/app/");
//		rs.basePath("videogames/");
//		rs.body("{\r\n"
//				+ "  \"id\": 13,\r\n"
//				+ "  \"name\": \"Preksha\",\r\n"
//				+ "  \"releaseDate\": \"2021-10-07T15:46:25.573Z\",\r\n"
//				+ "  \"reviewScore\": 133,\r\n"
//				+ "  \"category\": \"string3\",\r\n"
//				+ "  \"rating\": \"string3\"\r\n"
//				+ "}");
//		
//		rs.contentType(ContentType.JSON);
//		
//		
//		// Hit Request and get response
//		Response res = rs.post();
//		
//		// Validate Response
//		ValidatableResponse vr = res.then().log().all();
//		vr.statusCode(200);
		

		//************** Short form of writing above script**************
		RestAssured
			.given()
				.log().all()
				.baseUri("http://localhost:8080/app/")
				.basePath("videogames/")
				.body("{\r\n"
					+ "  \"id\": 11,\r\n"
					+ "  \"name\": \"Meerut\",\r\n"
					+ "  \"releaseDate\": \"2021-10-07T15:46:25.573Z\",\r\n"
					+ "  \"reviewScore\": 111,\r\n"
					+ "  \"category\": \"string1\",\r\n"
					+ "  \"rating\": \"string1\"\r\n"
					+ "}")
			.contentType(ContentType.JSON)
			.when()
				.post()
			.then()
				.log().all()
				.statusCode(200);
			
		
	}

}
