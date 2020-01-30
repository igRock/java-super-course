package student_groups;

import student_groups.enums.Subject;

public class StudentGroupsApp {
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

        mathsGroup.examinateStudents();


        Group russianGroup = new Group(Subject.RUSSIAN);
        russianGroup.addStudentToGroup(misha);
        russianGroup.addStudentToGroup(stepa);

        russianGroup.examinateStudents();


        misha.showStudyingResults();
        stepa.showStudyingResults();

        mathsGroup.showGroupResults();
        russianGroup.showGroupResults();
    }
}
