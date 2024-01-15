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
    
     public void displayEmployeeData() {
        try {
            String query = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Print column headers
            System.out.printf("%-5s%-20s%-30s%-15s%-15s%-15s%-10s%n",
                    "ID", "Name", "Email", "Contact", "Birthday", "Job", "Gender");

            // Print employee data
            while (resultSet.next()) {
                System.out.printf("%-5s%-20s%-30s%-15s%-15s%-15s%-10s%n",
                        resultSet.getString("Emp_id"),
                        resultSet.getString("Emp_name"),
                        resultSet.getString("Email"),
                        resultSet.getString("Contact_num"),
                        resultSet.getString("BDay"),
                        resultSet.getString("Job"),
                        resultSet.getString("Gender"));
            }

            // Close resources
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error displaying employee data: " + e);
            JFrame frame = new JFrame("Error");
            JOptionPane.showMessageDialog(frame, "Error displaying employee data!");
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
