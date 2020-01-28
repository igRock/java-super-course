package stationery_app;


import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
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
        List<Stationery> allStationeries = employees.stream()
            .map(Employee::getStationeries)
            .flatMap(List::stream)
            .collect(Collectors.toList());

        List<Stationery> sortedByPriceStationeries = sortByPrice(allStationeries);
        List<Stationery> sortedByNameStationeries = sortByName(allStationeries);
        List<Stationery> sortedByNamePriceStationeries = sortByNamePrice(allStationeries);
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

    private static List<Stationery> sortByPrice(List<Stationery> stationeries) {
        //по стоимости
        Collections.sort(stationeries, Comparator.comparing(Stationery::getPrice));
        return stationeries;
    }

    private static List<Stationery> sortByName(List<Stationery> stationeries) {
        //по наименованию
        Collections.sort(stationeries, Comparator.comparing(Stationery::getName));
        return stationeries;
    }

    private static List<Stationery> sortByNamePrice(List<Stationery> stationeries) {
        //по наименованию и по цене
        Collections.sort(stationeries, Comparator.comparing(Stationery::getName).thenComparing(Stationery::getPrice));
        return stationeries;
    }
}

