package restfulApiDemo;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CheckResponseTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Response response = RestAssured
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
			.post();
		//.then()
			long responseTimeMS = response.time();
			System.out.println("The response time in MS is: " + responseTimeMS);
			long responseTimeSec = response.timeIn(TimeUnit.SECONDS);
			System.out.println("The response time in seconds is: " + responseTimeSec);
			
			// Similar time methods to extract the response time\
			long responseTimeMS1 = response.getTime();
			System.out.println("The response time in MS is: " + responseTimeMS);
			long responseTimeSec1 = response.getTimeIn(TimeUnit.SECONDS);
			System.out.println("The response time in seconds is: " + responseTimeSec);
			
		// How to validate the response time or putting assertion
			response.then().time(Matchers.lessThan(2000L));

			response.then().time(Matchers.lessThan(2L), TimeUnit.SECONDS);
	
	}

}
