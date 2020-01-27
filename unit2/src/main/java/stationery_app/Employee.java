package stationery_app;

import java.util.List;
import stationery_app.items.Stationery;

public class Employee {
    private String name;
    private int id;
    private List<Stationery> stationeries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Stationery> getStationeries() {
        return stationeries;
    }

    public void setStationeries(List<Stationery> stationeries) {
        this.stationeries = stationeries;
    }
}
