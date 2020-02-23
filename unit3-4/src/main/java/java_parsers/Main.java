package java_parsers;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String basePath = new File("").getAbsolutePath().concat("/unit3-4/src/main/java/java_parsers");

        try {
            File outputDirectory = new File(basePath + "/out");
            if (!outputDirectory.exists()) {
                outputDirectory.mkdir();
            }
            JavaStringParser.parse(new File(basePath.concat("/in/JavaByteParser.java")),
                    new File(basePath.concat("/out/StringCounter.txt")));
            JavaByteParser.parse(new File(basePath.concat("/in/JavaByteParser.java")),
                    new File(basePath.concat("/out/ByteCounter.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
