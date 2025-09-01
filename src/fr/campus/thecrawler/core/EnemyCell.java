package fr.campus.thecrawler.core;
import fr.campus.thecrawler.Enemies.Enemy;

public class EnemyCell extends Cell {
    private final Enemy enemy;

    public EnemyCell(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public String toString() {

        String nom = enemy.getClass().getSimpleName();
        return "Tu rencontres un ennemi : " + nom + ".";
    }
}