package stationery_app.company;

import stationery_app.stationery.Stationery;

import java.util.List;

public class Employee {
    private static int id;
    private String name;
    private String workingAddress;
    private List<Stationery> stationeries;

    public Employee(String name) {
        this.name = name;
        id ++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Stationery> getStationeries() {
        return stationeries;
    }

    public void setStationeries(List<Stationery> stationeries) {
        this.stationeries = stationeries;
    }

    public String getWorkingAddress() {
        return workingAddress;
    }

    public void setWorkingAddress(String workingAddress) {
        this.workingAddress = workingAddress;
    }
}
