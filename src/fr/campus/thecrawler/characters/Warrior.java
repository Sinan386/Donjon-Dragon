package fr.campus.thecrawler.characters;

/** Warrior with higher base life and lower base attack. */
public class Warrior extends Character {

    public Warrior(String name) {
        super("Warrior", name, 10, 5, "Weapon"); // base stats for a warrior
    }

    @Override
    public String getType() { return "Warrior"; }

    @Override
    public String toString() {
        return "Personnage : " + getName() +
                ", Type : " + getType() +
                ", Niveau de vie : " + getLife() +
                ", Force : " + getAttack();
    }
}
