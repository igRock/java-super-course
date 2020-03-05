import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class FileExplorer {
    String globalPath;

    public FileExplorer() {
        this.globalPath = new File("").getAbsolutePath();
    }

    public String showItems() {
        StringBuilder builder = new StringBuilder();
        File file = new File(globalPath);
        if (file.isDirectory() && file.listFiles() != null) {
            //noinspection ConstantConditions
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    builder.append(item.getName()).append(File.separator).append("\r\n");
                } else {
                    builder.append(item.getName()).append("\r\n");
                }
            }
        } else builder.append(file.getName());
        return builder.toString();
    }

    public String showItems(String path) {
        globalPath = path;
        return showItems();
    }

    public void createTextFile(String text, String fileName) {
        createTextFile(text, fileName, globalPath);
    }

    public void createTextFile(String text, String fileName, String path) {
        File pathFile = new File(path);
        if (!pathFile.exists() || !pathFile.isDirectory()) {
            pathFile.mkdirs();
        }
        try (BufferedWriter writer =
            new BufferedWriter(new FileWriter(pathFile + File.separator + fileName + ".txt"))) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFile(String path) {
        File file = Path.of(path).toFile();
        if (!file.delete()) throw new RuntimeException("File was not deleted");
    }

    public void editTextFile(String path, String newText) {
        try (FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(newText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readTextFile(String path) {
        File file;
        try (FileReader reader = new FileReader(file = new File(path))) {
            char[] buf = new char[(int) file.length()];
            //noinspection ResultOfMethodCallIgnored
            reader.read(buf);
            return new String(buf).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
