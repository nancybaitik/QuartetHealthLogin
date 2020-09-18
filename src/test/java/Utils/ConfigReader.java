package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static{
        String path = "configuration.properties";


        try{
            FileInputStream input = new FileInputStream(path); // this line will open your file
            properties = new Properties();
            properties.load(input);                            // we need to load opened file to the properties
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){
        // getProperty method takes one String key
        // and returns value from .properties file
        return properties.getProperty(key);
    }
}
