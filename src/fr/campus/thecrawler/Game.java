package fr.campus.thecrawler;

import db.CharacterTable;
import fr.campus.thecrawler.characters.Character;
import fr.campus.thecrawler.core.Board;
import fr.campus.thecrawler.core.Dice;

import java.util.ArrayList;
import java.util.List;

/**
 * The Game class is the game logic
 */
public class Game {

    private final Menu menu;
    private final Dice dice;
    private final Board board;

    /**
     * The constructor sets a menu whith a dice with 6 faces and board with 64 cells
     */
    public Game() {
        menu = new Menu();
        dice = new Dice();
        board = new Board();
    }

    /**
     * Start the game
     *        <ul>
     *           <li>Displays the character creation menu</li>
     *           <li>Creates a character through the menu</li>
     *           <li>Displays a welcome message</li>
     *           <li>Runs the main game loop if the game is not closed</li>
     *       </ul>
     */

    public void start() {
        menu.showMessage("Choisis ton personnage : 1) Warrior  2) Wizard");

        Character player = menu.createCharacter();
        menu.showMessage("Bienvenue à toi " + player.getName() + " !");

        CharacterTable characterTable = new CharacterTable();
        List<String> heroes = new ArrayList<>();
        heroes = characterTable.getHeroes();
        for (String toto : heroes) { // dans la boucle for each en Java je dois le définir String et lui donner un nom
            System.out.println(toto);
        }


        if (!menu.isGameClosed()) {
            startGame(player);
        }
    }

    /**
     * The main game loop.
     * the game repeats since the 2 condition is met
     * - The character reaches the last cell of the board
     * - The game is closed by the player
     * @param character the character by the player
     */


    private void startGame(Character character) {
        menu.showMessage("Commençons");

        while (character.getPosition() != board.getNumCells() && !menu.isGameClosed()) {
            try {
                menu.playerTurn(character, board, dice);
            }   catch (fr.campus.thecrawler.exceptions.PersonnageHorsPlateauException e) {
                character.setPosition(board.getNumCells());
                menu.showMessage("⚠ " + e.getMessage());
                menu.showMessage("Tu es placé sur la dernière case : " + board.getNumCells() + ".");
            }

        }

        if (character.getPosition() == board.getNumCells()) {
            menu.showMessage(String.format(
                    "Tu as gagné %s !",
                    character.getName()
            ));
        }
    }
}
