package com.yaytech.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    private static String path = "configuration.properties";

    static{
        try( FileInputStream input = new FileInputStream(path)) {

            properties = new Properties();
            properties.load(input);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getValue(String keyName){
        return properties.getProperty(keyName);
    }

}
