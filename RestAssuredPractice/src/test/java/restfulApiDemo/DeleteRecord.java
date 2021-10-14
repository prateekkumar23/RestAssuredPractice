package restfulApiDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRecord {

	public static void main(String[] args) {
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking/{bookingid}")
			.pathParam("bookingid","1")
			.header("content-Type","application/json")
			//.accept(ContentType.JSON)
			.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.when()
			.delete()
		.then()
			.log()
			.all()
			.assertThat();
			//.statusCode(200);

	}

}
