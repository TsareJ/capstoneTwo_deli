package com.ps;

public class Regular extends Topping {
    public Regular(String name) {
        super(name);
    }
    @Override
    public boolean isPremium() {
        return false;
    }
    @Override
    public double getPrice(SandwichSize size, boolean isExtra) {
        return 0.0;
    }
}
