public class Notebook {
    private static int notebookId = 0;
    private int index = 0;
    private Note[] notes;

    /**
     *
     * @param notesNumber
     */
    public Notebook(int notesNumber) {
        notebookId++;
        System.out.println("Создан блокнот с id - " + notebookId);
        notes = new Note[notesNumber];
    }

    /**
     *
     * @param note
     * @return
     */
    public int addNote(Note note) {
        try {
            notes[index] = note;
            System.out.println("Запись успешно добавлена");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Блокнот переполнен");
        }
        return index++;
    }

    /**
     *
     * @param index
     * @return
     */
    public int deleteNote(int index) {
        try {
            notes[index] = null;
            System.out.println("Запись успешно удалена");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Введен неправильный индекс записи");
        }
        return index;
    }

    /**
     *
     * @param index
     * @param updatedNote
     * @return
     */
    public int editNote(int index, Note updatedNote) {
        try {
            notes[index] = updatedNote;
            System.out.println("Запись успешно обновлена");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Введен неправильный индекс записи");
        }
        return index;
    }

    public Note[] getAllNotes() {
        return notes;
    }

    public static int getNotebookId() {
        return notebookId;
    }
}
