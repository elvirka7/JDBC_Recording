package com.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class P01_JDBCIntro {

        String dbURL = "jdbc:oracle:thin:@54.163.24.214:1521:XE";    //put your own IP from EC2 Instance instead of 3.952.156.295
        String dbUsername = "hr";
        String dbPassword = "hr";

        @Test
        public void task1() throws SQLException {
            //DriverManager class getConnection method is used for making connection with DB
            Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);

            //Create statement from Connection to run queries
            Statement statement = connection.createStatement();

            // we will execute query calling methods with statement object
            ResultSet rs = statement.executeQuery("select * from DEPARTMENTS where MANAGER_ID is not null");





            //close all conn
            rs.close();
            statement.close();
            connection.close();

        }

}
