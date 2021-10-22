package restfulApiDemo;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class DefaultValue2 {
	
	@Test
	public void createBooking3() {
		RestAssured
		.given()
			.log()
			.all()
			//.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("auth")
			.body("{\r\n"
					+ "    \"username\" : \"admin\",\r\n"
					+ "    \"password\" : \"password123\"\r\n"
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
