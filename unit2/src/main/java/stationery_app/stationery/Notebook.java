package stationery_app.stationery;

public class Notebook extends Stationery implements WhatToWriteOn  {
    private int numberOfPages;
    private String size;

    public Notebook(int numberOfPages, String size, Double price) {
        this.numberOfPages = numberOfPages;
        this.size = size;
        this.setName("Блокнот");
        this.setPrice(price);
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void rumple() {
        System.out.println("Вырвал лист из блокнота");
    }
}
