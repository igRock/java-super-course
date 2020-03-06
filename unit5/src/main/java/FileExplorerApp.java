import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExplorerApp {

    public static void main(String[] args) {
        try {
            FileExplorer explorer = new FileExplorer();
            System.out.println("Файлы в корне приложения:");
            System.out.println(explorer.showItems());

            System.out.println("Файлы по определенному пути:");
            System.out.println(explorer.showItems(Path.of("unit5/src/main/java")));

            String fileName = "note";
            Path path = Path.of("unit5/src/main/resources");
            System.out.println("Создаем файл");
            explorer.createTextFile("Какой-то текст", fileName, path);

            Path filePath = Path.of("unit5/src/main/resources/note.txt");
            System.out.println("Читаем созданный файл:");
            System.out.println(explorer.readTextFile(filePath));

            System.out.println("Редактируем созданный файл:");
            explorer.editTextFile(filePath, "\r\nnew text!");

            System.out.println("Читаем отредактированный файл:");
            System.out.println(explorer.readTextFile(filePath));

//            System.out.println("Удаляем созданный файл");
//            explorer.removeFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
