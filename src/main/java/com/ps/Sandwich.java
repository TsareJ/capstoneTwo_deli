package com.ps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sandwich implements Product {
    private SandwichSize size;
    private BreadType breadType;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();
    private Map<Topping, Boolean> extras = new HashMap<>();

    public Sandwich(SandwichSize size, BreadType breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    public void addTopping(Topping topping, boolean isExtra){
        toppings.add(topping);
        extras.put(topping, isExtra);
    }
    @Override
    public double calcPrice() {
        double price = switch (size) {
            case Four_Inch -> 5.50;
            case Eight_Inch -> 7.00;

        }
    }
}
