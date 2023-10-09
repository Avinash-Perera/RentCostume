package org.avi00.controllers;

import org.avi00.models.Costume;
import org.avi00.models.CostumeInventory;
import org.avi00.models.Order;
import org.avi00.models.OrderInventory;

import java.util.Date;
import java.util.Scanner;

public class PlaceOrderCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Place Order");
        System.out.print("Enter Customer Full Name: ");
        String customerFullName = scanner.nextLine();
        System.out.print("Enter Customer Address: ");
        String customerAddress = scanner.nextLine();
        System.out.print("Enter Customer NIC: ");
        String customerNIC = scanner.nextLine();
        System.out.print("Enter Number of Rental Days: ");
        int numberOfRentalDays = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Display available costumes from the inventory
        CostumeInventory costumeInventory = CostumeInventory.getInstance();

        System.out.print("Enter Costume ID to Rent: ");
        int costumeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Retrieve the selected costume from the inventory
        Costume rentedCostume = costumeInventory.getCostumeById(costumeId);

        if (rentedCostume != null) {
            // Check if the costume is available for rent
            if (!rentedCostume.getRentalStatus().equals("Rented")) {
                // Create a new order
                Order newOrder = new Order(customerFullName, customerAddress, customerNIC,
                        numberOfRentalDays, rentedCostume);

                // Get the current date
                Date currentDate = new Date();

                // Calculate and update the total amount for the order based on rental days
                OrderInventory orderInventory = OrderInventory.getInstance();


                // Add the order to the order inventory
                orderInventory.addOrder(newOrder);

                // Generate a receipt for the order
                String receipt = orderInventory.generateReceipt(newOrder);
                System.out.println(receipt);

                // Update the rentalStatus of the rented costume to "Rented"
                rentedCostume.setRentalStatus("Rented");

                System.out.println("Order placed successfully!");
            } else {
                System.out.println("The selected costume is already rented.");
            }
        } else {
            System.out.println("Costume not found.");
        }
    }
}