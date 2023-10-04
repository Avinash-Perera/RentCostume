package org.avi00.controllers;

import org.avi00.models.Costume;
import org.avi00.models.CostumeInventory;


import java.util.List;
import java.util.Scanner;

public class CostumeInventoryController {
    public CostumeInventory costumeInventory;

            public CostumeInventoryController(){
                this.costumeInventory = CostumeInventory.getInstance();
            }

            public void manageInventory(){
                Scanner scanner = new Scanner(System.in);
                int choice = 0;

                while (choice != -1) {
                    displayOptions();
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    switch (choice) {
                        case 1:
                            addCostume();
                            break;
                        case 2:
                            removeCostume();
                            break;
                        case 3:
                            getCostumeById();
                            break;
                        case 4:
                            getCostumeByType();
                            break;
                        case 5:
                            getCostumesByAgeCategory();
                            break;
                        case 6:
                            getAllCostumes();
                            break;
                        case -1:
                            System.out.println("Exiting Costume Inventory.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            }

    private void displayOptions() {
        System.out.println("Costume Inventory Options:");
        System.out.println("1. Add Costume");
        System.out.println("2. Remove Costume");
        System.out.println("3. Get Costume by ID");
        System.out.println("4. Get Costume by Type");
        System.out.println("5. Get Costumes by Age Category");
        System.out.println("6. Get All Costumes");
        System.out.println("-1. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addCostume() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Costume ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Costume Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Costume Size: ");
        String size = scanner.nextLine();

        System.out.print("Enter Costume Type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Costume Rental Status (Available/Rented): ");
        String rentalStatus = scanner.nextLine();

        System.out.print("Enter Costume Age Category: ");
        String ageCategory = scanner.nextLine();

        System.out.print("Enter Costume Price: ");
        double price = scanner.nextDouble();

        Costume newCostume = new Costume(id, name, size, type, rentalStatus, ageCategory, price);
        costumeInventory.addCostume(newCostume);
        System.out.println("Costume added successfully!");

    }

    private void removeCostume() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Costume ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Costume costumeToRemove = costumeInventory.getCostumeById(id);

        if (costumeToRemove != null) {
            costumeInventory.removeCostume(costumeToRemove);
            System.out.println("Costume removed successfully!");
        } else {
            System.out.println("Costume not found.");
        }
    }

    private void getCostumeById() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Costume ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Costume costume = costumeInventory.getCostumeById(id);

        if (costume != null) {
            System.out.println(costume);
        } else {
            System.out.println("Costume not found.");
        }
    }

    private void getCostumeByType() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Costume Type to search: ");
        String type = scanner.nextLine();

        List<Costume> matchingCostumes = costumeInventory.getCostumeByType(type);

        if (!matchingCostumes.isEmpty()) {
            System.out.println("Matching Costumes:");
            for (Costume costume : matchingCostumes) {
                System.out.println(costume);
            }
        } else {
            System.out.println("No matching costumes found.");
        }
    }

    private void getCostumesByAgeCategory() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Age Category to search: ");
        String ageCategory = scanner.nextLine();

        List<Costume> matchingCostumes = costumeInventory.getCostumesByAgeCategory(ageCategory);

        if (!matchingCostumes.isEmpty()) {
            System.out.println("Matching Costumes:");
            for (Costume costume : matchingCostumes) {
                System.out.println(costume);
            }
        } else {
            System.out.println("No matching costumes found.");
        }

    }

    private void getAllCostumes() {
        List<Costume> costumes = costumeInventory.getAllCostumes();
        for (Costume costume : costumes) {
            System.out.println(costume);
        }

    }
}
