package fr.campus.thecrawler.equipment;

/**
 * A shield that increases defense.
 */
public class Shield extends DefensiveEquipment {

    public Shield(String name, int defenseBuff) {
        super("Shield", name, defenseBuff);
    }

    @Override
    public String toString() {
        return "Bouclier : " + getName() +
                " (DEF+" + getDefenseBuff() + ")";
    }
}
