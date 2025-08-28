package fr.campus.thecrawler.characters;

public abstract class Character {
    private String name;
    private int attack;
    private int life;
    private int position;
    private final String offensiveEquipmentType;

    //For the beginning :
    private final String type;

    //For the next steps :
    //private Equipment.OffensiveEquipment;


    protected Character(String type, String name, int life, int attack, String offensiveEquipmentType){
        this.type = type;
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.offensiveEquipmentType = offensiveEquipmentType;
        this.position = 1;
    }

    public String getType() {
        return type;
    }

    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }

    public int getLife(){
        return life;
    }
    public void setLife(int newLife){
        life = newLife;
    }

    public int getAttack(){
        return attack;
    }
    public void setAttack(int newAttack){
        attack = newAttack;
    }

    public int getPosition(){
        return position;
    }
    public void setPosition(int newPosition){
        position = newPosition;
    }

    public String getOffensiveEquipmentType(){
        return offensiveEquipmentType;
    }

    @Override
    public String toString() {
        return String.format("""
        Le personnage %s est un %s.
        Il possède %d points de vie.
        Il peut s'équiper de %s.
        Sur le plateau, il se trouve à la case %d.
        """, name, type, life, offensiveEquipmentType, position);
    }

}
