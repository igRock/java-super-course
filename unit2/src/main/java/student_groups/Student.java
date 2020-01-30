package student_groups;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Group> groups;

    public Student(String name) {
        this.name = name;
        groups = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void showStudyingResults(){
        System.out.println(String.format("Результаты студента %s:", name));

        groups.forEach(group -> System.out.println(String.format(" - по курсу %s - %s", group.getSubject(),
                group.getStudentsMark(this))));
    }
}
