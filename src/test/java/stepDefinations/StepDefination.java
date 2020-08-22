package stepDefinations;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;

	@Given("Navigate to api")
	public void navigate_to_api() {
		try {
			res=given().spec(requestSpecification())
					.header("Cookie","INGRESSCOOKIE=72fa115a545793355dbcaed45a625331; JSESSIONID=2DEFD6C06ECA544E0BB5CBA2DC8FA40B; _state=value=%7B%22states%22%3A%5B%7B%22moduleid%22%3A%225f3d8d0cd866fa61019cf969.ad%22%2C%22status%22%3Afalse%2C%22tries%22%3A0%7D%5D%2C%22service%22%3A%22default%22%2C%22currentLoginState%22%3A%22LOGGING_IN%22%2C%22user%22%3Anull%7D")
					.header("Accept-Encoding","gzip, deflate, br")
					.header("Connection","keep-alive")
					.contentType(ContentType.JSON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				
		System.out.println(res);
	}
	
	@When("user calls {string} with {string} http requests")
	public void user_calls_with_http_requests(String resource, String method) {
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build(); 
		if(method.equalsIgnoreCase("GET"))		
		response =res.when().get(resourceAPI.getResource());
		
	}

	@Then("API call get success with status codes {int}")
	public void api_call_get_success_with_status_codes(Integer int1) {
		assertEquals(200,response.getStatusCode());
	    
	}
	
	@Then("fetch {string} from {string} with {string} request")
	public void fetch_from_with_request(String eula, String resource, String method) {

		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build(); 
		if(method.equalsIgnoreCase("GET"))		
		response =res.when().get(resourceAPI.getResource());   
		String eula_b64=getJsonPath(response,eula);
		System.out.println(eula_b64);
	    
	}

}
