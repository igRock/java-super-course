package java_parsers;

import java.util.Map;

public class KeywordCounter {
    public static String[] keywords = {"abstract", "continue", "for", "new", "switch",
            "assert", "default", "goto", "package", "synchronized",
            "boolean", "do", "if", "private", "this",
            "break", "double", "implements", "protected", "throw",
            "byte", "else", "import", "public", "throws",
            "case", "enum", "instanceof", "return", "transient",
            "catch", "extends", "int", "short", "try",
            "char", "final", "interface", "static", "void",
            "class", "finally", "long", "strictfp", "volatile",
            "const", "float", "native", "super", "while"};
    private int count;

    public int getCount() {
        return count;
    }

    public KeywordCounter() {
        count = 1;
    }

    public void incCount() {
        count++;
    }

    public static Map<String, KeywordCounter> checkWords(String[] words, Map<String, KeywordCounter> result) {
        int comments = 0;
        int quotes = 0;
        for (String word : words) {
            if (word.contains("//")) break; // дальше в строке только коментарии
            if (word.length() == 0) {
                continue;
            }

            if ((quotes > 0) || (comments > 0)) {
                if (comments > 0) {
                    comments = word.contains("*/") ? 0 : comments + 1;
                } else if (word.charAt(word.length() - 1) == '"') {
                    quotes--;
                }
            } else {
                if (word.contains("/*")) {
                    comments = word.contains("*/") ? 0 : comments + 1;
                } else if (word.chars().filter(ch -> ch == ',').count() % 2 != 0) {
                    quotes++;
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
        return result;
    }

    public static String[] separateLineIntoCleanWords(String line) {
        return line
                .replaceAll("\\/\\/", " // ")
                .replaceAll("\\/\\*", " /* ")
                .replaceAll("\\*\\/", " */ ")
                .split("[\\s|\\(|=|,|\\)|;]");
    }
}
