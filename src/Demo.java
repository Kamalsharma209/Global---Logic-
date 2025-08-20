import java.sql.*;

public class Demo {

    // Centralized exception handler
    public static void handleException(Exception e) {
        System.out.println("❌ Error: " + e.getMessage());
        e.printStackTrace();
    }

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load SQL Server JDBC Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // 2. Database connection URL
            String url = "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=MyDatabase;" +  // change to your DB name
                    "encrypt=false";              // disable SSL if not configured

            String user = "sa";        // change to your username
            String password = "yourPassword"; // change to your password

            // 3. Establish connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database Connected Successfully!");

            // 4. Create statement
            stmt = con.createStatement();

            // 5. Execute query
            String query = "SELECT id, name FROM Students"; // change table/columns as per DB
            rs = stmt.executeQuery(query);

            // 6. Process results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + " - " + name);
            }

        } catch (Exception e) {
            handleException(e);
        } finally {
            // 7. Close resources safely
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                handleException(e);
            }
        }
    }
}
