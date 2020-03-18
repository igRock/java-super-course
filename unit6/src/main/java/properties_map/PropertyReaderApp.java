package properties_map;

public class PropertyReaderApp {
    public static void main(String[] args) {
        PropertyReader propertyReader = new PropertyReader("unit6/src/main/resources/application.properties");
        System.out.println(propertyReader.getProperty("key1"));
        System.out.println(propertyReader.getProperty("key3"));
    }
}
