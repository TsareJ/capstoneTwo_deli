package com.ps;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order;

    public void init() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> startNewOrder();
                case "0" -> System.out.println("Thanks for stopping by!");
                default -> System.out.println("Please select a valid choice.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n~~~~~ MR. DELI-cious ~~~~~");
        System.out.println("1) Start Your Order");
        System.out.println("0) Exit Deli");
        System.out.println("Please make a selection!");
    }
    private void startNewOrder() {
        order = new Order();
        boolean ordering = true;

        while (ordering) {
            displayMainMenu();
            String input = scanner.nextLine();

            switch (input) {

            }

        }
    }
}

///  System.out.println(order.toString());
///         System.out.println("Please confirm your order before checking out.");
///         System.out.println("Is this order correct (y/n): ");
///         if (scanner.nextLine().equalsIgnoreCase("y")) {
///             FileManager.writeReceipt(order);