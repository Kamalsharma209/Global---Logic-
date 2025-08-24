import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcStup {
    public static void main(String[] args) {
        String url =  "jdbc:mysql://localhost:3306/setup";
        String username = "root";
        String password = "Kamal@9090";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
            System.out.println("Connected to the database");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
