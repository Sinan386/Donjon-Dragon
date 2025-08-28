package fr.campus.thecrawler;

import fr.campus.thecrawler.characters.Character;
import fr.campus.thecrawler.core.Board;
import fr.campus.thecrawler.core.Dice;
import fr.campus.thecrawler.characters.Warrior;
import fr.campus.thecrawler.characters.Wizard;
import fr.campus.thecrawler.exceptions.PersonnageHorsPlateauException;


import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private boolean gameClosed = false;

    /* --- Affichage --- */
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    /* --- Saisie --- */
    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }
    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public Character createCharacter() {
        showMessage("Création du personnage :");
        showMessage("1) Warrior  2) Wizard");

        int choice = readInt("Votre choix: ");
        String name = getInput("Nom du personnage: ");
        Character player;

        if (choice == 1) {
            player = new Warrior(name);
        } else {
            player = new Wizard(name);
        }


        showMessage("Tu as créé : " + player);
        return player;
    }



    public void playerTurn(Character character, Board board, Dice dice)
                throws PersonnageHorsPlateauException {

        String cmd = readLine("Appuie sur Entrée pour lancer le dé, ou tape 'q' pour quitter: ").trim().toLowerCase();
        if (cmd.equals("q")) {
            gameClosed = true;
            showMessage("Fermeture de la partie demandée.");
            return;
        }

        int roll = dice.roll();
        showMessage("Tu as fait " + roll + ".");

        int newPos = character.getPosition() + roll;
        int last = board.getNumCells();


        if (newPos > last) {
            throw new PersonnageHorsPlateauException(
                    character.getName() + " Tu as dépassé la dernière case (" + last + ")."
            );
        }

        character.setPosition(newPos);
        showMessage(character.getName() + " avance à la case " + character.getPosition() + "/" + last);
    }


    public boolean isGameClosed() {
        return gameClosed;
    }
}
