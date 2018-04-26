package com.ab.factory;

import com.ab.config.ValidationConfig;

public class ConfigFactory {

	private static ConfigFactory instance = null;
	
	private ConfigFactory(){}
	
	public static ConfigFactory getInstance(){
		if(instance == null){
			instance = new ConfigFactory();
		}
		return instance;
	}
	
	public ValidationConfig getValidationConfig(){
		return ValidationConfig.getInstance();
	}
}
