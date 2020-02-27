package java_parsers;

import org.apache.axis2.util.JavaUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KeywordCounter {
    public static Map<String, Long> getResult(String javaText) {
        return Arrays.stream(javaText
//                .replaceAll("((['\"])(?:(?!\\2|\\\\).|\\\\.)*\\2)|\\/\\/[^\\n]*|\\/\\*(?:[^*]|\\*(?!\\/))*\\*\\/", "") //Удаляю все одну строку
                .replaceAll("([\"'])(?:(?=(\\\\?))\\2.)*?\\1", "") // Убираем значения строк во всех видах кавычек
                .replaceAll("(?s:\\/\\*.*?\\*\\/)|\\/\\/.*", "") // Убираем блочные и строчные комментарии
                .replaceAll("[^\\w\\s]", "") // Убираем лишние символы кроме слов и пробелов
                .split(" ")) // Дроблю на слова
                .filter(JavaUtils::isJavaKeyword)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
