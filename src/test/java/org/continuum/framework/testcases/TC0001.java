package org.continuum.framework.testcases;

import org.continuum.framework.pages.API;
import org.testng.annotations.Test;

public class TC0001 {
		
	   @Test
		public void TC0008()
		{
			API AP = new API();
			AP.GetWeatherStatusLine();
		}
		
	   @Test
		public void TC00081()
		{
			API AP = new API();
			AP.statusCodeVerification();
		}
	   
	   @Test
		public void TC00082()
		{
			API AP = new API();
			AP.getAPIDetails();
		}

	   @Test
			public void TC00083()
			{
				API AP = new API();
				AP.GetAPIStatusLine();
			}

	   @Test
		public void TC00084()
		{
			API AP = new API();
			AP.getAPIMessageBody();
		}
	   
	   @Test
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
	   
	   @Test
	 		public void TC00087()
	 		{
	 			API AP = new API();
	 			AP.getAPIVerifyNameInJsonResponse();
	 		}
	}


