package fr.campus.thecrawler.Enemies;

public abstract class Enemy {
    protected String name;
    protected int attack;
    protected int life;


    public Enemy(String name, int attack, int life) {
        this.name = name;
        this.attack = attack;
        this.life = life;
    }

}
