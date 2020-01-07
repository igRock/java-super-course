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
    public int addNote(Note note) throws Exception {
        try {
            notes[index] = note;
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new Exception("Блокнот переполнен");
        }
        return index++;
    }

    /**
     *
     * @param index
     * @return
     */
    public int deleteNote(int index) throws Exception {
        try {
            notes[index] = null;
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new Exception("Введен неправильный индекс записи");
        }
        return index;
    }

    /**
     *
     * @param index
     * @param updatedNote
     * @return
     */
    public int editNote(int index, Note updatedNote) throws Exception {
        try {
            if (notes[index] == null) {
                throw new Exception("Записи не существует. Сначала создайте ее");
            }
            notes[index] = updatedNote;
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new Exception("Введен неправильный индекс записи");
        }
        return index;
    }

    public Note[] getAllNotes() {
        return notes;
    }
}
