package student_groups;

import java.util.List;
import java.util.Map;
import student_groups.enums.MarkType;
import student_groups.enums.Subject;

public class Group {
    private Subject subject;
    private Map<Student, Mark> studentMarkMap;

    public Group(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public Map<Student, Mark> getStudentMarkMap() {
        return studentMarkMap;
    }

    public void formGroup(List<Student> studentList) {
        studentList.forEach(student -> studentMarkMap.put(student, null));
    }

    public <T extends Number> void putMarkToStudent(Student student, T markValue) {
        if (MarkType.INTEGER.equals(subject.getMarkType())) {
            studentMarkMap.put(student, new Mark<>((Integer) markValue));
        } else {
            studentMarkMap.put(student, new Mark<>((Double) markValue));
        }
    }
}
