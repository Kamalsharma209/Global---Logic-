import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import static java.lang.Class.forName;

public class Library_Management {
    public static void main(String[] args) throws Exception {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String Url = "jdbc:mysql://localhost:3306/University";
        String Username = "root";
        String Password = "Kamal@9090";
        try {
            class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(Url,Username,Password);
            stmt = con.createStatement();
            String  query = "create database Library_management;";
            String query2 = "use Library_management;";
            String query3 = "create table Books(id INT AUTO_INCREMENT PRIMARY KEY,firstname VARCHAR(50) NOT NULL,lastname VARCHAR(100))";
            String query4 = "insert into Books(firstname , lastname) values('pogo','hello')";
            rs = stmt.executeQuery(query);
        } catch{



        }

    }
}
