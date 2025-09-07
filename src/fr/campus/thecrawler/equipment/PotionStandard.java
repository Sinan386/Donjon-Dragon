package fr.campus.thecrawler.equipment;

public class PotionStandard extends DefensiveEquipment {
    private static final int HEAL = 2;

    public PotionStandard() {
        super("Potion", "Potion standard", HEAL);
    }

    @Override
    public String toString() {
        return "Potion standard (+" + HEAL + " PV)";
    }
}
