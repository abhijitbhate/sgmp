package com.ab.config;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ValidationConfig extends AbstractConfig {

	private static ValidationConfig instance = null;
	private Properties properties = null;

	private ValidationConfig(){
		this.load();
	}
	
	public static ValidationConfig getInstance(){
		if(instance == null){
			instance = new ValidationConfig();
		}
		
		return instance;
	}
	
	private void load(){
		
		properties = new Properties();
		
		try {
			
			InputStream stream = ValidationConfig.class.getClassLoader().getResourceAsStream("validation.properties");
			
			properties.load(stream);
			
			stream.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	@Override
	public int getInt(String property) {
		return Integer.parseInt(properties.getProperty(property));
	}
	
	@Override
	public long getLong(String property) {
		return Integer.parseInt(properties.getProperty(property));
	}

	@Override
	public String getString(String property) {
		return properties.getProperty(property).toString();
	}

	@Override
	public List<String> getStringArray(String property) {
		return Arrays.asList(StringUtils.split(properties.getProperty(property), ","));
	}

}
