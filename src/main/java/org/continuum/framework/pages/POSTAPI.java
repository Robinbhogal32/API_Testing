package org.continuum.framework.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.testng.Assert;


public class POSTAPI {
	
	public void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="http://internal-continuum-profiling-service-int-856030625.ap-south-1.elb.amazonaws.com/profiling/v1";
	 
	
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
     requestParams.put("PartnerID", "50016367"); 
	 requestParams.put("SiteID", "[50110212]");
	 requestParams.put("IsActive", "true");
	 requestParams.put("Feature", "PP"); 
	 
	 System.out.println(requestParams);


	 
	 request.body(requestParams.toJSONString());	 
	 Response response = request.post("/securitypartners");
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, "200");
	 String successCode = response.jsonPath().get("SuccessCode");
	 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

	public void AuthenticationBasics()
	{
	 RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
	 RequestSpecification request = RestAssured.given();
	 
	 Response response = request.get();
	 System.out.println("Status code: " + response.getStatusCode());
	 System.out.println("Status message " + response.body().asString());
	}
	

public static void POSTRequest() throws IOException {
    final String POST_PARAMS = "{\n" + "\"PartnerID\": 50016367,\r\n" +
        "    \"SiteID\": [50110212],\r\n" +
        "    \"IsActive\": \"false\",\r\n" +
        "    \"Feature\": \"PP\"" + "\n}";
    System.out.println(POST_PARAMS);
    URL obj = new URL("http://internal-continuum-profiling-service-int-856030625.ap-south-1.elb.amazonaws.com/profiling/v1/securitypartners");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    OutputStream os = postConnection.getOutputStream();
    os.write(POST_PARAMS.getBytes());
    os.flush();
    os.close();
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}
	

public static void POSTRequest1() throws IOException {
    final String POST_PARAMS = "{\n" + "\"userId\": 101,\r\n" +
        "    \"id\": 101,\r\n" +
        "    \"title\": \"Test Title\",\r\n" +
        "    \"body\": \"Test Body\"" + "\n}";
    System.out.println(POST_PARAMS);
    URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("userId", "a1bcdefgh");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    OutputStream os = postConnection.getOutputStream();
    os.write(POST_PARAMS.getBytes());
    os.flush();
    os.close();
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}





public boolean provisionUnprovisionPartner(String partnerID,String siteId,String sFeature,String isActive){
	boolean isExecuted = true;
	String URL= "http://internal-continuum-profiling-service-int-856030625.ap-south-1.elb.amazonaws.com/profiling/v1/securitypartners"; 
	Response resp = RestAssured.given().contentType("application/json").body("[{\"PartnerID\": \""+partnerID+"\",\"SiteID\": [\""+siteId+"\"], \"IsActive\": "+isActive+",\"Feature\": \""+sFeature+"\"}]").put(URL).andReturn(); 
	//System.out.println(resp.getBody().asString()); 
	System.out.println(resp.getStatusCode());
	if(resp.getStatusCode()!=200){
		isExecuted = false;
		
	}
	return isExecuted;
}

	
}
