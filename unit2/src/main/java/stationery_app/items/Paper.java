package stationery_app.items;

import stationery_app.enums.PenType;

public class Paper extends Stationery implements WhatToWriteOn {

    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
