package fr.campus.thecrawler.core;

import fr.campus.thecrawler.equipment.DefensiveEquipment;

public class DefensiveCell extends Cell {
    protected final DefensiveEquipment defensiveItem;

    public DefensiveCell(DefensiveEquipment defensiveItem) {
        this.defensiveItem = defensiveItem;
    }

    @Override
    public String toString() {
        return "Tu trouves un bonus défensif : " + defensiveItem + ".";
    }
}
