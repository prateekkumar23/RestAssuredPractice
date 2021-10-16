package restfulApiDemo;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateRecordWithRequestAndResponseSpecification {
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setupResquestSpec() {
		requestSpec = RestAssured.given();
		requestSpec.baseUri("http://localhost:8080/app/")
				   .basePath("videogames/")
				   .header("content-Type","application/json")
				   .contentType(ContentType.JSON);
		
	}
	
	@BeforeClass
	public void setupResponseSpec() {
		responseSpec = RestAssured.expect();
		responseSpec.statusCode(200);
		responseSpec.contentType(ContentType.JSON);
		responseSpec.time(Matchers.lessThan(5000L));
		
		
	}
	
	
	@Test
	public void createGameRecord() {
		RestAssured
			.given()
				.spec(requestSpec)
				.body("{\r\n"
					+ "  \"id\": 12,\r\n"
					+ "  \"name\": \"Patty\",\r\n"
					+ "  \"releaseDate\": \"2021-10-07T15:46:25.573Z\",\r\n"
					+ "  \"reviewScore\": 1123,\r\n"
					+ "  \"category\": \"string2\",\r\n"
					+ "  \"rating\": \"string2\"\r\n"
					+ "}")
			//	.accept(ContentType.JSON)
			// because we are passing resquestSpec and responseSpec in given method so we can't use when method
			//.when()
			  .post()
			.then()
			  .log().all()
			  .spec(responseSpec);

		
	}
	
}
