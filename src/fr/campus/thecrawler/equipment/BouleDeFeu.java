package fr.campus.thecrawler.equipment;

public class BouleDeFeu extends Spell {
    private static final int BONUS = 7;

    public BouleDeFeu() {
        super("Boule de Feu", BONUS);
    }

    @Override
    public String toString() {
        return "Boule de Feu (+" + BONUS + " ATK)";
    }
}
