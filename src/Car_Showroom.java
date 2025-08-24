import java.sql.*;

public class Car_Showroom {
    public static void main(String[] args) {
        String urlRoot = "jdbc:mysql://localhost:3306/";
        String urlHonda = "jdbc:mysql://localhost:3306/Honda";
        String username = "root";
        String password = "mysql@Ch14";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 1: Connect to MySQL without database and create Honda DB
            try (Connection conn = DriverManager.getConnection(urlRoot, username, password);
                 Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE DATABASE IF NOT EXISTS Honda");
            }

            // Step 2: Connect directly to Honda database
            try (Connection conn = DriverManager.getConnection(urlHonda, username, password);
                 Statement stmt = conn.createStatement()) {

                stmt.executeUpdate(
                        "CREATE TABLE IF NOT EXISTS cars (" +
                                "id INT AUTO_INCREMENT PRIMARY KEY," +
                                "carname VARCHAR(50) NOT NULL," +
                                "modelname VARCHAR(100))");

                stmt.executeUpdate("INSERT INTO cars (carname, modelname) VALUES ('Honda City', 'Turbo++')");

                try (ResultSet rs = stmt.executeQuery("SELECT * FROM cars")) {
                    while (rs.next()) {
                        String carname = rs.getString("carname");
                        String modelname = rs.getString("modelname");
                        System.out.println(carname + " " + modelname);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
