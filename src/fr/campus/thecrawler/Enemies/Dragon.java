package fr.campus.thecrawler.Enemies;

public class Dragon extends Enemy {
    public Dragon() {
        super("Dragon", 4, 15);
    }
    @Override
    public String toString() {
        return "🐲 " + super.toString();
    }
}

