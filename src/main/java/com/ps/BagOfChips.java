package com.ps;

public class BagOfChips implements Product {
    private String type;
    public BagOfChips(String type) {
        this.type = type;
    }
    @Override
    public double calcPrice() {
        return 1.50;
    }
    @Override
    public String toString(){
        return type + " Chips ($1.50)";
    }
}
