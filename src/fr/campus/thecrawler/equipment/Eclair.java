package fr.campus.thecrawler.equipment;

public class Eclair extends Spell {
    private static final int BONUS = 4;

    public Eclair() {
        super("Éclair", BONUS);
    }

    @Override
    public String toString() {
        return "Éclair (+" + BONUS + " ATK)";
    }
}
