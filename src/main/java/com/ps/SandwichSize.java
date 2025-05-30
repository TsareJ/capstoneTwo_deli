package com.ps;

public enum SandwichSize {
    FOUR_INCH(5.50, 1.00, 0.50, 0.75, 0.30),
    EIGHT_INCH(7.00, 2.00, 1.00, 1.50, 0.60),
    TWELVE_INCH(8.50, 3.00, 1.50, 2.25, 0.90);

    private double basePrice;
    private double meatPrice;
    private double extraMeatPrice;
    private double cheesePrice;
    private double extraCheesePrice;

    SandwichSize(double basePrice, double meatPrice, double extraMeatPrice, double cheesePrice, double extraCheesePrice) {
        this.basePrice = basePrice;
        this.extraCheesePrice = extraCheesePrice;
        this.cheesePrice = cheesePrice;
        this.extraMeatPrice = extraMeatPrice;
        this.meatPrice = meatPrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getMeatPrice() {
        return meatPrice;
    }

    public void setMeatPrice(double meatPrice) {
        this.meatPrice = meatPrice;
    }

    public double getExtraMeatPrice() {
        return extraMeatPrice;
    }

    public void setExtraMeatPrice(double extraMeatPrice) {
        this.extraMeatPrice = extraMeatPrice;
    }

    public double getCheesePrice() {
        return cheesePrice;
    }

    public void setCheesePrice(double cheesePrice) {
        this.cheesePrice = cheesePrice;
    }
}
