public class Loader {
    public static void main(String[] args) {

        int notesNumber = 10;
        Notebook notebook = new Notebook(notesNumber);
        System.out.println(String.format("Создан новый блокнот на %s страниц", notesNumber));

        try{
            notebook.addNote(new Note("title0", "text0"));
            notebook.addNote(new Note("title2", "text2"));

            notebook.deleteNote(0);

            notebook.editNote(0, new Note("title3", "text3"));
            notebook.editNote(1, new Note("title1", "text1"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("\nРаспечатка блокнота:");
        for (Note note : notebook.getAllNotes()) {
            System.out.println(note);
        }
    }
}
