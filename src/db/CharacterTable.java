package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.ConnectionDb;
import fr.campus.thecrawler.core.Cell;
import fr.campus.thecrawler.characters.Character;


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

    public void createHero (Character hero) {
        final String sql = "INSERT INTO `Character` (`name`, `Type`," +
                " `LifePoints`, `Strenght` ) VALUES (?, ?, ?, ?)";

        try (Connection conn =db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);

             ps.setString(1, hero.getName());
             ps.setString(2, hero.getType());
             ps.setInt(3, hero.getLifePoints());
             ps.setInt(4, hero.getStrenght));

    } catch (SQLException e) {

         e.getMessage());
    }
}



}

        }

    }









    }




