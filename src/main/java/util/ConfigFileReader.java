package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= System.getProperty("user.dir")+"/conf/default.txt";

    public  String configFileReader() {
        BufferedReader reader;
        String driverType = null;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);

                reader.close();
                driverType = properties.getProperty("url");

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);


        }
        return driverType;
        //  String driverType = properties.getProperty("url");

        // System.out.println(driverType);

    }}


