package student_groups.enums;

public enum Subject {
    MATHS(MarkType.INTEGER),
    RUSSIAN(MarkType.REAL);

    private MarkType markType;

    Subject(MarkType markType) {
        this.markType = markType;
    }

    public MarkType getMarkType() {
        return markType;
    }
}


