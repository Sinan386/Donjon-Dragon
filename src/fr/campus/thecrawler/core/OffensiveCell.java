package fr.campus.thecrawler.core;

import fr.campus.thecrawler.equipment.OffensiveEquipment;


public class OffensiveCell extends Cell {
    protected OffensiveEquipment offensiveItem;

    public OffensiveCell(OffensiveEquipment offensiveItem) {
        this.offensiveItem = offensiveItem;
    }

    @Override public String toString() {
        return "Tu trouves un bonus offensif : " + offensiveItem + ".";
    }
}
