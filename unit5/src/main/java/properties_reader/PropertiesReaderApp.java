package properties_reader;

public class PropertiesReaderApp {

    public static final String PROPERTIES_PATH = "unit5/src/main/resources/application.properties";

    public static void main(String[] args) {

        String prop1 = PropertiesReader.getProperties(PROPERTIES_PATH, "id");
        String prop2 = PropertiesReader.getProperties(PROPERTIES_PATH, "name");
        System.out.println(prop1);
        System.out.println(prop2);

        PropertiesReader.getProperties(PROPERTIES_PATH, "unknown_key");
        PropertiesReader.getProperties("unknown/path/application.properties", "id");
    }

}
