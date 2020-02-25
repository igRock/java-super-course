package java_parsers;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public static Map<String, Long> getResult(String javaText) {
        return Arrays.stream(javaText
                .replaceAll("((['\"])(?:(?!\\2|\\\\).|\\\\.)*\\2)|\\/\\/[^\\n]*|\\/\\*(?:[^*]|\\*(?!\\/))*\\*\\/", "") //Удаляю все комментарии
                .split("[\\s|\\(|=|,|\\)|;]")) //дроблю на слова
                .filter(word -> Arrays.asList(KeywordCounter.keywords).contains(word))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
