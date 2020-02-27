package org.rest.automation.RevelAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	public String testbed;

	public String getBaseUrl() {
		return testbed;
	}

	public void readProperties() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("./properties/env.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			
				testbed = prop.getProperty("apibaseurl");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
