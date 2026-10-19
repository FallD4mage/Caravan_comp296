package comp296.caravan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Class to test the database connection.
public class DB_test {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:caravan.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if(conn!=null){
                System.out.println("Connection established.");
            }
            //Will further test here.
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}