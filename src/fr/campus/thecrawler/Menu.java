package fr.campus.thecrawler;

import db.CharacterTable;
import fr.campus.thecrawler.characters.Character;
import fr.campus.thecrawler.characters.Warrior;
import fr.campus.thecrawler.characters.Wizard;
import fr.campus.thecrawler.core.Board;
import fr.campus.thecrawler.core.Dice;
import fr.campus.thecrawler.core.Cell;
import fr.campus.thecrawler.exceptions.PersonnageHorsPlateauException;
import fr.campus.thecrawler.core.DiceRoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private boolean gameClosed = false;

    // --- Affichage ---
    public void showMessage(String msg) { System.out.println(msg); }
    public void displayMessage(String msg) { showMessage(msg); }

    // --- Saisie ---
    private String readLine(String prompt) { System.out.print(prompt); return scanner.nextLine(); }
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("Veuillez entrer un nombre valide."); }
        }
    }
    private String getInput(String prompt) { System.out.print(prompt); return scanner.nextLine(); }

    // --- Création de personnage  ---
    public Character createCharacter() {
        showMessage("Création du personnage :");
        showMessage("1) Warrior  2) Wizard");
        int choice = readInt("Votre choix: ");
        String name = getInput("Nom du personnage: ");
        Character player = (choice == 1) ? new Warrior(name) : new Wizard(name);
        showMessage("Tu as créé : " + player);
        return player;
    }

    // --- Menu principal  ---
    public Character mainCharacterMenu(CharacterTable repo) {
        while (true) {
            displayMessage("1. Créer un nouveau personnage");
            displayMessage("2. Voir les informations du personnage");
            displayMessage("3. Choisir un personnage déjà existant");
            displayMessage("4. Quitter le jeu");
            int choix = readInt("Votre choix : ");

            if (choix == 1) {
                Character c = createCharacter();
                repo.createHero(c);              // enregistre + id via RETURN_GENERATED_KEYS
                return c;
            } else if (choix == 2) {
                afficherInfosDepuisBdd(repo);    // liste simple des noms
            } else if (choix == 3) {
                Character choisi = choisirDepuisBdd(repo); // lit le type en BDD ici
                if (choisi != null) return choisi;
            } else if (choix == 4) {
                displayMessage("Au revoir !");
                gameClosed = true;
                return null;
            } else {
                displayMessage("Choix invalide. Réessaie.");
            }
        }
    }

    // ---  afficher les noms depuis la BDD  ---
    public void afficherInfosDepuisBdd(CharacterTable characterTable) {
        List<String> heroes = new ArrayList<>();
        heroes = characterTable.getHeroes();
        if (heroes.isEmpty()) {
            System.out.println("(Aucun personnage en BDD)");
            return;
        }
        System.out.println("=== Personnages en BDD ===");
        for (String toto : heroes) {
            System.out.println(toto);
        }
    }

    // ---  choisir un héros existant  ---
    private Character choisirDepuisBdd(CharacterTable repo) {
        List<String> heroes = repo.getHeroes();
        if (heroes.isEmpty()) {
            displayMessage("(Aucun héros en base)");
            return null;
        }

        displayMessage("=== Choisis un héros ===");
        for (int i = 0; i < heroes.size(); i++) {
            displayMessage((i + 1) + ") " + heroes.get(i));
        }
        int idx = readInt("Numéro du héros : ");
        if (idx < 1 || idx > heroes.size()) {
            displayMessage("Numéro invalide.");
            return null;
        }

        String name = heroes.get(idx - 1);

        // Récupère le type en BDD sans créer de nouvelle méthode dans CharacterTable
        String type = null;
        try (java.sql.Connection conn = new db.ConnectionDb().getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(
                     "SELECT type FROM `characters` WHERE name=? LIMIT 1")) {
            ps.setString(1, name);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) type = rs.getString("type");
            }
        } catch (java.sql.SQLException e) {
            System.err.println(e.getMessage());
        }

        if (type == null) {
            displayMessage("Type introuvable en BDD pour " + name);
            return null;
        }

        return "Warrior".equalsIgnoreCase(type) ? new Warrior(name) : new Wizard(name);
    }

    // --- Ton tour de jeu ---
    //public void playerTurn(Character character, Board board, Dice dice)
    public void playerTurn(Character character, Board board, DiceRoller dice)
            throws PersonnageHorsPlateauException {

        String cmd = readLine("Appuie sur Entrée pour lancer le dé, ou tape 'q' pour quitter: ").trim().toLowerCase();
        if (cmd.equals("q")) {
            gameClosed = true;
            showMessage("La Partie a été quitté.");
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
        Cell current = board.getCellAt(character.getPosition());
        showMessage(current.toString());
    }

    public boolean isGameClosed() { return gameClosed; }
}
