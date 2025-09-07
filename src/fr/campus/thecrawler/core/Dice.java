package fr.campus.thecrawler.core;



import java.util.Random;

/**
 * Dé normal, valeurs entre 1 et 6.
 */
public class Dice implements DiceRoller {
    private final Random random = new Random();

    @Override
    public int roll() {
        return 1 + random.nextInt(6); // entre 1 et 6
    }
}






















/*
public class Dice {
    public int roll() { return 1; } // dé pipé
}


 */
/*
public class Dice {
    private int faces;

    public Dice(int faces) {
        this.faces = faces;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

    public int roll() {
        return (int) (Math.random() * faces) + 1;
    }
}

 */


