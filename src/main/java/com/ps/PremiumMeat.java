package com.ps;

public class PremiumMeat extends Premium {
    public PremiumMeat(String name) {
        super(name);

    }

    @Override
    public double getPrice(SandwichSize size, boolean isExtra) {
        double basePrice = switch (size) {
            case FOUR_INCH -> 1.00;
            case EIGHT_INCH -> 2.00;
            case TWELVE_INCH -> 3.00;
        };
        double extra = switch (size) {
            case FOUR_INCH -> 0.50;
            case EIGHT_INCH -> 1.00;
            case TWELVE_INCH -> 1.50;
        };
        return isExtra ? extra : basePrice;
    }
}