package java_parsers;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStringParser {
    public static void parse(File fin, File fout) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(fin));

        Map<String, Long> result = KeywordCounter.getResult(in.lines().collect(Collectors.joining("\n")));

        FileWriter out = new FileWriter(fout);
        for (String key : result.keySet()) {
            out.write(key + " = " + result.get(key) + "\n");
        }

        out.close();
    }
}
