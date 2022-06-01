package utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private  static ConfigLoader configLoader;

    public ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getProperty (String property){
        String prop = properties.getProperty(property);
        if(prop !=null) return prop;
        else throw  new RuntimeException("THE PROPERTY " + property + " IS NOT SPECIFIED IN THE config.properties FILE");
    }

}
