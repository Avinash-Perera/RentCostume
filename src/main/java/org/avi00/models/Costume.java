package org.avi00.models;

public class Costume {

    private int id;
    private String name;
    private String size;
    private String type;
    private String rentalStatus;

    private String ageCategory;

    double  price;

    public Costume() {

    }
    public Costume(int id, String name, String size, String type, String rentalStatus, String ageCategory, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.type = type;
        this.rentalStatus = rentalStatus;
        this.ageCategory = ageCategory;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public void rent() {
        this.rentalStatus = "Rented";
    }

    public void return_() {
        this.rentalStatus = "Available";
    }

    public boolean isAvailable() {
        return this.rentalStatus.equals("Available");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Costume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", rentalStatus='" + rentalStatus + '\'' +
                ", ageCategory='" + ageCategory + '\'' +
                ", price=" + price +
                '}';
    }
}
