package org.avi00.models;

import java.util.ArrayList;
import java.util.List;

public class CostumeInventory implements ICostumeInventory {
    private List<Costume> costumes;
    private static CostumeInventory instance; // Singleton instance

    // Private constructor to prevent direct instantiation
    private CostumeInventory() {
        this.costumes = new ArrayList<>();
    }

    // Public method to get the singleton instance
    public static CostumeInventory getInstance() {
        if (instance == null) {
            instance = new CostumeInventory();
        }
        return instance;
    }

    @Override
    public void addCostume(Costume costume) {
        costumes.add(costume);
    }

    @Override
    public void removeCostume(Costume costume) {
        costumes.remove(costume);
    }

    @Override
    public Costume getCostumeById(int id) {
        for (Costume costume : costumes) {
            if (costume.getId() == id) {
                return costume;
            }
        }
        return null; // Costume not found
    }

    @Override
    public List<Costume> getCostumeByType(String type) {
        List<Costume> matchingCostumes = new ArrayList<>();
        for (Costume costume : costumes) {
            if (costume.getType().equals(type)) {
                matchingCostumes.add(costume);
            }
        }
        return matchingCostumes;
    }

    @Override
    public List<Costume> getCostumesByAgeCategory(String ageCategory) {
        List<Costume> matchingCostumes = new ArrayList<>();
        for (Costume costume : costumes) {
            if (costume.getAgeCategory().equalsIgnoreCase(ageCategory)) {
                matchingCostumes.add(costume);
            }
        }
        return matchingCostumes;
    }

    @Override
    public List<Costume> getAllCostumes() {
        return costumes;
    }
}
