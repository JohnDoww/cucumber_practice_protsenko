package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFactory {

    private static FileInputStream fileInputStream;
    private static final Properties properties;

    static {
        try {
            fileInputStream = new FileInputStream("src/main/resources/project.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}