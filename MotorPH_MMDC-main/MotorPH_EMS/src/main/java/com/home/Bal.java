/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;

import com.databaseCon.MotorPH_DB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Bal {
        String url = MotorPH_DB.getDatabaseURL();
        String username = MotorPH_DB.getDatabaseUsername();
        String password = MotorPH_DB.getDatabasePassword();
    
    
    public List<Bean> loadData() {
        List<Bean> list = new ArrayList<Bean>();
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "select * from motorphemployees"; 
            PreparedStatement ps = MotorPH_DB.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt("ID");
                String lastName = rs.getString("Last Name");
                String firstName = rs.getString("First Name");
                Date birthday = rs.getDate("Birthday");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String designation = rs.getString("Designation");
                
                Bean bean = new Bean(id,lastName, firstName, birthday, email, password, designation);
                list.add(bean);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
        return list;
    }
    
    
    
    public void insertDataAddEmp(Bean bean){
        try {
         
           String query = "INSERT INTO emp_msdb (`Last Name`, `First Name`, Birthday, Email, Password, Designation) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = MotorPH_DB.getConnection().prepareStatement(query);
       

        ps.setString(1, bean.getLastName());
        ps.setString(2, bean.getFirstName());
        ps.setObject(3, bean.getBirthday());
        ps.setString(4, bean.getEmail());
        ps.setString(5, bean.getPassword());
        ps.setString(6, bean.getDesignation());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Employee Successfully Added");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "" + e);
        }
    }
    
    public boolean checkLogin(String email, String password){
        
       
        boolean b = false;
        
        try {
            Connection connection = MotorPH_DB.getConnection();
            String query = "select Email, Password, Designation from emp_msdb where Email = '"+email+"' AND Password = '"+password+"'";
            Statement st = MotorPH_DB.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.next()) {
                boolean firstLogin = rs.getBoolean("first_login");

                if (firstLogin) {
                    // Prompt user to change password
                    MotorPH_NewPass changePasswordForm;
                    changePasswordForm = new MotorPH_NewPass(username, connection);
                    changePasswordForm.setVisible(true);
                } else {
                    // Direct user to main application or another screen
                    JOptionPane.showMessageDialog(null, "Login successful!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
            
            /*
            
            if (rs.next()){
                b = true;
               String designation = rs.getString("Designation");

            if (designation.equalsIgnoreCase("Admin")) {
                MotorPH_HomeJFrame admin = new MotorPH_HomeJFrame();
                admin.setVisible(true);
            } else if (designation.equalsIgnoreCase("Employee")) {
                MotorPH_AddEmpFrame emp = new MotorPH_AddEmpFrame();
                emp.setVisible(true);
            }
               
            }else {
                JOptionPane.showMessageDialog(null, "Invalid Email and Password try again.");
            }
            */
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
        
        return b;
    }
    
    public Bean returnAllDataToTextField (int id){
        Bean bean = null;
        try {
            String query = "select * from emp_msdb where ID = "+id;
            PreparedStatement ps = MotorPH_DB.getConnection().prepareStatement(query);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {                
                id = rs.getInt("ID");
                String lastName = rs.getString("Last Name");
                String firstName = rs.getString("First Name");
                Date birthday = rs.getDate("Birthday");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String designation = rs.getString("Designation");
                
                bean = new Bean(id, lastName, firstName, birthday, email, password, designation);
             
                }
        } catch (Exception e) {

        }
        return bean;
    }
    
    public void updateBirthday(Bean bean){
        try {
            
            String query = "update emp_msdb set `Last Name` = ?, `First Name` = ?, Birthday = ?, Email = ?, Password = ?, Designation = ? WHERE ID = ?";
            PreparedStatement ps = MotorPH_DB.getConnection().prepareStatement(query);
             ps.setString(1, bean.getLastName());
            ps.setString(2, bean.getFirstName());
            ps.setObject(3,bean.getBirthday());
            ps.setString(4, bean.getEmail());
            ps.setString(5, bean.getPassword());
            ps.setString(6, bean.getDesignation());
            ps.setInt(7, bean.getId());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record has been updated");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
}
