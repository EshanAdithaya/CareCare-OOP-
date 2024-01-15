/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empServices;

import javax.swing.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import helpers.QueryBuilder;
import utils.*;
import java.sql.Connection;

/**
 *
 * @author eshan
 */

public class employeeService {
   
    DbConnection Dbconn = new DbConnection ();
    private Connection connection =Dbconn.getConnection();
    
    public  void insertEmployee( String empName, String email, String contactNum, String bday, String job, String gender) {
        try {
            String query = "INSERT INTO employee ( Emp_name, Email, Contact_num, BDay, Job, Gender) VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //
            preparedStatement.setString(1, empName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, contactNum);
            preparedStatement.setString(4, bday);
            preparedStatement.setString(5, job);
            preparedStatement.setString(6, gender);

            preparedStatement.executeUpdate();
            System.out.println("Employee inserted successfully.");
            JFrame frame = new JFrame("SUCCESS");
             JOptionPane.showMessageDialog(frame, "Data Insert Success!");
        } catch (SQLException e) {
             JFrame frame = new JFrame("ERROR");
             JOptionPane.showMessageDialog(frame, "Error inserting employee: " + e);
            System.err.println("Error inserting employee: " + e);
        }
    }

    public void updateEmployee(String empId, String empName, String email, String contactNum, String bday, String job, String gender) {
        try {
             
            String query = "UPDATE employee SET Emp_name=?, Email=?, Contact_num=?, BDay=?, Job=?, Gender=? WHERE Emp_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, empName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, contactNum);
            preparedStatement.setString(4, bday);
            preparedStatement.setString(5, job);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, empId);

            preparedStatement.executeUpdate();
            System.out.println("Employee updated successfully.");
            JFrame frame = new JFrame("SUCCESS");
             JOptionPane.showMessageDialog(frame, "Data Updated Successfully!");
        } catch (SQLException e) {
            System.err.println("Error updating employee: " + e);
            JFrame frame = new JFrame("SUCCESS");
             JOptionPane.showMessageDialog(frame, "Data Updated Error!");
        }
    }

    public  void deleteEmployee(String empId) {
    try {
     String query = "DELETE FROM employee WHERE Emp_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, empId);
            preparedStatement.executeUpdate();
            System.out.println("Employee deleted successfully.");
            
            JFrame frame = new JFrame("SUCCESS");
             JOptionPane.showMessageDialog(frame, "Data Deleted Successfully!");

    } catch (SQLException e) {
     System.out.println("Error deleting employee: " + e);
     JFrame frame = new JFrame("SUCCESS");
             JOptionPane.showMessageDialog(frame, "Data Deleteed Error!");
    }
    }
//        try {
//            String query = "DELETE FROM employee WHERE Emp_id=?";
//            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
//            preparedStatement.setInt(1, empId);

//            preparedStatement.executeUpdate();
//            System.out.println("Employee deleted successfully.");
//        } catch (SQLException e) {
//            System.err.println("Error deleting employee: " + e);
//         }
//    }
 
}
