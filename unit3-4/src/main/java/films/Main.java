package films;

import java.io.File;
import java.io.IOException;

public class Main {
    public static final String BASE_PATH = "/unit3-4/src/main/java/films/collection";

    public static void main(String[] args) {
        System.out.println("Создаем коллекцию с одним фильмом - Once upon a time in Hollywood");
        Actor bradPitt = new Actor("Brad", "Pitt");
        Actor leoDiCaprio = new Actor("Leonardo", "Di Caprio");
        Film movie = new Film("Once upon a time in Hollywood");
        movie.setMainActors(bradPitt, leoDiCaprio);
        FilmCollection filmCollection = new FilmCollection();
        filmCollection.addFilm(movie);

        File folder = new File(new File("").getAbsolutePath().concat(BASE_PATH));
        if (!folder.exists()) {
            folder.mkdir();
        }
        System.out.println("Сохраняем коллекцию в папке - " + folder.getAbsolutePath());
        File savedFile = filmCollection.save(new File(folder.getAbsolutePath().concat("/film_collection.txt")));
        try {
            System.out.println("Получаем из файла коллекцию c фильмами:");
            FilmCollection downloadedMovie = FilmCollection.download(savedFile);
            downloadedMovie.getCollection().entrySet().forEach(entry -> {
                System.out.println(entry.getKey());
                System.out.println("В главных ролях:");
                for (Actor actor : entry.getValue().getMainActors()) {
                    System.out.println(actor.toString());
                }
            });
            System.out.println();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
