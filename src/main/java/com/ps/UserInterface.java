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

        System.out.println("\nLet's start making your order!");

        while (ordering) {
            displayOrderMenu();
            displayOrderSummary();

            System.out.print("Please select an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    order.addProduct(SandwichBuilder.build(scanner));
                    System.out.println("✅ Your Sandwich has been added!\n");
                }
                case "2" -> {
                    order.addProduct(DrinkBuilder.build(scanner));
                    System.out.println("✅Your Drink has been added!\n");
                }
                case "3" -> {
                    order.addProduct(ChipBuilder.build(scanner));
                    System.out.println("✅ Your Chips have been added!\n");
                }
                case "4" -> {
                    System.out.println("\n Final Order Summary:\n");
                    System.out.println(order);
                    System.out.print("Please confirm your order! (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        ReceiptWriter.writeReceipt(order);
                        System.out.println("✅Order confirmed and receipt saved! Thank you for shopping with us.");
                    } else {
                        System.out.println("❌Order rejected.");
                    }
                    ordering = false;
                }
                case "0" -> {
                    System.out.println("❌Order cancelled.");
                    ordering = false;
                }
                default -> System.out.println("⚠ Invalid input, please try again");
            }
        }
    }

    private void displayOrderSummary() {
        System.out.println("\nCurrent Order:");
        if (order == null || order.getProducts().isEmpty()) {
            System.out.println("- (No items have been added yet)");
        }else {
            int count = 1;
            for (Product product : order.getProducts()) {
                System.out.println(" " + count++ + ") " + product.toString().split("\n")[0]);
            }
            System.out.printf(" Current Total: $%.2f%n", order.calcTotal());
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
