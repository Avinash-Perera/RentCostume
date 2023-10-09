package org.avi00.models;

import java.util.Date;
import java.util.List;

public interface IOrderInventory {
    void addOrder(Order newOrder);
    List<Order> getAllOrders(); // New method declaration
    String generateReceipt(Order order);

    List<Order> getOrdersByNic(String customerNIC);
    Order getOrderById(int orderId);

    boolean deleteOrderById(int orderId);

}
