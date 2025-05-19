package com.sakila.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	  private Properties properties;

	    public PropertyFile() 
	    {
	        properties = new Properties();
	        try (FileReader reader = new FileReader("config.properties")) 
	        {
	            properties.load(reader);
	        } catch (IOException e) {
	            System.out.println("❌ Error al leer config.properties: " + e.getMessage());
	        }
	    }

	    public String get(String key) 
	    {
	        return properties.getProperty(key);
	    }

}
