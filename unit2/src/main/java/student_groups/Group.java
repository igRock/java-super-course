package student_groups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import student_groups.enums.Subject;

public class Group {
    private Subject subject;
    private Map<Student, List<Number>> studentMarksMap;

    public Group(Subject subject) {
        this.subject = subject;
        studentMarksMap = new HashMap<>();
    }

    public Subject getSubject() {
        return subject;
    }

    public Map<Student, List<Number>> getStudentMarksMap() {
        return studentMarksMap;
    }

    public void addStudentToGroup(Student student) {
        studentMarksMap.put(student, new ArrayList<>());
        student.addGroup(this);
    }

    public List<Number> getStudentsMark(Student student) {
        return studentMarksMap.get(student);
    }
}
