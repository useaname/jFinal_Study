package demo.kit;

import java.io.IOException;
import java.util.Properties;



public class ReadProperties {
	static Properties props = new Properties();
	
	static {
		try {
			props.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
}
