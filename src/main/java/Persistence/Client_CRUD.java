/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

/**
 *
 * @author student
 */


import Helper.UserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Client_CRUD {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/GYM_MANAGEMENT?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "student";
    
    private static Connection getCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection established");
        }
        catch(Exception e){System.out.println(e);}
        return con;
    }

    

    public static UserInfo read(String username, String password) throws SQLException {
        UserInfo userInfo = null;

        try {
            //connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Connection con = getCon();
            String q = "SELECT * FROM Client WHERE username = \"" + username + "\" ";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String clientName = rs.getString("ClientName");
                String phone = rs.getString("PhoneNumber");
                String user = rs.getString("UserName");
                String storedPassword = rs.getString("Password");

                if (storedPassword.equals(password)) {
                    userInfo = new UserInfo(clientName, phone, user, password);
                }
            }
        }catch(Exception e){System.out.println(e);} 

        return userInfo;
    }
    
    public static ArrayList<UserInfo> getClients(String username, String password) throws SQLException {
        ArrayList<UserInfo> users = new ArrayList<>();
        
        try {
            Connection con = getCon();
            String q = "SELECT * FROM Client ";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String clientName = rs.getString("ClientName");
                String phone = rs.getString("PhoneNumber");
                String user = rs.getString("UserName");
                String storedPassword = rs.getString("Password");

                if (storedPassword.equals(password)) {
                    users.add(new UserInfo(clientName, phone, user, password));
                }
            }
        }catch(Exception e){System.out.println(e);} 

        return users;
    }
}
