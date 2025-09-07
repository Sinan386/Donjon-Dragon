package fr.campus.thecrawler.equipment;

public class GrandePotion extends DefensiveEquipment {
    private static final int HEAL = 5;

    public GrandePotion() {
        super("Potion", "Grande potion", HEAL);
    }

    @Override
    public String toString() {
        return "Grande potion (+" + HEAL + " PV)";
    }
}
