

import java.sql.*;


public class Demo {
    public static void main(String[] args) throws SQLException {

        Connection con = null ;
        ResultSet rs = null;
        Statement stmt = null ;
        String url = "jdbc:mysql://localhost:3306/University";
        String username = "root";
        String password = "Kamal@9090";
        String sql = "select * from students" ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url ,username,password ) ;
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql) ;
            //System.out.println(rs.first()) ;
            String firstname ;
            int count = 0 ;
            while(rs.next() && count < 10) {
                firstname = rs.getString("firstName");
                System.out.println(firstname) ;
                count++ ;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception : "+e.getMessage()) ;
        }
        rs.close();
        stmt.close();
        con.close();
    }
}