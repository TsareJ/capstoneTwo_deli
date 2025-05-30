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
            displayOrderMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> order.addProduct(SandwichBuilder.build(scanner));
                case "2" -> order.addProduct(DrinkBuilder.build(scanner));
                case "3" -> order.addProduct(ChipBuilder.build(scanner));
                case "4" -> {
                    System.out.println("\n" + order);
                    System.out.print("Please confirm your order! (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        ReceiptWriter.writeReceipt(order);
                        System.out.println("Order confirmed and receipt saved! Thank you for shopping with us.");
                    } else {
                        System.out.println("Order rejected.");
                    }
                    ordering = false;
                }
                case "0" -> {
                    System.out.println("Order cancelled.");
                    ordering = false;
                }
                default -> System.out.println("Invalid input, please try again");
            }
        }
    }
    private void displayOrderMenu() {
        System.out.println("\n~~~~~ Order Menu ~~~~~");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Please select an option: ");
    }
}
