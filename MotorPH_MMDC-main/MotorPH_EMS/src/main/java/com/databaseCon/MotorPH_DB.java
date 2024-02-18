package com.databaseCon;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MotorPH_DB {
    private static Connection con = null;
    private static final String URL = "jdbc:mysql://localhost:3306/emp_msdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mYSQLDASH/4*";

    public static Connection getConnection() {
        if (con == null) {
            loadConnection();
        }
        return con;
    }

    private static void loadConnection() {
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (con != null) {
                JOptionPane.showMessageDialog(null, "Database is Successfully Connected");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Database" + e);
        }
    }

    public static String getDatabaseURL() {
        return URL;
    }

    public static String getDatabaseUsername() {
        return USERNAME;
    }

    public static String getDatabasePassword() {
        return PASSWORD;
    }

    public static class loadConnection {

        public loadConnection() {
        }
    }
}

