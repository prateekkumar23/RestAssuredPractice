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

public class MultipleRecordWithRequestSpec {
	
	RequestSpecification requestSpec;
	//ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setupResquestSpec() {
		requestSpec = RestAssured.given();
		requestSpec.baseUri("https://restful-booker.herokuapp.com/")
				   .basePath("booking")
				   .accept(ContentType.JSON);
		
	}
	
//	@BeforeClass
//	public void setupResponseSpec() {
//		responseSpec = RestAssured.expect();
//		responseSpec.statusCode(200);
//		responseSpec.contentType(ContentType.JSON);
//		responseSpec.time(Matchers.lessThan(5000L));
//		
//		
//	}
	
	
	@Test
	public void createBooking() {
		RestAssured
			.given()
			.spec(requestSpec)
			.body("{\r\n"
					+ "    \"firstname\" : \"Patty\",\r\n"
					+ "    \"lastname\" : \"Kumar\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : false,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"dinner\"\r\n"
					+ "}")
		
			  .post()
			.then()
			  .log().all()
			  .statusCode(200);

		
	}
	
}
