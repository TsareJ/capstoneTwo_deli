package com.ps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(Order order) {
        try {
            Path folder = Paths.get("receipts");
            Files.createDirectories(folder);

            String filename = order.orderTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd ~ HH:mm:ss")) +".txt";
            Files.writeString(folder.resolve(filename), order.toString());
            System.out.println("Receipt saved: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving the receipt");
        }
    }
}
