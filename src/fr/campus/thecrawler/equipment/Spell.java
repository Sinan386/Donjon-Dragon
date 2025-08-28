package fr.campus.thecrawler.equipment;

/**
 * A spell used by Wizards.
 */
public class Spell extends OffensiveEquipment {

    /**
     * Constructor for a Spell.
     * @param name the spell name
     * @param attackBuff the attack bonus provided by the spell
     */
    public Spell(String name, int attackBuff) {
        super("Spell", name, attackBuff);
    }

    @Override
    public String toString() {
        return "Spell: " + getName() + " (+" + getAttackBuff() + " ATK)";
    }
}
