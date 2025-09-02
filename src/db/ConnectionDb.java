package db;
import java.sql.*;

public class ConnectionDb {
    private String url;
    private String username;
    private String password;

    public ConnectionDb() {
        this.url = "jdbc:mysql://localhost:3306/Donjon";
        this.username= "root";
        this.password= "fakepassword";
    }

    public void selectAll() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
    }

}
/*
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Donjon", "root", "fakepassword");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `Character`");
                while (rs.next()) {
                    System.out.println(rs.getString("name"));

                }
        } catch (SQLException e) {
            e.printStackTrace();
        };
    }

}
 */

