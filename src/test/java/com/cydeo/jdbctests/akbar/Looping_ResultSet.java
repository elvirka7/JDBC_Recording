package com.cydeo.jdbctests.akbar;

import java.sql.*;

public class Looping_ResultSet {
    public static void main(String[] args) {

        String dbURL = "jdbc:oracle:thin:@54.163.24.214:1521:XE";    //put your own IP from EC2 Instance instead of 3.952.156.295
        String dbUsername = "hr";
        String dbPassword = "hr";

        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");
            //next method is moving the cursor to the next line and returning true or false according to whether we have next row

            //If next row is NULL (empty),it exits the loop immediately
            while(rs.next()){
                System.out.println(rs.getString(1) + " | "+ rs.getString(2));
            }

            System.out.println("Running loop one more time. Have to move cursor to beforeFirst first. For loop to run cursor should be at the beginning of table.");
            rs.beforeFirst();

            while(rs.next()){
                System.out.println("ROW NUMBER IS "+rs.getRow());
                System.out.println(rs.getString(1) + " | "+ rs.getString(2));
            }

            //To find the row count, move to the last row first and then get the count number of that row
            rs.last();
            System.out.println("ROW COUNT IS "+ rs.getRow());

        } catch (SQLException e) {
            System.out.println("ERROR HAS OCCURRED " + e.getMessage());
        }
    }
}
