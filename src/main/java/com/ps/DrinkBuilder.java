package com.ps;

import java.util.Scanner;

public class DrinkBuilder {
    public static Drink build(Scanner scanner) {
        System.out.println("\n~~~~~ Add your Drink ~~~~~");

        Size size = chooseSize(scanner);
        System.out.print("Choose a drink flavor:");
        System.out.println("Cola, Lemonade, Ice Tea, Water");
        String flavor = scanner.nextLine();

        return new Drink(size, flavor);
    }

    private static Size chooseSize(Scanner scanner) {
        System.out.println("Please select your drink size:");
        System.out.println("1) Small ($2.00)");
        System.out.println("2) Medium ($2.50)");
        System.out.println("3) Large ($3.00)");

        while (true) {
            System.out.print("Select your choice: ");
            switch (scanner.nextLine()) {
                case "1" -> { return Size.SMALL; }
                case "2" -> { return Size.MEDIUM; }
                case "3" -> { return Size.LARGE; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
