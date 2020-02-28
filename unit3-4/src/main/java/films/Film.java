package films;

import java.io.Serializable;
import java.util.Arrays;

public class Film implements Serializable {
    private String title;
    private Actor[] mainActors;

    public Film(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Actor[] getMainActors() {
        return mainActors;
    }

    public void setMainActors(Actor... actors) {
        mainActors = actors;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        if (!title.equals(film.title)) return false;
        return Arrays.equals(mainActors, film.mainActors);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + Arrays.hashCode(mainActors);
        return result;
    }
}
