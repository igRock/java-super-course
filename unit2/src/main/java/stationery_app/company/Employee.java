package stationery_app.company;

import stationery_app.stationery.Stationery;

import java.util.List;

public class Employee {
    private String name;
    private WorkPlace workPlace;
    private List<Stationery> stationeries;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Stationery> getStationeries() {
        return stationeries;
    }

    public void setStationeries(List<Stationery> stationeries) {
        this.stationeries = stationeries;
    }

    public WorkPlace getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(WorkPlace workPlace) {
        this.workPlace = workPlace;
    }
}
