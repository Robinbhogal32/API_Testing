package org.continuum.framework.testcases;

import org.continuum.framework.pages.API;
import org.testng.annotations.Test;

public class TC0001 {
		
	@Test(groups = { "All", "P1" })
		public void TC0008()
		{
			API AP = new API();
			AP.GetWeatherStatusLine();
		}
		
	@Test(groups = { "All", "P1" })
		public void TC00081()
		{
			API AP = new API();
			AP.statusCodeVerification();
		}
	   
	@Test(groups = { "All", "P1" })
		public void TC00082()
		{
			API AP = new API();
			AP.getAPIDetails();
		}

	@Test(groups = { "All", "P1" })
			public void TC00083()
			{
				API AP = new API();
				AP.GetAPIStatusLine();
			}

	@Test(groups = { "All", "P1" })
		public void TC00084()
		{
			API AP = new API();
			AP.getAPIMessageBody();
		}
	   
	@Test(groups = { "All", "P2" })
		public void TC00085()
		{
			API AP = new API();
			AP.validateMessagebody();
		}
	   
	
		public void TC00086()
		{
			API AP = new API();
			AP.getAPIStringPresentIgnoreCase();
		}
	   
	@Test(groups = { "All", "P2" })
	 		public void TC00087()
	 		{
	 			API AP = new API();
	 			AP.getAPIVerifyNameInJsonResponse();
	 		}
	   
	@Test(groups = { "All", "P1" })	
	public void TC00088()
		{
			API AP = new API();
			AP.DisplayAllNodesInWeatherAPI();
		}   
	   

	@Test(groups = { "All", "P2" }) 
	public void TC00089()
	{
		API AP = new API();
		AP.GetWeatherHeaders();
	}
    
	@Test(groups = { "All", "P1" })
	public void TC00090()
	{
		API AP = new API();
		AP.IteratingOverHeaders();
	}
	
	@Test(groups = { "All", "P2" })
	public void TC00091()
	{
		API AP = new API();
		AP.executeUserAccountRestAPI("50016367", "50110212", "50110212");
	}
	
	}


