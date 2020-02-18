package films;

import java.io.*;
import java.util.HashMap;

public class FilmCollection  implements Serializable {
    public static final String BASE_PATH = "/unit3-4/src/main/java/films/collection/film_collection.txt";

    private HashMap<String, Film> collection;
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

    public void save() {
        String basePath = new File("").getAbsolutePath().concat(BASE_PATH);
        try (FileOutputStream os = new FileOutputStream(basePath); ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FilmCollection download() throws ClassNotFoundException, IOException {
        String basePath = new File("").getAbsolutePath().concat(BASE_PATH);
        try (FileInputStream is = new FileInputStream(basePath); ObjectInputStream ois = new ObjectInputStream(is)) {
            return ((FilmCollection) ois.readObject()).numberOfFilmsInit();
        }
    }
}
