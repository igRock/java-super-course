package utf_converter;

import java.io.*;

public class UtfConverter {

    private static final String UTF_16 = "UTF-16";
    private static final String UTF_8 = "UTF-8";

    public static void convert(File inputFile, File outputFolder) throws IOException {
        Reader in = new InputStreamReader(new FileInputStream(inputFile), UTF_16);

        if (!outputFolder.exists()) {
            System.out.println("sdlfkjnsdflksj");
            outputFolder.mkdirs();
        }

        Writer out = new OutputStreamWriter(
                new FileOutputStream(outputFolder.getAbsolutePath().concat("/").concat(inputFile.getName())), UTF_8);

        char cbuf[] = new char[2048];
        int len;
        while ((len = in.read(cbuf, 0, cbuf.length)) != -1) {
            out.write(cbuf, 0, len);
        }
        in.close();
        out.close();
    }
}
