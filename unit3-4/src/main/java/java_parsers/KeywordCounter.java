package java_parsers;

import org.apache.axis2.util.JavaUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KeywordCounter {
    public static Map<String, Long> getResult(String javaText) {
        return Arrays.stream(javaText
                .replaceAll("((['\"])(?:(?!\\2|\\\\).|\\\\.)*\\2)|\\/\\/[^\\n]*|\\/\\*(?:[^*]|\\*(?!\\/))*\\*\\/", "") //Удаляю все комментарии
                .split("[\\s|\\(|=|,|\\)|;]")) //дроблю на слова
                .filter(JavaUtils::isJavaKeyword)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
