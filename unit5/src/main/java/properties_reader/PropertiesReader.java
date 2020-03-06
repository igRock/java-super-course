package properties_reader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String getProperties(String path, String key) {
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(path))) {
            Properties properties = new Properties();
            properties.load(stream);
            String value = properties.getProperty(key);
            if (value == null) {
                throw new RuntimeException("Нет ключа в properties: " + key);
            }
            return value;
        } catch (IOException e) {
            throw new RuntimeException("Файл " + path + " не найден");
        }
    }
}
