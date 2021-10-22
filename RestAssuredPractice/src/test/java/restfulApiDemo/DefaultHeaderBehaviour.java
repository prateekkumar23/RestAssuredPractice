package restfulApiDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;

public class DefaultHeaderBehaviour {
	
	
	@Test
	public void defaultBehaviour() {
		RestAssured
			.given()
				.header("header1","value1")
				.header("header1","value2")
				.log()
				.all()
			.when()
				.get();
	}
	
	@Test
	public void overwriteHeaderValue() {
		RestAssured
			.given()
				.config(RestAssuredConfig.config().
						headerConfig(HeaderConfig.headerConfig().
								overwriteHeadersWithName("header1","header2")))
				
				.config(RestAssuredConfig.config().
						headerConfig(HeaderConfig.headerConfig().
								mergeHeadersWithName("Header1")))
				
				.header("header1","value1")
				.header("header1","value2")
				.header("header2","value3")
				.header("header2","value4")
				.header("header3","value5")
				.header("header3","value6")
				.log()
				.all()
			.when()
				.get();
	}

}
