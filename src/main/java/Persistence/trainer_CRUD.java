/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Helper.Trainer;

public class trainer_CRUD {
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

    public static boolean create(Trainer trainer) {
        boolean result = false;
        try {
            Connection con = getCon();

            String sql = "INSERT INTO Trainer (TrainerId, TrainerName, Specialty, Gender, AvailabilityDate, PhoneNumber) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, trainer.getTrainerId());
            ps.setString(2, trainer.getTrainerName());
            ps.setString(3, trainer.getSpecialty());
            ps.setString(4, trainer.getGender());
            //ps.setObject(5, trainer.getAvailabilityDate());
            ps.setInt(6, trainer.getPhoneNumber());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = true;
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public static Trainer read(int trainerId) {
        Trainer trainer = null;
        try {
            Connection con = getCon();
            String sql = "SELECT * FROM Trainer WHERE TrainerId = \"" + trainerId + "\" ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, trainerId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("TrainerName");
                String specialty = rs.getString("Specialty");
                String gender = rs.getString("Gender");
                int phoneNumber = rs.getInt("PhoneNumber");

                trainer = new Trainer(trainerId, name, specialty, gender, phoneNumber);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return trainer;
    }
    
    public static ArrayList<Trainer> getTrainers(){
        ArrayList<Trainer> trainers = new ArrayList<>();
        
        try {
            Connection con = getCon();
            String q = "SELECT * FROM Trainer";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int trainerId = Integer.valueOf(rs.getString("TrainerId"));
                String trainerName = rs.getString("TrainerName");
                String specialty = rs.getString("Specialty");
                String gender = rs.getString("Gender");
                int phoneNumber = Integer.valueOf(rs.getString("PhoneNumber"));

                trainers.add(new Trainer(trainerId, trainerName, specialty, gender, phoneNumber));
            }
        }catch(Exception e){System.out.println(e);} 
        
        return trainers;
    }
    
    
    public static void setAvailability(boolean isA, int trainerId){
        Trainer t = read(trainerId);
        if(t == null) return;
        try {
            Connection con = getCon();
            //String q = "INSERT INTO  " + ;
            
            Statement stmt = con.createStatement();
            stmt.execute(q);
            con.close();
            return;
        }catch(Exception e){System.out.println(e);}
    }
}
