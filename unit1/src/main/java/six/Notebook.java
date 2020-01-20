package six;

public class Notebook {
    private int index = 0;
    private Note[] notes;

    /**
     *
     * @param notesNumber
     */
    public Notebook(int notesNumber) {
        notes = new Note[notesNumber];
    }

    /**
     *
     * @param note
     * @return
     */
    public int addNote(Note note) throws RuntimeException {
        try {
            notes[index] = note;
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new RuntimeException("Блокнот переполнен");
        }
        return index++;
    }

    /**
     *
     * @param index
     * @return
     */
    public int deleteNote(int index) throws RuntimeException {
        try {
            notes[index] = null;
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new RuntimeException("Введен неправильный индекс записи");
        }
        return index;
    }

    /**
     *
     * @param index
     * @param updatedNote
     * @return
     */
    public int editNote(int index, Note updatedNote) throws RuntimeException {
        try {
            if (notes[index] == null) {
                throw new RuntimeException("Записи не существует. Сначала создайте ее");
            }
            notes[index] = updatedNote;
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new RuntimeException("Введен неправильный индекс записи");
        }
        return index;
    }

    public Note[] getAllNotes() {
        return notes;
    }
}