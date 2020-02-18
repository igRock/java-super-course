package utf_converter;

import java.io.*;

public class UtfConverter {

    public static final String UTF_16 = "UTF-16";
    public static final String UTF_8 = "UTF-8";
    public static final String BASE_PATH = "/unit3-4/src/main/java/utf_converter";

    public static void main(String[] args) {
        try {
            String basePath = new File("").getAbsolutePath().concat(BASE_PATH);

            Reader in = new InputStreamReader(new FileInputStream(new File(basePath.concat("/in/utf16.txt"))), UTF_16);
            Writer out = new OutputStreamWriter(new FileOutputStream(new File(basePath.concat("/out/utf8.txt"))), UTF_8);

            char cbuf[] = new char[2048];
            int len;
            while ((len = in.read(cbuf, 0, cbuf.length)) != -1) {
                out.write(cbuf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
