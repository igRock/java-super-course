package java_parsers.in;

import java_parsers.KeywordCounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

public class JavaByteParser {
    private static int comments = 0;
    private static int quotes = 0;
    private static HashMap<String, KeywordCounter> result = new HashMap<>();

    public static void parse(File fin, File fout) throws IOException {
        FileInputStream in = new FileInputStream(fin);

        byte[] bytes = new byte[in.available()];

        in.read(bytes); //плохо читать всё сразу
        in.close();


        String[] strings = (new String(bytes, Charset.forName("UTF-8"))).split("\n");

        for (String line : strings) {
            String[] words = line
                    .replaceAll("\\/\\/", " // ")
                    .replaceAll("\\/\\*", " /* ")
                    .replaceAll("\\*\\/", " */ ")
                    .split("[\\s|\\(|=|,|\\)|;]");
            parse(words);
        }


        StringBuffer stringBuffer = new StringBuffer(result.size());

        for (String key : result.keySet()) {
            stringBuffer.append(key + " = " + result.get(key).getCount() + "\n");
        }

        FileOutputStream out = new FileOutputStream(fout);
        bytes = stringBuffer.toString().getBytes();
        out.write(bytes);
        out.close();
    }

    private static void parse(String[] words) {
        if (words.length > 0) {

            for (String word : words) {

                if (word.contains("//") || word.length() == 0) break; // дальше в строке только коментарии

                if ((quotes > 0) || (comments > 0)) {
                    if (comments > 0) {
                        commentsCounter(word);
                    } else {
                        if (word.equals('"') || ((word.charAt(word.length() - 1) == '"') && (word.charAt(word.length() - 2) != '\\'))) {
                            quotes--;
                        }
                    }
                } else {
                    if (word.contains("/*")) {
                        commentsCounter(word);
                    } else {
                        if (word.charAt(0) == '"') {
                            quotes++;
                            if ((word.length() > 1) && (word.charAt(word.length() - 1) == '"')) {
                                quotes--;
                            }
                        } else {
                            for (String keyword : KeywordCounter.keywords) {
                                if (keyword.equals(word)) {
                                    if (result.containsKey(keyword)) {
                                        result.get(keyword).incCount();
                                    } else {
                                        result.put(keyword, new KeywordCounter());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void commentsCounter(String s) {
        comments++;
        if (s.contains("*/")) comments = 0;
    }
}
