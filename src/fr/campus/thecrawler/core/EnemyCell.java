package fr.campus.thecrawler.core;

public class EnemyCell extends Cell {
    protected Enemy enemy;

    public EnemyCell(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override public String toString() {
        return "Tu rencontres un ennemi : " + enemy + ".";
    }
}