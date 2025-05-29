package com.ps;

import java.util.List;
import java.util.Scanner;

public class ChipBuilder {
    public static BagOfChips build(Scanner scanner) {
        System.out.println("\n ~~~~~ Add Chips ~~~~~");

        List<String> chipTypes = List.of("Classic", "Honey BBQ", "Sour Cream & Onion", "Goldfish");
        for (int i = 0; i < chipTypes.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, chipTypes.get(i));
        }

        while (true) {
            System.out.print("Please select your chips: ");
            try {
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index >= 0 && index < chipTypes.size()) {
                    return new BagOfChips(chipTypes.get(index));
                } else {
                    System.out.println("Please select a valid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please select a valid input.");
            }
        }
    }
}
