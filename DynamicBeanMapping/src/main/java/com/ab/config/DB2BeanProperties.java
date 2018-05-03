package com.ab.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DB2BeanProperties {

    private Properties properties = null;

    private DB2BeanProperties() {this.load();}

    private static class DB2BeanPropertiesHolder{
        private static DB2BeanProperties instance = new DB2BeanProperties();
    }

    public static DB2BeanProperties getInstance() {
        return DB2BeanPropertiesHolder.instance;
    }

    private void load() {
        properties = new Properties();

        try{
            InputStream inputStream = DB2BeanProperties.class.getClassLoader().getResourceAsStream("db2bean.properties");

            properties.load(inputStream);

            inputStream.close();

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }
}
