package stationery_app.items;

import java.awt.Color;
import java.util.Objects;
import stationery_app.enums.PenType;

public class Pen extends Stationery implements Writer{
    private Color color;
    private String brand;
    private PenType penType;

    public Pen(Color color, String brand, PenType penType) {
        this.color = color;
        this.brand = brand;
        this.penType = penType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public PenType getPenType() {
        return penType;
    }

    public void setPenType(PenType penType) {
        this.penType = penType;
    }

    @Override
    public void write() {
        System.out.println("Ручка пишет этот текст");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Pen pen = (Pen) object;
        return Objects.equals(color, pen.color) &&
            Objects.equals(brand, pen.brand) &&
            penType == pen.penType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, brand, penType);
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("Цвет - ")
            .append(color.toString())
            .append("\n")
            .append("Бренд - ")
            .append(brand)
            .append("\n")
            .append("Тип - ")
            .append(penType)
            .toString();
    }
}
