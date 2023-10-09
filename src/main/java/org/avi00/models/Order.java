package org.avi00.models;

import java.util.Date;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private String customerFullName;
    private String customerAddress;
    private String customerNIC;
    private int numberOfRentalDays;
    private Costume rentedCostume;
    private Date rentalStartDate;
    private double totalAmount;

    public Order(String customerFullName, String customerAddress, String customerNIC,
                 int numberOfRentalDays, Costume rentedCostume) {
        this.orderId = nextOrderId++;
        this.customerFullName = customerFullName;
        this.customerAddress = customerAddress;
        this.customerNIC = customerNIC;
        this.numberOfRentalDays = numberOfRentalDays;
        this.rentedCostume = rentedCostume;
        this.rentalStartDate = new Date(); // Set the rental start date to the current date
        this.totalAmount = calculateTotalAmount(new Date());
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public int getNumberOfRentalDays() {
        return numberOfRentalDays;
    }

    public void setNumberOfRentalDays(int numberOfRentalDays) {
        this.numberOfRentalDays = numberOfRentalDays;
    }

    public Costume getRentedCostume() {
        return rentedCostume;
    }

    public void setRentedCostume(Costume rentedCostume) {
        this.rentedCostume = rentedCostume;
    }

    public Date getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double calculateTotalAmount(Date date) {
        double costumePrice = rentedCostume.getPrice();
        return costumePrice * numberOfRentalDays;
    }

    // Add a method to display order details (similar to your existing displayOrderDetails)
    public void displayOrderDetails() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Order Details:");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Customer Name: " + customerFullName);
        System.out.println("Customer Address: " + customerAddress);
        System.out.println("Customer NIC: " + customerNIC);
        System.out.println("Number of Rental Days: " + numberOfRentalDays);
        System.out.println("Rented Costume: " + rentedCostume.getName());
        System.out.println("Rental Start Date: " + rentalStartDate);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerFullName='" + customerFullName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerNIC='" + customerNIC + '\'' +
                ", numberOfRentalDays=" + numberOfRentalDays +
                ", rentedCostume=" + rentedCostume +
                ", rentalStartDate=" + rentalStartDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
