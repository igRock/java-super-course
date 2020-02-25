package java_parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;


public class JavaByteParser {

    public static void parse(File fin, File fout) throws IOException {
        FileInputStream in = new FileInputStream(fin);

        byte[] bytes = new byte[in.available()];

        in.read(bytes);
        in.close();

        Map<String, Long> result = KeywordCounter.getResult(new String(bytes, Charset.forName("UTF-8")));

        StringBuilder stringBuffer = new StringBuilder(result.size());

        for (String key : result.keySet()) {
            stringBuffer.append(key).append(" = ").append(result.get(key)).append("\n");
        }

        FileOutputStream out = new FileOutputStream(fout);
        bytes = stringBuffer.toString().getBytes();
        out.write(bytes);
        out.close();
    }
}
