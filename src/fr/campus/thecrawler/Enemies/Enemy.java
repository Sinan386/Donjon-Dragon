package fr.campus.thecrawler.Enemies;

public abstract class Enemy {
    protected String name;
    protected int attack;
    protected int life;
    protected int strength;


    public Enemy(String name, int attack, int life) {
        this.name = name;
        this.attack = attack;
        this.life = life;
    }
    public String getName() { return name; }
    public int getLife() { return life; }
    public int getStrength() { return strength; }

    @Override
    public String toString() {
        return name + " (PV=" + life + ", ATK=" + strength + ")";
    }

}

