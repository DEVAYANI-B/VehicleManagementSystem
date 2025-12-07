package main.java.com.examly.util;

import java.sql.DriverManager;
import java.sql.*;

public class DBConnectionUtil {
    private static final String URL="mysql:jdbc://localhost:3306/VehicleMS";
    private static final String username="root";
    private static final String password="1418";

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,username,password);
        }
        catch(ClassNotFoundException e){
            throw new SQLException("MYSQL JDBC Driver not found");
        }

    }
    public static void closeConnection(Connection con){
        if(con!=null){
            try{
                con.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
}
