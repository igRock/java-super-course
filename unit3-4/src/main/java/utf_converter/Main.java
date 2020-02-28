package utf_converter;

import java.io.*;

public class Main {
    public static final String BASE_PATH = "/unit3-4/src/main/java/utf_converter";

    public static void main(String[] args) {
        try {
            String basePath = new File("").getAbsolutePath().concat(BASE_PATH);
            File inputFile = new File(basePath.concat("/in/text.txt"));
            File outputFolder = new File(basePath + "/out");

            UtfConverter.convert(inputFile, outputFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
