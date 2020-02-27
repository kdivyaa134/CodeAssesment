package org.rest.automation.RevelAutomation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class RestClient1 {

	public static void getModes(String apptype) throws ParseException {
		ReadProperties read = new ReadProperties();
		read.readProperties();
		Response response = RestAssured
				.given()
				.get("http://api.openweathermap.org/data/2.5/forecast?q=minneapolis,us&units=imperial&APPID=09110e603c1d5c272f94f64305c09436");
		int listStates = response.jsonPath().getList("list").size();
		for (int i = 0; i < listStates; ++i) {
			String sdate=response.jsonPath().getString(
					"list[" + i + "].dt_txt");
			String celsius = response.jsonPath().getString(
					"list[" + i + "].main.temp");
			double Fahrenheit = (9/5) * Double.parseDouble(celsius) + 32;
			if(apptype.contains("command line"))
			{
			System.out.println(sdate);
			if(Fahrenheit>75)
				System.out.println("message");
			else if(Fahrenheit>55)
				System.out.println("phonecall");
			else
				System.out.println("email");
			}
			else if(apptype.contains("web"))
			{
				System.out.print(sdate+"     ");
				if(Fahrenheit>75)
					System.out.println("message");
				else if(Fahrenheit>55)
					System.out.println("phone");
				else
					System.out.println("email");
			}
			
		}
	}
}
