package com.ps;

public class Drink implements Product{
    private Size size;
    private String flavor;

    public Drink(Size size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double calcPrice() {
        return switch (size) {
            case SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
        };
    }

    @Override
    public String toString() {
        return size + " " + flavor
    }
}
