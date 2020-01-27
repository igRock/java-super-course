package stationery_app.stationery;

import java.awt.*;
import java.util.Objects;

public class Pencil extends Stationery implements Writer{
    private Color color;
    private String brand;
    private String bold;

    public Pencil(Color color, String brand, String bold, Double price) {
        this.color = color;
        this.brand = brand;
        this.bold = bold;
        this.setName("Карандаш");
        this.setPrice(price);
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

    public String getBold() {
        return bold;
    }

    public void setBold(String bold) {
        this.bold = bold;
    }

    @Override
    public void write() {
        System.out.println("Карандаш пишет этот текст");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Pencil pen = (Pencil) object;
        return Objects.equals(color, pen.color) &&
            Objects.equals(brand, pen.brand) &&
            bold == pen.bold;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, brand, bold);
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
            .append("Жирность - ")
            .append(bold)
            .toString();
    }
}
