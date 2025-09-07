package fr.campus.thecrawler.Enemies;

public class Goblin extends Enemy {
    public Goblin() { super("Gobelin", 6, 1); }

    @Override
    public String toString() {
        return "👺 " + super.toString();
    }
}
