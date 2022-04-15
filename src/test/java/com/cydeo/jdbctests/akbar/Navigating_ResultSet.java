package com.cydeo.jdbctests.akbar;

import java.sql.*;

public class Navigating_ResultSet {
    public static void main(String[] args) {
        String dbURL = "jdbc:oracle:thin:@54.163.24.214:1521:XE";    //put your own IP from EC2 Instance instead of 3.952.156.295
        String dbUsername = "hr";
        String dbPassword = "hr";

        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //"Flexible Navigation" moves forward and backward

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            rs.first();
            System.out.println(rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME"));

            rs.last();
            System.out.println(rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME"));

            rs.previous();
            System.out.println(rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME"));

            rs.absolute(2);
            System.out.println(rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME"));

            rs.beforeFirst(); //"Exception: ResultSet.next was not called" if I try to get row data; go to actual row to get data
            rs.next();
            System.out.println(rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME"));

            rs.afterLast();     //"Exception: Result set after last row" if I try to get row datak go to actual row to get data
            rs.previous();
            System.out.println(rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME"));

        } catch (SQLException e) {
            System.out.println("ERROR HAS OCCURRED " + e.getMessage());
        }
    }
}

