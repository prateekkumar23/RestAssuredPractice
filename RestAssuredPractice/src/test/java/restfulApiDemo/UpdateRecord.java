package restfulApiDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateRecord {

	public static void main(String[] args) {
		
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("http://localhost:8080/app/")
			.basePath("videogames/11")
			//.header("content-Type","application/json")
			.body("{\r\n"
				+ "  \"id\": 11,\r\n"
				+ "  \"name\": \"Patty\",\r\n"
				+ "  \"releaseDate\": \"2021-10-11T19:34:44.314Z\",\r\n"
				+ "  \"reviewScore\": 123,\r\n"
				+ "  \"category\": \"string23\",\r\n"
				+ "  \"rating\": \"string23\"\r\n"
				+ "}")
			.accept(ContentType.JSON)
		.when()
			.put()
		.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200);
		

	}

}
