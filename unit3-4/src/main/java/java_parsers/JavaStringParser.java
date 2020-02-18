package java_parsers;

import java.io.*;
import java.util.HashMap;

public class JavaStringParser {
    private static int comments = 0;
    private static int quotes = 0;

    public static void parse(File fin, File fout) throws IOException {
        HashMap<String, KeywordCounter> result = new HashMap<>();
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
            for (String word : words) {
                if (word.contains("//")) break; // дальше в строке только коментарии
                if (word.length() > 0) {
                    if ((quotes > 0) || (comments > 0)) {
                        if (comments > 0) {
                            commentsCounter(word);
                        } else {
                            if (word.length() > 1) {
                                if ((word.charAt(word.length() - 1) == '"') && (word.charAt(word.length() - 2) != '\\'))
                                    quotes--;
                            } else if (word.charAt(word.length() - 1) == '"') quotes--;
                        }
                    } else {
                        if (word.contains("/*")) {
                            commentsCounter(word);
                        } else {
                            if (word.charAt(0) == '"') {
                                quotes++;
                                if ((word.length() > 1) && (word.charAt(word.length() - 1) == '"')) quotes--;
                            } else {
                                for (String keyword : KeywordCounter.keywords) {
                                    if (keyword.equals(word)) {
                                        if (result.containsKey(keyword)) result.get(keyword).incCount();
                                        else result.put(keyword, new KeywordCounter());
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        FileWriter out = new FileWriter(fout);
        for (String key : result.keySet()) {
            out.write(key + " = " + result.get(key).getCount() + "\n");
        }

        out.close();
    }

    private static void commentsCounter(String s) {
        comments++;
        if (s.contains("*/")) comments = 0;
    }
}
