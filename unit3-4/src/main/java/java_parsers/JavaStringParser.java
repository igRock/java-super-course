package java_parsers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java_parsers.KeywordCounter.checkWords;

public class JavaStringParser {
    public static void parse(File fin, File fout) throws IOException {
        Map<String, KeywordCounter> result = new HashMap<>();

        BufferedReader in = new BufferedReader(new FileReader(fin));
        while (in.ready()) {
            String line = in.readLine();
            // сначала отделим //, /*, */,  пробелами от слов, а затем разобьём строку по пробельным символам = , ( ) ;
            String[] words = line
                    .replaceAll("\\/\\/", " // ")
                    .replaceAll("\\/\\*", " /* ")
                    .replaceAll("\\*\\/", " */ ")
                    .split("[\\s|\\(|=|,|\\)|;]");

            if (words.length == 0) break;
            checkWords(words, result);
        }
        FileWriter out = new FileWriter(fout);
        for (String key : result.keySet()) {
            out.write(key + " = " + result.get(key).getCount() + "\n");
        }

        out.close();
    }
}
