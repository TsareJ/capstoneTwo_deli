package com.ps;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    public LocalDateTime orderTime = LocalDateTime.now();
    public void addProduct (Product p) {
        products.add(p);
    }
    public double calcTotal() {
        return products.stream().mapToDouble(Product ::calcPrice).sum();
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("~~~~~ Order Summary ~~~~~\n");
        for (Product p: products) {
            stringBuilder.append(p.toString()).append("\n\n");
            stringBuilder.append(String.format("Total: $%.2f\n", calcTotal()));

        }
        return stringBuilder.toString();
    }
}