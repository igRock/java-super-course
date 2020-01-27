package stationery_app;


import stationery_app.company.Employee;
import stationery_app.company.WorkPlace;
import stationery_app.stationery.Stationery;

import java.util.ArrayList;
import java.util.List;

public class StationeryApp {

    public static void main(String[] args) {

        // Создаются рабочие места
        List<WorkPlace> workPlaceList = new ArrayList<>();
        workPlaceList.add(new WorkPlace("Водный"));
        workPlaceList.add(new WorkPlace("ТЦР НН"));
        workPlaceList.add(new WorkPlace("ТЦР ЕКБ"));
        workPlaceList.add(new WorkPlace("ТЦР Рязань"));

        // Нанимаются сотрудники
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Егослав"));
        employees.add(new Employee("Мишаил"));
        employees.add(new Employee("Поликарп"));
        employees.add(new Employee("Евдокимий"));

        // Сотрудники рассаживаются за рабочие места и получают набор новичка
        installmployee(workPlaceList.get(0), employees.get(0));
        installmployee(workPlaceList.get(1), employees.get(1));
        installmployee(workPlaceList.get(2), employees.get(2));
        installmployee(workPlaceList.get(3), employees.get(3));

        // Подсчет, сколько ушло на набор новичка для каждого сотрудника
        employees.forEach(employee -> System.out.println(employee.getName() + " - " +
                countStationeryCost(employee)));

        // Сортировка
    }

    private static void installmployee(WorkPlace workPlace, Employee employee) {
        employee.setStationeries(WorkPlace.createNewbieSet());
        workPlace.setEmployee(employee);
        employee.setWorkingAddress(workPlace.getAddress());
    }

    private static double countStationeryCost(Employee employee) {
        return employee.getStationeries().stream()
                .mapToDouble(Stationery::getPrice)
                .sum();
    }
}

