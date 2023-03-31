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
import Helper.Equipment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipment_CRUD {
    private static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GYM_MANAGEMENT?serverTimezone=UTC", "root", "password");
            System.out.println("Connection established.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static Equipment read(int equipmentId) {
        Equipment equipment = null;
        try {
            Connection con = getCon();

            String sql = "SELECT * FROM Equipment WHERE EquipmentId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, equipmentId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("EquipmentName");
                String typeOfWorkout = rs.getString("TypeOfWorkout");
                LocalDate availabilityDate = rs.getDate("AvailabilityDate").toLocalDate();

                equipment = new Equipment(equipmentId, name, typeOfWorkout, availabilityDate);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return equipment;
    }

    public static List<Equipment> readAll() {
        List<Equipment> equipmentList = new ArrayList<>();
        try {
            Connection con = getCon();

            String sql = "SELECT * FROM Equipment";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("EquipmentId");
                String name = rs.getString("EquipmentName");
                String typeOfWorkout = rs.getString("TypeOfWorkout");
                LocalDate availabilityDate = rs.getDate("AvailabilityDate").toLocalDate();

                Equipment equipment = new Equipment(id, name, typeOfWorkout, availabilityDate);
                equipmentList.add(equipment);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return equipmentList;
    }

    public static boolean create(Equipment equipment) {
        try {
            Connection con = getCon();

            String sql = "INSERT INTO Equipment (EquipmentId, EquipmentName, TypeOfWorkout, AvailabilityDate) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, equipment.getEquipmentId());
            ps.setString(2, equipment.getEquipmentName());
            ps.setString(3, equipment.getTypeOfWorkout());
            ps.setObject(4, equipment.getAvailabilityDate());

            int rowsAffected = ps.executeUpdate();
            con.close();
            return rowsAffected == 1;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean update(Equipment equipment) {
        try {
            Connection con = getCon();

            String sql = "UPDATE Equipment SET EquipmentName = ?, TypeOfWorkout = ?, AvailabilityDate = ? WHERE EquipmentId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, equipment.getEquipmentName());
            ps.setString(2, equipment.getTypeOfWorkout());
            ps.setObject(3, equipment.getAvailabilityDate());
            ps.setInt(4, equipment.getEquipmentId());

            int rowsAffected = ps.executeUpdate();
            con.close();
            return rowsAffected == 1;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean delete(int equipmentId) {
        boolean deleted = false;
        try {
            Connection con = getCon();

            String sql = "DELETE FROM Equipment WHERE EquipmentId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, equipmentId);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                deleted = true;
                System.out.println("Equipment with ID " + equipmentId + " deleted successfully.");
            } else {
                System.out.println("Equipment with ID " + equipmentId + " not found.");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return deleted;
    }
}
