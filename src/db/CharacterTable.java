package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.ConnectionDb;
import fr.campus.thecrawler.core.Cell;


public class CharacterTable {
    private ConnectionDb db;

    public CharacterTable() {
        this.db = new ConnectionDb();
    }
    public List<String> getHeroes (){
        final String sql = "SELECT * FROM `Character`";
        List<String> heroes = new ArrayList<>();

        try (Connection conn =db.getConnection();
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







    }




