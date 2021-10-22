package restfulApiDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

public class RealTimeHeaderOverwrite {
	
	@Test
	public void realTime() {
		RequestSpecification rs1 = RestAssured.given()
				.header("header1","value1");
				
		RequestSpecification rs2 = RestAssured.given()
				.header("header2","value2")
				.header("header1","value3");
		
		
		RestAssured
			.given()
				.config(RestAssuredConfig.config()
						.headerConfig(HeaderConfig.headerConfig()
								.overwriteHeadersWithName("header1")))
				.spec(rs1)
				.spec(rs2)
				.log()
				.all()
			.when()
				.get();
	}

}
