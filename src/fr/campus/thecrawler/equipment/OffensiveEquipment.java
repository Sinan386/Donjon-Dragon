package fr.campus.thecrawler.equipment;


public class OffensiveEquipment {
    private final String type;
    private final String name;
    private final int attackBuff;


    public OffensiveEquipment (String type, String name, int attackBuff){
        this.type = type;
        this.name = name;
        this.attackBuff = attackBuff;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public int getAttackBuff(){
        return this.attackBuff;
    }

    @Override
    public String toString() {
        return "Cet équipement de type " + type + " nommé " + name + " booste l'attaque de " + attackBuff + " points.";
    }


    // Armes du Guerrier
    public static OffensiveEquipment massue() {
        return new OffensiveEquipment("Weapon", "Massue", 3);
    }

    public static OffensiveEquipment epee() {
        return new OffensiveEquipment("Weapon", "Epée", 5);
    }

    // Sorts du Magicien
    public static OffensiveEquipment eclair() {
        return new OffensiveEquipment("Spell", "Éclair", 2);
    }

    public static OffensiveEquipment bouleDeFeu() {
        return new OffensiveEquipment("Spell", "Boule de feu", 7);
    }

}
