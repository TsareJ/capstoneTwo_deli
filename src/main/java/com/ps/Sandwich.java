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
            case FOUR_INCH -> 5.50;
            case EIGHT_INCH -> 7.00;
            case TWELVE_INCH -> 8.50;
        };
        for (Topping topping : toppings) {
            price += topping.getPrice(size, extras.get(topping));
        }
        return price;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(size).append(" ").append(breadType).append(" sandwich");
        if (toasted) stringBuilder.append(" (Toasted)");
        stringBuilder.append("\nToppings:");
        for (Topping t: toppings) {
            stringBuilder.append("\n - ").append(t.getName());
            if (extras.get(t)) stringBuilder.append(" (Extra)");
        }
        stringBuilder.append(String.format("\nPrice: $%.2f", calcPrice()));
        return stringBuilder.toString();
    }
}
