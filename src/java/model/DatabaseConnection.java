/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://139.59.237.126:3306/carpark?characterEncoding=utf-8";
            con = DriverManager.getConnection(dbURL, "root", "123456");
        } catch (ClassNotFoundException e) {
            System.err.println("Error Load Driver :" + e);
        } catch (SQLException e) {
            System.err.println("Error To Connect Database :" + e);
        }
        return con;
    }
}
