package org.continuum.framework.testcases;

import java.io.IOException;

import org.continuum.framework.pages.POSTAPI;
import org.testng.annotations.Test;

public class TC0002 {
	
	
	public void TC001()
	{
	

		POSTAPI API = new POSTAPI();
		API.RegistrationSuccessful();
	}
	
	
	public void TC002()
	{
	

		POSTAPI API = new POSTAPI();
		API.AuthenticationBasics();
	}
	
   
	public void TC004() throws IOException
	{
	

		POSTAPI API = new POSTAPI();
		API.POSTRequest1();
	}
    
   @Test
	public void TC005() throws IOException 
	{
	

		POSTAPI API = new POSTAPI();
		API.provisionUnprovisionPartner("50016367", "50110212", "false", "PP");
	}
       

}
