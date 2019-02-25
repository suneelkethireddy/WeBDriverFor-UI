package resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadCongfiProperty {

	public static void main(String[] args) {
		
		InputStream input=ReadCongfiProperty.class.getClassLoader().getResourceAsStream("resource/config.propeties");
		Properties prop=new Properties();
		
		try {
			prop.load(input);
			System.out.println("Url :"+prop.getProperty("url"));
			System.out.println("browser :"+prop.getProperty("browser"));
			System.out.println("Username :"+prop.getProperty("Username"));
			System.out.println("Password :"+prop.getProperty("Password"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
