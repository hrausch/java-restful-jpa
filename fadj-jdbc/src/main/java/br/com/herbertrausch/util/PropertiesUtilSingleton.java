package br.com.herbertrausch.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




public class PropertiesUtilSingleton {
	
	private static PropertiesUtilSingleton instance;
	private PropertiesUtilSingleton(){
		
	}
	
	public static synchronized PropertiesUtilSingleton getInstance(){
		
		if(instance == null)
			instance = new PropertiesUtilSingleton();
				
		return instance;
	}
	
	public Properties getProp() throws IOException { 
		   Properties props = new Properties();
		   InputStream input = null;
		   String filename = "config.properties";
 			input = PropertiesUtilSingleton.class.getClassLoader().getResourceAsStream(filename);
		   
		   props.load(input); 
		   
		   return props; 
		   
	   }

}
