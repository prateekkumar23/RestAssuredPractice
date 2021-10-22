package restfulApiDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DefaultValue1 {
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RestAssured.basePath = "booking";
		System.out.println("Set Up");
	}
	
	@Test
	public void createBooking1() {
		RestAssured
		.given()
			.log()
			.all()
			//.baseUri("https://restful-booker.herokuapp.com/")
			//.basePath("booking")
			.body("{\r\n"
					+ "    \"firstname\" : \"Jimmy\",\r\n"
					+ "    \"lastname\" : \"Brown\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}")
			.header("content-Type","application/json")
			
		.when()
			.post()
		.then()
			.log()
			.all()
			.statusCode(200);
	}
	
	@Test
	public void createBooking2() {
		RestAssured
		.given()
			.log()
			.all()
			//.baseUri("https://restful-booker.herokuapp.com/")
			//.basePath("booking")
			.body("{\r\n"
					+ "    \"firstname\" : \"Prateek\",\r\n"
					+ "    \"lastname\" : \"Kumar\",\r\n"
					+ "    \"totalprice\" : 142,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Lunch\"\r\n"
					+ "}")
			.header("content-Type","application/json")
			
		.when()
			.post()
		.then()
			.log()
			.all()
			.statusCode(200);
	}

}
