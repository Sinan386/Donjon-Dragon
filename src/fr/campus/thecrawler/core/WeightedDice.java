package fr.campus.thecrawler.core;

/**
 * Dé pipé, retourne toujours 1.
 */
public class WeightedDice implements DiceRoller {
    @Override
    public int roll() {
        return 1;
    }
}
