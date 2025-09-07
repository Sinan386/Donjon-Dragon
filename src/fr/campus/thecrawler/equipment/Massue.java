package fr.campus.thecrawler.equipment;


public class Massue extends Weapon {
    private static final int BONUS = 3;

    public Massue() {
        super("Massue", BONUS);
    }

    @Override
    public String toString() {
        return "Massue (+" + BONUS + " ATK)";
    }
}
