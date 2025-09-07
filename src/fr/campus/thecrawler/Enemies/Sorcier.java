package fr.campus.thecrawler.Enemies;

public class Sorcier extends Enemy {
    public Sorcier() { super("Sorcier", 9, 2); }

    @Override
    public String toString() {
        return "🧙 " + super.toString();
    }
}
