package stationery_app.stationery;

public class Paper extends Stationery implements WhatToWriteOn {

    private String size;

    public Paper(String size, Double price) {
        this.size = size;
        this.setName("Листок");
        this.setPrice(price);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void rumple() {
        System.out.println("Скомкал этот лист");
    }
}
