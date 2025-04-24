package com.carrental;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentaldb", "root", "");
    }
}