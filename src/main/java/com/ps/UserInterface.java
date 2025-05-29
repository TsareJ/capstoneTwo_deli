package com.ps;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order;

    public void init() {
        boolean running = true;
        while (running) {
            display();
            switch (scanner.nextLine()) {
                case "1" -> checkout();
                case "2" -> running = false;
                default -> System.out.println("Please select a valid choice.");
            }

        }
    }

    private void display() {
        System.out.println("\n~~~~~ MR. DELI-cious ~~~~~");
        System.out.println("1) Start Your Order");
        System.out.println("0) Exit Deli");
        System.out.println("Please make a selection!");
    }
    private void checkout() {
        order = new Order();
        System.out.println(order.toString());
        System.out.println("Please confirm your order before checking out.");
        System.out.println("Is this order correct (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            FileManager.writeReceipt(order);
        }

    }

}
