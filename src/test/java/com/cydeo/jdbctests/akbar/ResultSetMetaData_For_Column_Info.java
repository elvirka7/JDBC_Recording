package com.cydeo.jdbctests.akbar;

import java.sql.*;

public class ResultSetMetaData_For_Column_Info {
    public static void main(String[] args) {
        String dbURL = "jdbc:oracle:thin:@54.163.24.214:1521:XE";    //put your own IP from EC2 Instance instead of 3.952.156.295
        String dbUsername = "hr";
        String dbPassword = "hr";

        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //"Flexible Navigation" moves forward and backward
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String firstColumnName = rsmd.getColumnName(1);

            System.out.println("columnCount = " + columnCount);
            System.out.println("columnName = " + firstColumnName);

            System.out.println();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                System.out.println("Column "+columnIndex+" Name = " + rsmd.getColumnName(columnIndex));

            }

        } catch (SQLException e) {
            System.out.println("ERROR OCCURED " + e.getMessage());
        }


    }
}
