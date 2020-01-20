package six;

public class Note {
    private String title;
    private String text;

    /**
     *
     * @param title
     * @param text
     */
    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return String.format("Запись: заголовок - %s; текст - %s", title, text);
    }
}