package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.ConnectionDb;
import fr.campus.thecrawler.Menu;
import fr.campus.thecrawler.core.Cell;
import fr.campus.thecrawler.characters.Character;
import fr.campus.thecrawler.characters.Character;


public class CharacterTable {
    private ConnectionDb db;

    public CharacterTable() {
        this.db = new ConnectionDb();
    }

    public List<String> getHeroes() {
        final String sql = "SELECT * FROM `characters`";
        List<String> heroes = new ArrayList<>();

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                heroes.add(rs.getString("name"));
            }

        } catch (SQLException e) {

            e.getMessage();
        }
        return heroes;
    }

    public void createHero(Character hero) {
        Menu menu = new Menu();


        try {
            Connection conn = this.db.getConnection();
            String sql = "INSERT INTO `characters`(name, type, life_points, strength, offensive_equipment, defensive_equipment) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // génère un ID
            ps.setString(1, hero.getName());
            ps.setString(2, hero.getType());
            ps.setInt(3, hero.getLife());
            ps.setInt(4, hero.getAttack());
            ps.setString(5, "none");
            ps.setString(6, "none");

            ps.executeUpdate();


            // Récupération de la clé générée (id) et réinjection dans l'objet
            ResultSet keys = ps.getGeneratedKeys();

            while (keys.next()) {
                int id = keys.getInt(1); //
                hero.setId(id);

            }


        } catch (SQLException e) {
            e.getMessage();
        }
    }

        public void editHero(Character hero) {
            try {
                Connection conn = this.db.getConnection();
                String sql = "UPDATE `characters` " +
                        "SET name = ?, type = ?, life_points = ?, strength = ?, " +
                        "    offensive_equipment = ?, defensive_equipment = ? " +
                        "WHERE id = ?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, hero.getName());
                ps.setString(2, hero.getType());
                ps.setInt(3, hero.getLife());
                ps.setInt(4, hero.getAttack());
                ps.setString(5, "none");
                ps.setString(6, "none");
                ps.setInt(7, hero.getId()); // ← réutilise l'id avec RETURN_GENERATED_KEYS

                ps.executeUpdate();

            } catch (SQLException e) {
                e.getMessage();
            }
        }

    }
















