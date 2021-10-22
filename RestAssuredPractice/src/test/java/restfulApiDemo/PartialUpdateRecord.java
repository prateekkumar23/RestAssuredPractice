package restfulApiDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PartialUpdateRecord {

	public static void main(String[] args) {
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking/1")
			.body("{\r\n"
					+ "    \"firstname\" : \"Prateek\",\r\n"
					+ "    \"lastname\" : \"Kumar\"\r\n"
					+ "}")
			//.contentType(ContentType.JSON)
			.header("content-Type","application/json")
			//.accept(ContentType.JSON)
			.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
			//.cookie("token","abc123")
			
		.when()
			.patch()
		.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200);
		

	}

}
