package org.avi00.models;

import java.util.Date;

public class Order {
    private String customerFullName;
    private String customerAddress;
    private String customerNIC;
    private int numberOfRentalDays;
    private Costume rentedCostume;
    private Date rentalStartDate;
    private double totalAmount;

    public Order(String customerFullName, String customerAddress,
                 String customerNIC, int numberOfRentalDays,
                 Costume rentedCostume, Date rentalStartDate,
                 double totalAmount) {
        this.customerFullName = customerFullName;
        this.customerAddress = customerAddress;
        this.customerNIC = customerNIC;
        this.numberOfRentalDays = numberOfRentalDays;
        this.rentedCostume = rentedCostume;
        this.rentalStartDate = rentalStartDate;
        this.totalAmount = totalAmount;
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

    public double calculateTotalAmount(){
        double costumePrice = rentedCostume.getPrice();
        return costumePrice * numberOfRentalDays;
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("Customer Name: " + customerFullName);
        System.out.println("Customer Address: " + customerAddress);
        System.out.println("Customer NIC: " + customerNIC);
        System.out.println("Number of Rental Days: " + numberOfRentalDays);
        System.out.println("Rented Costume: " + rentedCostume.getName());
        System.out.println("Rental Start Date: " + rentalStartDate);
        System.out.println("Total Amount: " + totalAmount);
    }

    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Receipt\n");
        receipt.append("Customer Name: ").append(customerFullName).append("\n");
        receipt.append("Customer Address: ").append(customerAddress).append("\n");
        receipt.append("Customer NIC: ").append(customerNIC).append("\n");
        receipt.append("Number of Rental Days: ").append(numberOfRentalDays).append("\n");
        receipt.append("Rented Costume: ").append(rentedCostume.getName()).append("\n");
        receipt.append("Rental Start Date: ").append(rentalStartDate).append("\n");
        receipt.append("Total Amount: ").append(totalAmount).append("\n");
        return receipt.toString();
    }
}
