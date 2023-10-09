package org.avi00;

import org.avi00.controllers.CostumeInventoryController;
import org.avi00.controllers.OrderController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize controllers and other necessary objects
        CostumeInventoryController costumeInventoryController = new CostumeInventoryController();
        OrderController orderController = new OrderController();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Costume Shop!");

        boolean isRunning = true;
        while (isRunning) {
            // Display the main menu
            System.out.println("Main Menu:");
            System.out.println("1. Costume Inventory");
            System.out.println("2. Place Orders");
            System.out.println("3. Return Orders");
            System.out.println("-1. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    costumeInventoryController.manageInventory();
                    break;
                case "2":
                    orderController.showMenu();
                    break;
                case "-1":
                    isRunning = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}