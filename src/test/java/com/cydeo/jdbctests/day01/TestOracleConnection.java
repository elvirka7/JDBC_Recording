package com.cydeo.jdbctests.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * host : 54.163.24.214
 * port : 1521
 * SID: XE
 * user : hr
 * password : hr
 *
 * jdbc url AKA connection String
 * syntax:
 * jdbc : vendorName : driverType @YourHost:PORT:SID
 *
 * jdbc:oracle:thin:@54.163.24.214:1521:XE
 */

public class TestOracleConnection {
    public static void main(String[] args) {
        String dbURL ="jdbc:oracle:thin:@54.163.24.214:1521:XE"; 	//put your own IP from EC2 Instance instead of 3.952.156.295
        String dbUsername ="hr";
        String dbPassword ="hr";

        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            System.out.println("CONNECTION WAS SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("Connection has failed " + e.getMessage());
        }
    }
}
