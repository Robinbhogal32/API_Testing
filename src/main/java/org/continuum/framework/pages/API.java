package org.continuum.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;


public class API {
	
	/* Get API output */
	public void GetWeatherStatusLine()
	{
		RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
		 
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 io.restassured.response.Response response = httpRequest.get("/50016821/products");
		 
		 System.out.println("Response Body is =>  " + response.asString());
		 }
	
	
	/* Get API status code verification */
public void statusCodeVerification(){
	                
 RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = (Response) httpRequest.get("/50016821/products");
 
 //Response response = RestAssured.get("http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners/50016821/products/50016821/products");
 
 int statusCode = response.getStatusCode();
	
 Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	        
	} 
	
public void getAPIDetails()
{   
// Specify the base URL to the RESTful web service
RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";

// Get the RequestSpecification of the request that you want to sent
// to the server. The server is specified by the BaseURI that we have
// specified in the above step.
RequestSpecification httpRequest = RestAssured.given();

// Make a request to the server by specifying the method Type and the method URL.
// This will return the Response from the server. Store the response in a variable.
Response response = httpRequest.request(Method.GET, "/50016821/products");

// Now let us print the body of the message to see what response
// we have recieved from the server
String responseBody = response.getBody().asString();
System.out.println("Response Body is =>  " + responseBody);

}

public void GetAPIStatusLine()
{
 RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/50016821/products");
 
 // Get the status line from the Response and store it in a variable called statusLine
 String statusLine = response.getStatusLine();
 Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
}


public void getAPIMessageBody()
{
 RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/50016821/products");
 
 // Retrieve the body of the Response
 ResponseBodyData body = response.getBody();
 
 // By using the ResponseBody.asString() method, we can convert the  body
 // into the string representation.
 System.out.println("Response Body is: " + body.asString());
}

public void validateMessagebody()
{
 RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/50016821/products");
 
 // Retrieve the body of the Response
 ResponseBody body = response.getBody();
 
 // To check for sub string presence get the Response body as a String.
 // Do a String.contains
 String bodyAsString = body.asString();
 Assert.assertEquals(bodyAsString.contains("Profile") /*Expected value*/, true /*Actual Value*/, "Response body contains Profile");
 Assert.assertEquals(bodyAsString.contains("Security") /*Expected value*/, true /*Actual Value*/, "Response body contains Security");
 Assert.assertEquals(bodyAsString.contains("Assessment") /*Expected value*/, true /*Actual Value*/, "Response body contains Assement");
}


public void getAPIStringPresentIgnoreCase()
{
 RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/50016821/products");
 
 // Retrieve the body of the Response
 ResponseBody body = response.getBody();
 
 // To check for sub string presence get the Response body as a String.
 // Do a String.contains
 String bodyAsString = body.asString();
 
 // convert the body into lower case and then do a comparison to ignore casing.
 Assert.assertEquals(bodyAsString.toLowerCase().contains("SIDDHESH") /*Expected value*/, true /*Actual Value*/, "Response body contains Siddhesh");
}

public void getAPIVerifyNameInJsonResponse()
{
 RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/50016821/products");
 
 JsonPath jsonPathEvaluator = response.jsonPath();
 
 String Name = jsonPathEvaluator.get("[0].name"); /* For Array JSON output */
 
 /* String Name = jsonPathEvaluator.get("Name"); For direct output */
 
 System.out.println("Name received from Response " + Name);
 
 Assert.assertEquals(Name, "Profile and Protect", "Correct name received in the Response");
 
}

public void DisplayAllNodesInWeatherAPI()
{
 RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/50016821/products");
 
 // First get the JsonPath object instance from the Response interface
 JsonPath jsonPathEvaluator = response.jsonPath();
 
 // Let us print the city variable to see what we got
 System.out.println("ID received from Response " + jsonPathEvaluator.get("[0].id"));
 
 // Print the temperature node
 System.out.println("Name received from Response " + jsonPathEvaluator.get("[0].name"));
 
 // Print the humidity node
 System.out.println("Description received from Response " + jsonPathEvaluator.get("[0].description"));
 
}

public void GetWeatherHeaders()
{
 RestAssured.baseURI = "http://internal-entitlement-partnerspecific-72155629.ap-south-1.elb.amazonaws.com/entitlement/v1/partners";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/50016821/products");
 
 // Reader header of a give name. In this line we will get
 // Header named Content-Type
 String contentType = response.header("Content-Type");
 System.out.println("Content-Type value: " + contentType);
 
 // Reader header of a give name. In this line we will get
 // Header named Server
 String serverType =  response.header("Server");
 System.out.println("Server value: " + serverType);
 
 // Reader header of a give name. In this line we will get
 // Header named Content-Encoding
 String acceptLanguage = response.header("Content-Encoding");
 System.out.println("Content-Encoding: " + acceptLanguage);
}


public void IteratingOverHeaders()
{
 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/Hyderabad");
 
 // Get all the headers. Return value is of type Headers.
 // Headers class implements Iterable interface, hence we
 // can apply an advance for loop to go through all Headers
 // as shown in the code below
 Headers allHeaders = response.headers();
 
 // Iterate over all the Headers
 for(Header header : allHeaders)
 {
 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
 }
}

public void executeUserAccountRestAPI(String PartnerID, String ClientID, String SiteID)
{
    try {
        String aplUrl = "http://internal-intplatformuseraccountservice-623194110.ap-south-1.elb.amazonaws.com/useraccount/v1/partners/"+PartnerID+"/clients/"+ClientID+"/sites/"+SiteID+"/users";
      Response  Response = RestAssured.get(aplUrl);
    } catch (Exception e) {
        Reporter.log("Not able to execute REST API Endpoints for User Account API. \n"+ e.getMessage(),true);
    }
}
}
