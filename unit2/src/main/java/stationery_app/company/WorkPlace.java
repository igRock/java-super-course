package stationery_app.company;

import stationery_app.stationery.enums.PenType;
import stationery_app.stationery.Notebook;
import stationery_app.stationery.Pen;
import stationery_app.stationery.Pencil;
import stationery_app.stationery.Stationery;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class WorkPlace {
    private Employee employee;
    private String address;

    public WorkPlace(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAddress() {
        return address;
    }

    public static List<Stationery> createNewbieSet() {
        List<Stationery> items = new ArrayList<>();
        items.add(new Pen(Color.BLUE, "Parker", PenType.BALLPOINT, 150.00));
        items.add(new Notebook(50, "A5", 150.00));
        items.add(new Pencil(Color.BLACK, "KONSTRUKTOR", "2B", 150.00));

        return items;
    }
}
