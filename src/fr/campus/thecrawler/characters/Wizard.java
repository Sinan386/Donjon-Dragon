package fr.campus.thecrawler.characters;

/** Wizard with higher base life and lower base attack. */
public class Wizard extends Character {

    public Wizard(String name) {
        super("Wizard", name, 6, 8, "Spell"); // base stats for a Wizard
    }

    @Override
    public String getType() { return "Wizard"; }

    @Override
    public String toString() {
        return "Personnage : " + getName() +
                ", Type : " + getType() +
                ", Niveau de vie : " + getLife() +
                ", Force : " + getAttack();
    }
}
