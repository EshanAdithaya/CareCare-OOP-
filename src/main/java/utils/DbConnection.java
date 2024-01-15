/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vishva Kulathunga
 */
public class DbConnection {

    public static String DB_CON_URL = "jdbc:mysql://localhost:3306/carcare?user=root&password=";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DbConnection() {
        try {

            this.setConnection(DriverManager.getConnection(DB_CON_URL));
            System.out.println("Connected With the database successfully"); //Message after successful connection

        } catch (SQLException e) {
            
            System.out.println("Error while connecting to the database  " + e); //Message if something goes wrong while conneting to the database
        
        }
    }

}
