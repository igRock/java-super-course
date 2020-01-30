package student_groups;

public class Mark <T extends Number> {
    private final T value;

    public Mark(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
