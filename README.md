# 🥪 DELI-cious Sandwich Ordering System

**Capstone Java CLI Application**  
An OOP-driven, fully interactive sandwich ordering system with custom sandwich building, live order summaries, and receipt saving.

---

## 📋 Project Overview

DELI-cious is a command-line application for placing deli orders using an object-oriented design. Customers can build sandwiches with custom toppings, add drinks and chips, remove items, view a live summary, and receive a printed receipt of their order.

Built using **Java**, the system demonstrates **inheritance**, **abstraction**, **enums**, **interfaces**, and **file I/O**.

---

## 🧩 Features

- 🥖 Custom Sandwich Builder (Size, Bread, Premium/Regular Toppings, Toasted)
- 🥤 Drink selection by size and flavor
- 🍟 Chip selection
- 📝 Live Order Summary (auto-updates as items are added)
- 🔁 Remove Items From Order
- 💾 Receipt saved to a `/receipts/` folder
- ✅ Total cost auto-calculated
- 🎯 Clean CLI navigation and prompts

---

## 🏗 Class Design Summary

- Main – Entry point
- UserInterface: Handles CLI and logic
- Order: Holds a list of Products
- Product (interface) –> Implemented by:
Sandwich,
Drink,
& BagOfChips
- Topping (abstract) –> Extended by:
PremiumMeat,
PremiumCheese,
Regular,
- Enums:
SandwichSize, BreadType, Size (for drinks)


## 🧠 Interesting Code: Live Order Summary with Item Removal

```java
private void displayOrderSummary() {
    System.out.println("\nCurrent Order:");
    if (order == null || order.getProducts().isEmpty()) {
        System.out.println(" - (No items added yet)");
    } else {
        int count = 1;
        for (Product p : order.getProducts()) {
            System.out.println(" " + count++ + ") " + p.toString().split("\n")[0]);  // brief
        }
        System.out.printf(" Total so far: $%.2f%n", order.calcTotal());
    }
}

// Remove item option in startNewOrder()
case "5" -> {
    if (order.getProducts().isEmpty()) {
        System.out.println("❌ Your order is empty.");
        break;
    }
    System.out.println("\n🗑 Select an item to remove:");
    int i = 1;
    for (Product p : order.getProducts()) {
        System.out.println(i++ + ") " + p.toString().split("\n")[0]);
    }
    System.out.print("Enter item number to remove (or 0 to cancel): ");
    int selection = Integer.parseInt(scanner.nextLine());
    if (selection > 0 && selection <= order.getProducts().size()) {
        Product removed = order.getProducts().remove(selection - 1);
        System.out.println("✅ Removed: " + removed.toString().split("\n")[0]);
    }
}
