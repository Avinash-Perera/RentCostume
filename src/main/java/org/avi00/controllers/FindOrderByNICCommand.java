package org.avi00.controllers;

import org.avi00.models.Order;
import org.avi00.models.OrderInventory;

import java.util.List;
import java.util.Scanner;

public class FindOrderByNICCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer NIC: ");
        String customerNIC = scanner.nextLine();

        // Get the list of orders related to the entered NIC
        OrderInventory orderInventory = OrderInventory.getInstance();
        List<Order> ordersByNIC = orderInventory.getOrdersByNic(customerNIC);

        if (!ordersByNIC.isEmpty()) {
            System.out.println("Orders related to NIC: " + customerNIC);
            for (Order order : ordersByNIC) {
                order.displayOrderDetails(); // Display order details for each order
            }
        } else {
            System.out.println("No orders found for NIC: " + customerNIC);
        }
    }
}
