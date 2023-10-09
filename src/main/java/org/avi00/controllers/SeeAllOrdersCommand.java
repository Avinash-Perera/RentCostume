package org.avi00.controllers;

import org.avi00.models.Order;
import org.avi00.models.OrderInventory;

import java.util.List;

public class SeeAllOrdersCommand implements Command {

    @Override
    public void execute() {
        OrderInventory orderInventory = OrderInventory.getInstance();
        List<Order> allOrders = orderInventory.getAllOrders();

        if (allOrders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            System.out.println("All Orders:");
            for (Order order : allOrders) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Customer Name: " + order.getCustomerFullName());
                System.out.println("Customer Address: " + order.getCustomerAddress());
                System.out.println("Customer NIC: " + order.getCustomerNIC());
                System.out.println("Number of Rental Days: " + order.getNumberOfRentalDays());
                System.out.println("Rented Costume: " + order.getRentedCostume().getName());
                System.out.println("Rental Start Date: " + order.getRentalStartDate());
                System.out.println("Total Amount: " + order.getTotalAmount());
                System.out.println("-----------------------------------------------------------------------");
            }
        }
    }
}



