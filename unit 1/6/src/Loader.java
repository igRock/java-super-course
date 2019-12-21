public class Loader {
    public static void main(String[] args) {

        Notebook notebook = new Notebook(10);

        notebook.addNote(new Note("title0", "text0"));
        notebook.addNote(new Note("title2", "text2"));

        notebook.deleteNote(0);

        notebook.editNote(1, new Note("title1", "text1"));

        System.out.println("\nРаспечатка блокнота:");
        for (Note note : notebook.getAllNotes()) {
            System.out.println(note);
        }
    }
}
