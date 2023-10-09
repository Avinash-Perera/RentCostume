package org.avi00.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController {
    private List<Command> commands;

    public OrderController() {
        this.commands = new ArrayList<>();
        commands.add(new PlaceOrderCommand());
        commands.add(new FindOrderByNICCommand());
        commands.add(new SeeAllOrdersCommand());
//        commands.add(new FinishOrderCommand());

    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != -1) {
            System.out.println("Menu Options:");
            System.out.println("1. Place Order");
            System.out.println("2. Find Order by NIC");
            System.out.println("3. See All Orders");
            System.out.println("4. Finish Order");
            System.out.println("-1. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice >= 1 && choice <= commands.size()) {
                // Execute the selected command
                commands.get(choice - 1).execute();
            } else if (choice == -1) {
                System.out.println("Exiting.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
