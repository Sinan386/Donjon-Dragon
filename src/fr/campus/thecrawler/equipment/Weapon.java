package fr.campus.thecrawler.equipment;

/**
 * A melee weapon used by Warriors.
 */
public class Weapon extends OffensiveEquipment {

    public Weapon(String name, int attackBuff) {
        super("Weapon", name, attackBuff);
    }

    @Override
    public String toString() {
        return "Weapon: " + getName() + " (+" + getAttackBuff() + " ATK)";
    }
}
