package com.ps;

public enum Size {
    SMALL(2.00),
    MEDIUM(2.50),
    LARGE(3.00);

    private final double price;

    Size(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return switch (this) {
            case SMALL -> "Small";
            case MEDIUM -> "Medium";
            case LARGE -> "Large";
        };
    }
}
