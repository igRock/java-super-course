package properties_map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {
    private Map<String, String> properties;

    public PropertyReader(String path) {
        setFile(path);
    }

    public void setFile(String path) {
        try (FileInputStream input = new FileInputStream(path)) {
            Properties p = new Properties();
            p.load(input);
            properties = new HashMap<>();
            p.forEach((key, value) -> properties.put((String) key, (String) value));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read this file");
        }
    }

    public String getProperty(String key) {
        if (properties == null) {
            throw new RuntimeException("File not found");
        }
        if (!properties.containsKey(key)) {
            throw new RuntimeException("Property not found");
        }
        return properties.get(key);
    }
}
