package com.ps;

import java.util.List;
import java.util.Scanner;

public class SandwichBuilder {
    public static Sandwich build(Scanner scanner) {
        System.out.println("\n~~~~~ Build Your Sandwich Here! ~~~~~");

        SandwichSize sandwichSize = chooseSize(scanner);
        BreadType breadType = chooseBread(scanner);
        boolean toasted = askToasted(scanner);

        Sandwich sandwich = new Sandwich(sandwichSize, breadType, toasted);

        addPremiumMeats(scanner, sandwich);
        addPremiumCheese(scanner, sandwich);
        addRegularToppings(scanner, sandwich);
        addSauces(scanner, sandwich);

        return sandwich;
    }

    private static SandwichSize chooseSize(Scanner scanner) {
        System.out.println("Select sandwich size: ");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");
        while (true) {
            switch (scanner.nextLine()) {
                case "1" -> {
                    return SandwichSize.FOUR_INCH;
                }
                case "2" -> {
                    return SandwichSize.EIGHT_INCH;
                }
                case "3" -> {
                    return SandwichSize.TWELVE_INCH;
                }
                default -> System.out.print("Please select a valid input!: ");
            }
        }
    }

    private static BreadType chooseBread(Scanner scanner) {
        System.out.println("Select Bread: ");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        while (true) {
            switch (scanner.nextLine()) {
                case "1" -> {
                    return BreadType.WHITE;
                }
                case "2" -> {
                    return BreadType.WHEAT;
                }
                case "3" -> {
                    return BreadType.RYE;
                }
                case "4" -> {
                    return BreadType.WRAP;
                }
                default -> System.out.print("May you please select a valid input!: ");
            }
        }
    }

    private static boolean askToasted(Scanner scanner) {
        System.out.print("Would you like your bread toasted? (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    private static void addPremiumMeats(Scanner scanner, Sandwich sandwich) {
        List<String> meats = List.of("Turkey", "Steak", "Fried Chicken", "Turkey Bacon", "Jerk Fish", "Salami");
        System.out.println("Please select your protein (Input 0 to finish):");
        for (int i = 0; i < meats.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, meats.get(i));
        }
        while (true) {
            System.out.print("What's your choice of meat: ");
            String input = scanner.nextLine();
            if (input.equals("0")) break;
            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < meats.size()) {
                    boolean extra = askExtra(scanner, meats.get(index));
                    sandwich.addTopping(new PremiumMeat(meats.get(index)), extra);
                } else {
                    System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static void addPremiumCheese(Scanner scanner, Sandwich sandwich) {
        List<String> cheese = List.of("Swiss", "Cheddar", "Munster", "Pepper Jack", "Provolone", "American");
        System.out.println("Please select your cheese (Input 0 to finish):");
        for (int i = 0; i < cheese.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, cheese.get(i));
        }
        while (true) {
            System.out.print("What's your choice of cheese: ");
            String input = scanner.nextLine();
            if (input.equals("0")) break;
            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < cheese.size()) {
                    boolean extra = askExtra(scanner, cheese.get(index));
                    sandwich.addTopping(new PremiumCheese(cheese.get(index)), extra);
                } else {
                    System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static void addRegularToppings(Scanner scanner, Sandwich sandwich) {
        List<String> toppings = List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms");
        System.out.println("Please select your standard toppings (Input 0 to finish):");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, toppings.get(i));
        }
        while (true) {
            System.out.print("What's your choice of toppings: ");
            String input = scanner.nextLine();
            if (input.equals("0")) break;
            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < toppings.size()) {
                    sandwich.addTopping(new Regular(toppings.get(index)), false);
                } else {
                    System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
    private static void addSauces(Scanner scanner, Sandwich sandwich) {
        List<String> sauces = List.of("Mayo", "Mustard", "Ketchup", "Ranch", "Pepper Sauce");
        System.out.println("Please select your standard sauces (Input 0 to finish):");
        for (int i = 0; i < sauces.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, sauces.get(i));
        }
        while (true) {
            System.out.print("What's your choice of sauces: ");
            String input = scanner.nextLine();
            if (input.equals("0")) break;
            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < sauces.size()) {
                    sandwich.addTopping(new Regular(sauces.get(index)), false);
                } else {
                    System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
    private static boolean askExtra(Scanner scanner, String name) {
        System.out.printf("Extra %s? (y/n): ",name);
        return scanner.nextLine().equalsIgnoreCase("y");
    }
}