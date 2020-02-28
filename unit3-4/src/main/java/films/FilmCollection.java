package films;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FilmCollection  implements Serializable {
    public static final String BASE_PATH = "/unit3-4/src/main/java/films/collection/film_collection.txt";

    private Map<String, Film> collection;
    transient private int numberoffilms;

    @Override
    public String toString() {
        return "FilmsCollection{" + "collection = " + collection + "}";
    }

    public FilmCollection() {
        collection = new HashMap<>();
    }

    public int getNumberoffilms() {
        return numberoffilms;
    }

    public Film getFilm(String title) {
        return collection.get(title);
    }

    public FilmCollection numberOfFilmsInit() {
        numberoffilms = collection.size();
        return this;
    }

    public Map<String, Film> getCollection() {
        return collection;
    }

    public FilmCollection addFilm(Film film) {
        collection.put(film.getTitle(), film);
        numberoffilms++;
        return this;
    }

    public FilmCollection removeFilm(String title) {
        collection.remove(title);
        numberoffilms--;
        return this;
    }

    public File save(File outputFile) {
        try (FileOutputStream os = new FileOutputStream(outputFile);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile;
    }

    public static FilmCollection download(File file) throws ClassNotFoundException, IOException {
        try (FileInputStream is = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(is)) {
            return ((FilmCollection) ois.readObject()).numberOfFilmsInit();
        }
    }
}
