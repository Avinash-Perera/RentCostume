package org.avi00.models;

import java.util.List;

public interface ICostumeInventory {
    void addCostume(Costume costume);
    void removeCostume(Costume costume);

    Costume getCostumeById(int id);

   List< Costume> getCostumeByType(String type);

    List<Costume> getCostumesByAgeCategory(String ageCategory);

    List<Costume> getAllCostumes();
}
