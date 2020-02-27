package org.rest.automation.RestAutomation;

import java.text.ParseException;

import org.rest.automation.RevelAutomation.RestClient1;
import org.testng.annotations.Test;

public class EndTests {
	
	@Test
	public void testWebapp() throws ParseException
	{
		RestClient1.getModes("web");
	}
	@Test
	public void testCommandLine() throws ParseException
	{
		RestClient1.getModes("command line");
	}
}
