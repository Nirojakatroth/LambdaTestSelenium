package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private static ConfigReader configReader;

    private ConfigReader() {
        String configFilePath = "src/main/resources/config.properties";
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "").trim();
    }
}
