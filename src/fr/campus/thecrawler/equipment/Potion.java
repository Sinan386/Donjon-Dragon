package fr.campus.thecrawler.equipment;

/**
 * A potion that increases defense or heals.
 */
public class Potion extends DefensiveEquipment {

    public Potion(String name, int defenseBuff) {
        super("Potion", name, defenseBuff);
    }

    @Override
    public String toString() {
        return "Potion : " + getName() +
                " (DEF+" + getDefenseBuff() + ")";
    }
}
