/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empServices;

import com.mysql.cj.protocol.Resultset;
import javax.swing.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import helpers.QueryBuilder;
import utils.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dharshani
 */

public class supplierServices {
    
   
    
    DbConnection Dbconn = new DbConnection ();
    private Connection connection =Dbconn.getConnection();
    private Object txtsuid;
    
     public  void insertSupplier( String su_name, String su_phone , String su_email , String su_company) {
        try {
            String query = "INSERT INTO supplier ( su_name, su_phone, su_email, su_company) VALUES ( ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //
            preparedStatement.setString(1, su_name);
            preparedStatement.setString(2, su_phone);
            preparedStatement.setString(3, su_email);
            preparedStatement.setString(4, su_company);
            

            preparedStatement.executeUpdate();
            System.out.println("Supplier inserted successfully.");
            JFrame frame = new JFrame("SUCCESS");
             JOptionPane.showMessageDialog(frame, "Data Insert Success!");
        } catch (SQLException e) {
             JFrame frame = new JFrame("ERROR");
             JOptionPane.showMessageDialog(frame, "Error inserting Suppliers: " + e);
            System.err.println("Error inserting Suppliers: " + e);
        }
    }
    
    /**
     *
     */


    public  void deleteSupplier(int sup_id) {
    try {
     String query = "DELETE FROM supplier WHERE Sup_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sup_id);
            preparedStatement.executeUpdate();
            System.out.println("Supplier deleted successfully.");

    } catch (SQLException e) {
     System.out.println("Error deleting Supplier: " + e);
    }
    }


public void updateSupplier(String su_name, String su_phone, String su_email, String su_company, int sup_id) {
try {
        // Ensure that you have a valid UPDATE query with correct column names
        String query = "UPDATE supplier SET su_name=?, su_phone=?, su_email=?, su_copmany=? WHERE Sup_id=?";
        
        // Use PreparedStatement to prevent SQL injection
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, su_name);
        preparedStatement.setString(2, su_phone);
        preparedStatement.setString(3, su_email);
        preparedStatement.setString(4, su_company);
        preparedStatement.setInt(5, sup_id);

        // Execute the update query
        preparedStatement.executeUpdate();

        // Commit the changes to the database
        connection.commit();

        System.out.println("Supplier updated successfully.");
    } catch (SQLException e) {
        // Handle any SQL exceptions
        System.err.println("Error updating Supplier: " + e);
        try {
            // Rollback changes in case of an exception
            connection.rollback();
        } catch (SQLException ex) {
            System.err.println("Error rolling back changes: " + ex);
        }
    }
}

public SupplierInfo searchSupplier(int sup_id) {
       try {
        String query = "SELECT * FROM supplier WHERE Sup_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, sup_id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Supplier found successfully.");

            // Additional code to display the retrieved data if needed
            String suName = resultSet.getString("su_name");
            String suPhone = resultSet.getString("su_phone");
            String suEmail = resultSet.getString("su_email");
            String suCompany = resultSet.getString("su_company");

            // Create a SupplierInfo object with the retrieved data
            SupplierInfo supplierInfo = new SupplierInfo();
            supplierInfo.setName(suName);
            supplierInfo.setPhone(suPhone);
            supplierInfo.setEmail(suEmail);
            supplierInfo.setCompany(suCompany);

            return supplierInfo;
        } else {
            System.out.println("Supplier not found.");
            return null;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.err.println("Error executing the query: " + ex.getMessage());
        return null;
    } catch (NumberFormatException ex) {
        ex.printStackTrace();
        System.err.println("Error parsing the supplier ID: " + ex.getMessage());
        return null;
    }
}

    public void updateSupplier(int sup_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}