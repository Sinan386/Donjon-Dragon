package fr.campus.thecrawler.equipment;

public class Epee extends Weapon {
    private static final int BONUS = 5;

    public Epee() {
        super("Épée", BONUS);
    }

    @Override
    public String toString() {
        return "Épée (+" + BONUS + " ATK)";
    }
}
