package com.cydeo.jdbctests.akbar;

import java.sql.*;

public class Displaying_All_ResultSet_Data {
        public static void main(String[] args) {
            String dbURL = "jdbc:oracle:thin:@54.163.24.214:1521:XE";    //put your own IP from EC2 Instance instead of 3.952.156.295
            String dbUsername = "hr";
            String dbPassword = "hr";

            try {
                Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //"Flexible Navigation" moves forward and backward
                ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                //printing column names
                for (int columnIndex = 1; columnIndex <=columnCount; columnIndex++) {
                    System.out.print(rsmd.getColumnName(columnIndex)+"\t");
                }

                System.out.println();

                while(rs.next()){
                    //printing all data in one row
                    for (int columnIndex = 1; columnIndex <=columnCount ; columnIndex++) {
                        System.out.print(rs.getString(columnIndex)+"\t\t\t");
                    }
                    System.out.println();
                }


            } catch (SQLException e) {
                System.out.println("ERROR OCCURED " + e.getMessage());
            }


        }
    }

