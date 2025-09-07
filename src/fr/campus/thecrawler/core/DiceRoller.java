package fr.campus.thecrawler.core;

/**
 * Interface pour tous les types de dés.
 */
public interface DiceRoller {
    /**
     * Lance le dé et retourne un nombre entier.
     * @return un résultat de dé
     */
    int roll();
}
