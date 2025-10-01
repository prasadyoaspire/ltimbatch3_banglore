package com.examly.springapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    static final String url = "jdbc:mysql://localhost:3306/appdb";
    static final String username = "root";
    static final String password = "examly";

    public static Connection createDBConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
