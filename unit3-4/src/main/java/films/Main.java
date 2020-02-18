package films;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Actor bradPitt = new Actor("Brad", "Pitt");
        Actor leoDiCaprio = new Actor("Leonardo", "Di Caprio");
        Film movie = new Film("Once upon a time in Hollywood");
        movie.setMainActors(bradPitt, leoDiCaprio);
        FilmCollection filmCollection = new FilmCollection();
        filmCollection.addFilm(movie);
        filmCollection.save();
        try {
            FilmCollection downloadedMovie = FilmCollection.download();
            System.out.println(downloadedMovie.numberOfFilmsInit());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
