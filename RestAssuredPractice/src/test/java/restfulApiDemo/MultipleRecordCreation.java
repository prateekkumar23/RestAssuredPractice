package restfulApiDemo;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MultipleRecordCreation {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setupRequestSpec() {
		requestSpec = RestAssured.given();
		requestSpec
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.contentType(ContentType.JSON);
//			.body("{\r\n"
//					+ "    \"firstname\" : \"Patty\",\r\n"
//					+ "    \"lastname\" : \"Kumar\",\r\n"
//					+ "    \"totalprice\" : 112,\r\n"
//					+ "    \"depositpaid\" : true,\r\n"
//					+ "    \"bookingdates\" : {\r\n"
//					+ "        \"checkin\" : \"2018-01-01\",\r\n"
//					+ "        \"checkout\" : \"2019-01-01\"\r\n"
//					+ "    },\r\n"
//					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
//					+ "}")
//			.basePath("booking");
//			.basePath("booking/{bookingID}")
//			.pathParam("bookingID","1");
		
	}
	
	@BeforeClass
	public void setupResponseSpec() {
		responseSpec = RestAssured.expect();
		responseSpec
			.statusCode(200)
			.time(Matchers.lessThan(5000L))
			.contentType(ContentType.JSON);
		
	}
	
	@Test
	public void createBooking() {
		RestAssured
			.given()
			//.given(requestSpec,responseSpec)
				.spec(requestSpec)
				.basePath("booking")
				.body("{\r\n"
						+ "    \"firstname\" : \"Patty\",\r\n"
						+ "    \"lastname\" : \"Kumar\",\r\n"
						+ "    \"totalprice\" : 112,\r\n"
						+ "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n"
						+ "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
						+ "}")
				.header("content-Type","application/json")
				
			//.when()
				.post()
			.then()
				.log()
				.all()
				.spec(responseSpec);
		
	}
	
	@Test
	public void updateBooking() {
		RestAssured
		.given()
			.spec(requestSpec)
			.basePath("booking/{bookingID}")
			.pathParam("bookingID","1")
			.body("{\r\n"
					+ "    \"firstname\" : \"Prateek\",\r\n"
					+ "    \"lastname\" : \"Kumar\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}")
			.header("content-Type","application/json")
			.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
			
		//.when()
			.put()
		.then()
			.log()
			.all()
			.assertThat()
			.spec(responseSpec);
	}
	
	}
