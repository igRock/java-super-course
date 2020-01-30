package student_groups;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import student_groups.enums.MarkType;
import student_groups.enums.Subject;

public class Group {
    private Subject subject;
    private Map<Student, ? super Number> studentMarkMap;

    public Group(Subject subject) {
        this.subject = subject;
        studentMarkMap = new HashMap();
    }

    public Subject getSubject() {
        return subject;
    }

    public Map<Student, ? super Number> getStudentMarkMap() {
        return studentMarkMap;
    }

    public void addStudentToGroup(Student student) {
        studentMarkMap.put(student, null);
        student.addGroup(this);
    }

    public void examinateStudents() {
        Random random = new Random();
        studentMarkMap.keySet().forEach(student -> {
            if (MarkType.INTEGER.equals(subject.getMarkType())) {
                studentMarkMap.put(student, random.nextInt(5));
            } else {
                studentMarkMap.put(student, Math.floor(random.nextDouble() * 100 * 5) / 100);
            }
        });
    }

    public Number getStudentsMark(Student student) {
        return (Number) studentMarkMap.get(student);
    }

    public void showGroupResults(){
        System.out.println(String.format("Результаты курса %s:", subject));

        studentMarkMap.forEach(((student, mark) -> System.out.println(String.format("Студент %s - %s",
                student.getName(), mark))));

    }
}
