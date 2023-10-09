package org.avi00.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderInventory implements IOrderInventory {
    private List<Order> order;

    private static OrderInventory instance; // Singleton instance

    private OrderInventory() {
        this.order = new ArrayList<>();
    }

    public static OrderInventory getInstance() {
        if (instance == null) {
            instance = new OrderInventory();
        }
        return instance;
    }

    public void addOrder(Order newOrder) {
        order.add(newOrder);
    }

    @Override
    public List<Order> getAllOrders() {
        return order; // Assuming 'order' is the list containing all orders
    }



    @Override
    public String generateReceipt(Order order) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("-----------------------------------------------------------------------\n");
        receipt.append("Receipt\n");
        receipt.append("-----------------------------------------------------------------------\n");
        receipt.append("Customer Name: ").append(order.getCustomerFullName()).append("\n");
        receipt.append("Customer Address: ").append(order.getCustomerAddress()).append("\n");
        receipt.append("Customer NIC: ").append(order.getCustomerNIC()).append("\n");
        receipt.append("Number of Rental Days: ").append(order.getNumberOfRentalDays()).append("\n");
        receipt.append("Rented Costume: ").append(order.getRentedCostume().getName()).append("\n");
        receipt.append("Rental Start Date: ").append(order.getRentalStartDate()).append("\n");
        receipt.append("-----------------------------------------------------------------------\n");
        // Calculate the total price by multiplying the number of rental days with the costume price
        double totalAmount = order.getRentedCostume().getPrice() * order.getNumberOfRentalDays();

        receipt.append("Total Amount: ").append(totalAmount).append("\n");
        receipt.append("-----------------------------------------------------------------------\n");
        receipt.append("-----------------------------------------------------------------------\n");
        return receipt.toString();

    }



    @Override
    public List<Order> getOrdersByNic(String customerNIC) {
        List<Order> ordersByNIC = new ArrayList<>();
        for (Order order : order) {
            if (order.getCustomerNIC().equalsIgnoreCase(customerNIC)) {
                ordersByNIC.add(order);
            }
        }
        return ordersByNIC;
    }

    @Override
    public Order getOrderById(int orderId) {
        for (Order order : order) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null; // Return null if the order with the specified ID is not found
    }


    @Override
    public boolean deleteOrderById(int orderId) {
        Iterator<Order> iterator = order.iterator();
        while (iterator.hasNext()) {
            Order currentOrder = iterator.next();
            if (currentOrder.getOrderId() == orderId) {
                iterator.remove(); // Remove the order using the iterator
                return true; // Return true to indicate successful deletion
            }
        }
        return false; // Return false if the order with the specified ID is not found
    }


}
