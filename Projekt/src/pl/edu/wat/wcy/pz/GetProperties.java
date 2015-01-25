package pl.edu.wat.wcy.pz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

	public String getValues() throws IOException {
		 
		String result = "";
		Properties properties = new Properties();
		String propFileName = "dbconfig.properties";
 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
		if (inputStream != null) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
 
		String user = properties.getProperty("user");
		String pass = properties.getProperty("password");

		result = "user=" + user + "&password=" + pass;
		//System.out.println(result);
		return result;
	}
}
