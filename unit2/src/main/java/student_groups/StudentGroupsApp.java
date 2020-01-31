package student_groups;

import java.util.List;
import java.util.Map;
import java.util.Random;
import student_groups.enums.MarkType;
import student_groups.enums.Subject;

public class StudentGroupsApp {
    private static Random random = new Random();

    public static void main(String[] args) {

        Student misha = new Student("Миша");
        Student stepa = new Student("Степа");
        Student dima = new Student("Дима");
        Student sasha = new Student("Саша");

        Group mathsGroup = new Group(Subject.MATHS);
        mathsGroup.addStudentToGroup(misha);
        mathsGroup.addStudentToGroup(stepa);
        mathsGroup.addStudentToGroup(dima);
        mathsGroup.addStudentToGroup(sasha);

        examinateStudents(mathsGroup);

        Group russianGroup = new Group(Subject.RUSSIAN);
        russianGroup.addStudentToGroup(misha);
        russianGroup.addStudentToGroup(stepa);

        examinateStudents(russianGroup);

        showStudyingResults(misha);
        showStudyingResults(stepa);

        showGroupResults(mathsGroup);
        showGroupResults(russianGroup);
    }

    private static void examinateStudents(Group group) {
        Map<Student, List<Number>> studentMarkMap = group.getStudentMarksMap();
        studentMarkMap.keySet().forEach(student -> {
            if (MarkType.INTEGER.equals(group.getSubject().getMarkType())) {
                studentMarkMap.get(student).add(random.nextInt(5));
            } else {
                studentMarkMap.get(student).add(Math.floor(random.nextDouble() * 100 * 5) / 100);
            }
        });
    }

    private static void showStudyingResults(Student student){
        List<Group> groups = student.getGroups();
        System.out.println(String.format("Результаты студента %s:", student.getName()));

        groups.forEach(group -> System.out.println(String.format(" - по курсу %s - %s", group.getSubject(),
                                                                 group.getStudentsMark(student))));
    }

    private static void showGroupResults(Group group){
        Map<Student, List<Number>> studentMarkMap = group.getStudentMarksMap();
        System.out.println(String.format("Результаты курса %s:", group.getSubject()));
        studentMarkMap.forEach(((student, marks) -> System.out.println(String.format("Студент %s - %s",
                                                                                    student.getName(),
                                                                                     getAverageMark(marks)))));
    }

    private static double getAverageMark(List<Number> marks) {
        return marks.stream()
            .mapToDouble(Number::doubleValue)
            .average()
            .orElse(0);
    }
}
