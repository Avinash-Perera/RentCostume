package org.avi00.controllers;

import org.avi00.models.CostumeInventory;
import org.avi00.models.Order;
import org.avi00.models.OrderInventory;

import java.util.Date;
import java.util.Scanner;

public class FinishOrderCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Finish Order");
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        OrderInventory orderInventory = OrderInventory.getInstance();
        CostumeInventory costumeInventory = CostumeInventory.getInstance();

        // Find the order by ID
        Order order = orderInventory.getOrderById(orderId);

        if (order != null) {
            // Calculate the number of days the costume was rented
            Date currentDate = new Date();
            long rentalDays = (currentDate.getTime() - order.getRentalStartDate().getTime()) / (24 * 60 * 60 * 1000);

            // Calculate the total amount based on the actual rental days
            double totalAmount = order.getRentedCostume().getPrice() * rentalDays;

            System.out.println("Order Details:");
            // Display order details, rental days, and total amount
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Customer Name: " + order.getCustomerFullName());
            System.out.println("Customer Address: " + order.getCustomerAddress());
            System.out.println("Customer NIC: " + order.getCustomerNIC());
            System.out.println("Number of Rental Days: " + rentalDays);
            System.out.println("Rented Costume: " + order.getRentedCostume().getName());
            System.out.println("Rental Start Date: " + order.getRentalStartDate());
            System.out.println("Total Amount: " + totalAmount);

            // Prompt the user to confirm closing the order
            System.out.print("Do you want to close the order (Yes/No)? ");
            String closeChoice = scanner.nextLine().toLowerCase();

            if (closeChoice.equals("yes")) {
                // Set the rental status of the costume to "Available"
                order.getRentedCostume().setRentalStatus("Available");

                // Delete the order
                orderInventory.deleteOrderById(orderId);

                System.out.println("Order closed successfully.");
            } else {
                System.out.println("Order will not be closed.");
            }
        } else {
            System.out.println("Order not found.");
        }
    }
}