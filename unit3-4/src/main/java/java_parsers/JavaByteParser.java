package java_parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

import static java_parsers.KeywordCounter.checkWords;

public class JavaByteParser {
    private static HashMap <String, KeywordCounter> result = new HashMap<>();

    public static void parse(File fin, File fout) throws IOException {
        FileInputStream in = new FileInputStream(fin);

        byte[] bytes = new byte[in.available()];

        in.read(bytes);
        in.close();

        String[] strings = (new String(bytes, Charset.forName("UTF-8"))).split("\n");

        for(String line : strings) {
            // сначала отделим //, /*, */,  пробелами от слов, а затем разобьём строку по пробельным символам = , ( ) ;
            String[] words = line
                    .replaceAll("\\/\\/"," // ")
                    .replaceAll("\\/\\*"," /* ")
                    .replaceAll("\\*\\/"," */ ")
                    .split("[\\s|\\(|=|,|\\)|;]");
            if (words.length > 0) {
                checkWords(words, result);
            }
        }

        StringBuilder stringBuffer = new StringBuilder(result.size());

        for(String key : result.keySet()){
            stringBuffer.append(key).append(" = ").append(result.get(key).getCount()).append("\n");
        }

        FileOutputStream out = new FileOutputStream(fout);
        bytes=stringBuffer.toString().getBytes();
        out.write(bytes);
        out.close();
    }
}
