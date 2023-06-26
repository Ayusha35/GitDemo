package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.location;
import resource.Resources;
import resource.TestData;
import resource.Utils;
import io.cucumber.java.en.Given;
import static org.junit.Assert.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination extends Utils {
	TestData td=new TestData();
	RequestSpecification response;
	ResponseSpecification res;
	Response res1;
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		//RestAssured.baseURI="https://rahulshettyacademy.com";
	
	response=given().spec(requestSpecification())
			 .body(td.payload(name,language,address));
	}

	@When("User calls {string} with {string} request")
	public void user_calls_with_request(String resourse, String method) {
	    // Write code here that turns the phrase above into concrete actions
		Resources r =Resources.valueOf(resourse);//creating object of enum class
		System.out.println(r.getreource());
		res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 
		 if(method.equalsIgnoreCase("Post"))
		 
		 res1=response.when().post(r.getreource());
				 
		 else if(method.equalsIgnoreCase("get"))
		 
		 
		 res1=response.when().get(r.getreource());
				//then().spec(res).extract().response();
	}

	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   assertEquals(res1.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	  
	    assertEquals(getjson(res1, keyvalue),Expectedvalue);
	}
	
	@Then("Verify place_Id created maps to {string} with {string}")
	public void verify_place_Id_created_maps_to_with(String actualname, String rrr) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		String place_id=getjson(res1,"place_id");
		response=given().spec(requestSpecification()).queryParam("place_id",place_id );
		
		user_calls_with_request(rrr,"GET");
		String name=getjson(res1,"name");
		assertEquals(name,actualname);
	}


	
}
