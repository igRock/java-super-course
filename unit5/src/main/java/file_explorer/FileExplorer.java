package file_explorer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileExplorer {

    private Path globalPath;
    private static Scanner scanner = new Scanner(System.in);

    public FileExplorer() {
        this.globalPath = Path.of("");
    }

    public void run() {
        boolean isRunning = true;
        System.out.println("The app is running. Type \"help\" to list all commands");
        while (isRunning) {
            String input = scanner.nextLine().trim();
            String[] inputParts = input.split(" ");
            String action = inputParts[0];
            try {
                switch (action) {
                    case ("help"):
                        printListOfCommands();
                        break;
                    case ("create"):
                        createTextFile(inputParts);
                        break;
                    case ("edit"):
                        editTextFile(inputParts);
                        break;
                    case ("read"):
                        readTextFile(inputParts);
                        break;
                    case ("delete"):
                        removeFile(inputParts);
                        break;
                    case ("list"):
                        showItems(inputParts);
                        break;
                    case ("exit"):
                        isRunning = false;
                        break;
                    default:
                        break;
                }
            } catch (IOException ex) {
                System.out.println("Wrong path");
            }
        }
    }

    private void printListOfCommands() {
        StringBuilder output = new StringBuilder();
        output.append("create - creates text file i.e. - \"create textFile.txt unit5/src/main/resources\"\n\n");
        output.append("edit - edits text file i.e. - \"edit unit5/src/main/resources/textFile.txt Текст файла\"\n\n");
        output.append("read - reads text file i.e. - \"read unit5/src/main/resources/textFile.txt\"\n\n");
        output.append("delete - deletes file i.e. - \"delete unit5/src/main/resources/textFile.txt\"\n\n");
        output.append("list - lists files in directory i.e. - \"list unit5/src/main/resources\"\n\n");
        output.append("exit - exits app\n\n");
        output.append("help - lists all commands\n\n");
        System.out.println(output.toString());
    }

    private void showItems(String[] inputParts) throws IOException {
        if (inputParts.length > 2) {
            System.out.println("Wrong arguments");
            return;
        }
        Path path = inputParts.length == 1 ? globalPath : Path.of(inputParts[1]);
        showItems(path);
    }

    private void showItems(Path path) throws IOException {
        StringBuilder builder = new StringBuilder();
        Files.list(path).forEach(item -> {
            builder.append(item.getFileName().toString());
            if (Files.isDirectory(item)) {
                builder.append(File.separator);
            }
            builder.append("\r\n");
        });
        System.out.println(builder.toString());
    }

    private void createTextFile(String[] inputParts) throws IOException {
        if (inputParts.length < 2) {
            System.out.println("Wrong arguments");
            return;
        }
        Path path = inputParts.length == 2 ? globalPath : Path.of(inputParts[2]);
        createTextFile(inputParts[1], path);
    }

    private void createTextFile(String fileName, Path path) throws IOException {
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            Files.createDirectories(path);
        }
        Path filePath = Paths.get(path.toString(), fileName);
        if (Files.exists(filePath)) {
            return;
        }
        Path newFile = Files.createFile(filePath);
        System.out.println("Enter something to file");
        Files.write(newFile, Collections.singleton(scanner.nextLine()), StandardCharsets.UTF_8);
        System.out.println("File created");
    }

    private void removeFile(String[] inputParts) throws IOException {
        if (inputParts.length != 2) {
            System.out.println("Wrong arguments");
            return;
        }
        Files.delete(Path.of(inputParts[1]));
        System.out.println("File deleted");
    }

    private void editTextFile(String[] inputParts) throws IOException {
        if (inputParts.length < 3) {
            System.out.println("Wrong arguments");
            return;
        }
        System.out.println("Enter something to file");
        Files.write(Path.of(inputParts[1]), Collections.singleton(scanner.nextLine()), StandardCharsets.UTF_8);
    }

    private void readTextFile(String[] inputParts) throws IOException {
        if (inputParts.length != 2) {
            System.out.println("Wrong arguments");
            return;
        }
        System.out.println(Files.readAllLines(Path.of(inputParts[1])).stream().collect(Collectors.joining("\n")));
    }
}