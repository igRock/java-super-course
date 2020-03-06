import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;

public class FileExplorer {

    Path globalPath;
    //    String globalPath;

    public FileExplorer() {
        this.globalPath = Path.of("");
        //        this.globalPath = new File("").getAbsolutePath();
    }

    public String showItems(Path path) throws IOException {
        StringBuilder builder = new StringBuilder();
        Files.list(path).forEach(item -> {
            builder.append(item.getFileName().toString());
            if (Files.isDirectory(item)) {
                builder.append(File.separator);
            }
            builder.append("\r\n");
        });
        return builder.toString();
    }

    public String showItems() throws IOException {
        return showItems(globalPath);
    }

    public void createTextFile(String text, String fileName) throws IOException {
        createTextFile(text, fileName, globalPath);
    }

    public void createTextFile(String text, String fileName, Path path) throws IOException {
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            Files.createDirectories(path);
        }
        Files.createFile(Paths.get(path.toString(), fileName.concat(".txt")));
    }

    public void removeFile(Path path) throws IOException {
        Files.delete(path);
    }

    public void editTextFile(Path path, String newText) throws IOException {
        Files.write(path, Collections.singleton(newText), StandardCharsets.UTF_8);

//        try (FileWriter fw = new FileWriter(path, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter out = new PrintWriter(bw)) {
//
//            out.println(newText);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public String readTextFile(Path path) throws IOException {
        return Files.readAllLines(path).stream().collect(Collectors.joining("\n"));

//        File file;
//        try (FileReader reader = new FileReader(file = new File(path))) {
//            char[] buf = new char[(int) file.length()];
//            //noinspection ResultOfMethodCallIgnored
//            reader.read(buf);
//            return new String(buf).trim();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
    }
}
