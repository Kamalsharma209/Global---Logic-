import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Library_Management {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "mysql@Ch14";
        String driverclass = "com.mysql.cj.jdbc.Driver";

        Connection connection = null ;
        Statement statement = null ;
        ResultSet rSet = null ;

        try {
            Class.forName(driverclass);
            connection = DriverManager.getConnection(url , username , password) ;
            statement = connection.createStatement() ;
            statement.execute("create database University ;");
            statement.execute("use University ;") ;
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY,firstname VARCHAR(50) NOT NULL,lastname VARCHAR(100))") ;
            statement.executeUpdate("insert into students(firstname , lastname) values ('john' , 'cena')") ;

            rSet = statement.executeQuery("select * from students") ;
            String firstname ;
            String lastname ;
            while(rSet.next()) {
                firstname = rSet.getString("firstname") ;
                lastname = rSet.getString("lastname");
                System.out.println(firstname +" " + lastname) ;
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception : " + e);
        }
        connection.close();
        statement.close();
        rSet.close();
    }

}