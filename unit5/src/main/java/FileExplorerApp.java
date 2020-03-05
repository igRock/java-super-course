import java.io.File;

public class FileExplorerApp {

    public static void main(String[] args) {
        FileExplorer explorer = new FileExplorer();
        System.out.println("Файлы в корне приложения:");
        System.out.println(explorer.showItems());

        System.out.println("Файлы по определенному пути:");
        System.out.println(explorer.showItems("unit5/src/main/java"));

        String fileName = "note";
        String path = "unit5/src/main/resources";
        System.out.println("Создаем файл");
        explorer.createTextFile("Какой-то текст", fileName, path);

        System.out.println("Читаем созданный файл:");
        System.out.println(explorer.readTextFile("unit5/src/main/resources/note.txt"));

        System.out.println("Редактируем созданный файл:");
        explorer.editTextFile("unit5/src/main/resources/note.txt", "\r\nnew text!");

        System.out.println("Читаем отредактированный файл:");
        System.out.println(explorer.readTextFile("unit5/src/main/resources/note.txt"));

        System.out.println("Удаляем созданный файл");
        explorer.removeFile("unit5/src/main/resources/note.txt");
    }
}
