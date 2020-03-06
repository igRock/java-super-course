import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExplorerApp {

    public static final String FILE_NAME = "note.txt";
    public static final String RESOURCES_PATH = "unit5/src/main/resources";
    public static final String ROOT_PATH = "unit5/src/main/java";

    public static void main(String[] args) {
        try {
            FileExplorer explorer = new FileExplorer();
            System.out.println("Файлы в корне приложения:");
            System.out.println(explorer.showItems());

            System.out.println("Файлы по определенному пути:");
            System.out.println(explorer.showItems(Path.of(ROOT_PATH)));

            Path path = Path.of(RESOURCES_PATH);
            System.out.println("Создаем файл");
            explorer.createTextFile("Какой-то текст", FILE_NAME, path);

            Path filePath = Path.of(RESOURCES_PATH, FILE_NAME);
            System.out.println("\nЧитаем созданный файл:");
            System.out.println(explorer.readTextFile(filePath));

            System.out.println("Редактируем созданный файл:");
            explorer.editTextFile(filePath, "new text!");

            System.out.println("\nЧитаем отредактированный файл:");
            System.out.println(explorer.readTextFile(filePath));

            System.out.println("Удаляем созданный файл");
            explorer.removeFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
