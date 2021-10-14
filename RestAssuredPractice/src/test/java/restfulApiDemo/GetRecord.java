package restfulApiDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRecord {

	public static void main(String[] args) {
		
//		RequestSpecification rs = RestAssured.given().log().all();
//		rs.baseUri("http://localhost:8080/app/");
//		rs.basePath("videogames/{videoGameId}");
//		rs.pathParam("videoGameId",1);
//		
//		rs.contentType(ContentType.JSON);
//		Response res = rs.get();
//		
//		ValidatableResponse vr = res.then().log().all();
//		vr.statusCode(200);

		

		// in short BDD form
		
		
		RestAssured
			.given()
				.log().all()
				.baseUri("http://localhost:8080/app/")
				.basePath("videogames/{videoGameId}")
				.pathParam("videoGameId",11)
				//.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.log().all()
				.statusCode(200);
			
		
	}

}
