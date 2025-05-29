package com.ps;

public class PremiumCheese extends Premium {
    public PremiumCheese(String name) {
        super(name);
    }

    @Override
    public double getPrice(SandwichSize size, boolean isExtra) {
        double basePrice = switch (size) {
            case FOUR_INCH -> 0.75;
            case EIGHT_INCH -> 1.50;
            case TWELVE_INCH -> 2.25;
        };
        double extra = switch (size) {
            case FOUR_INCH -> 0.30;
            case EIGHT_INCH -> 0.60;
            case TWELVE_INCH -> 0.90;
        };
        return isExtra ? extra : basePrice;
    }
}
