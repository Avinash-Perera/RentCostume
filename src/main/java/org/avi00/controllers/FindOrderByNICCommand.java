package org.avi00.controllers;

import org.avi00.models.Order;
import org.avi00.models.OrderInventory;

import java.util.List;
import java.util.Scanner;

public class FindOrderByNICCommand implements Command {
    // Quick Sort implementation for sorting orders by order ID
    private void quickSort(List<Order> orders, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(orders, low, high);

            // Recursively sort elements before and after the partition
            quickSort(orders, low, partitionIndex - 1);
            quickSort(orders, partitionIndex + 1, high);
        }
    }

    private int partition(List<Order> orders, int low, int high) {
        int pivot = orders.get(high).getOrderId();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders.get(j).getOrderId() < pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }

        // Swap orders[i+1] and orders[high] (or pivot)
        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);

        return i + 1;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer NIC: ");
        String customerNIC = scanner.nextLine();

        // Get the list of orders related to the entered NIC
        OrderInventory orderInventory = OrderInventory.getInstance();
        List<Order> ordersByNIC = orderInventory.getOrdersByNic(customerNIC);

        if (!ordersByNIC.isEmpty()) {
            // Sort orders by order ID using Quick Sort
            quickSort(ordersByNIC, 0, ordersByNIC.size() - 1);

            System.out.println("Orders related to NIC: " + customerNIC);
            for (Order order : ordersByNIC) {
                order.displayOrderDetails(); // Display order details for each order
            }
        } else {
            System.out.println("No orders found for NIC: " + customerNIC);
        }
    }
}
