package stationery_app.items;

public abstract class Stationery implements Comparable {
    private String name;
    private Double price;
    private Integer employeeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
