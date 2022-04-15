package com.cydeo.jdbctests.akbar;

import java.sql.*;

public class Navigating_Query_Result {
    public static void main(String[] args) {
        String dbURL = "jdbc:oracle:thin:@54.163.24.214:1521:XE";    //put your own IP from EC2 Instance instead of 3.952.156.295
        String dbUsername = "hr";
        String dbPassword = "hr";

        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            //Statement stmt = connection.createStatement();        //Simple Navigation
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            rs.next();
            System.out.println("Region ID on FIRST row is " + rs.getString(1));
            System.out.println("Region ID on FIRST row is " + rs.getString("REGION_ID"));
            System.out.println("Region NAME on FIRST row is " + rs.getString(2));
            System.out.println("Region NAME on FIRST row is " + rs.getString("REGION_NAME"));
            rs.next();
            System.out.println("Region NAME on SECOND row is " + rs.getString("REGION_NAME"));
            rs.next();
            System.out.println("Region NAME on THIRD row is " + rs.getString("REGION_NAME"));

            System.out.println("DO WE HAVE MORE DATA: "+rs.next());
            System.out.println("Region NAME on FOURTH row is " + rs.getString("REGION_NAME"));

            System.out.println("DO WE HAVE MORE DATA: "+rs.next());
            System.out.println("Region NAME AFTER LAST row is " + rs.getString("REGION_NAME"));

                      //LAST ROW, if you run query again it will throw exception because there are no more rows


        } catch (SQLException e) {
            System.out.println("ERROR HAS OCCURRED " + e.getMessage());
        }
    }
}
