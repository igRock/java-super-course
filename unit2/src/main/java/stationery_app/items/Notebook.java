package stationery_app.items;

public class Notebook extends Stationery implements WhatToWriteOn  {
    private int numberOfPages;
    private String size;

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
}
