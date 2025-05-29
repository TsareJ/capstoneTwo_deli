package com.ps;

public abstract class Premium extends Topping {
    protected Premium(String name) {
        super(name);
    }
    @Override
    public boolean isPremium() {
        return true;
    }
}
