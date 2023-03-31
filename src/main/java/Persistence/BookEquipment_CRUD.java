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
import Helper.BookEquipment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookEquipment_CRUD {
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

    public static BookEquipment read(int bookId) {
        BookEquipment bookEquipment = null;
        try {
            Connection con = getCon();

            String sql = "SELECT * FROM BookEquipment WHERE BookId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int equipmentId = rs.getInt("EquipmentId");
                int clientId = rs.getInt("ClientId");
                String equipmentName = rs.getString("EquipmentName");
                String typeOfWorkout = rs.getString("TypeOfWorkout");
                LocalDate availabilityDate = rs.getDate("AvailabilityDate").toLocalDate();
                LocalDate bookDate = rs.getDate("BookDate").toLocalDate();

                bookEquipment = new BookEquipment(bookId, equipmentId, clientId, equipmentName, typeOfWorkout, availabilityDate, bookDate);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bookEquipment;
    }

    public static List<BookEquipment> readAll() {
        List<BookEquipment> bookEquipmentList = new ArrayList<>();
        try {
            Connection con = getCon();

            String sql = "SELECT * FROM BookEquipment";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt("BookId");
                int equipmentId = rs.getInt("EquipmentId");
                int clientId = rs.getInt("ClientId");
                String equipmentName = rs.getString("EquipmentName");
                String typeOfWorkout = rs.getString("TypeOfWorkout");
                LocalDate availabilityDate = rs.getDate("AvailabilityDate").toLocalDate();
                LocalDate bookDate = rs.getDate("BookDate").toLocalDate();

                BookEquipment bookEquipment = new BookEquipment(bookId, equipmentId, clientId, equipmentName, typeOfWorkout, availabilityDate, bookDate);
                bookEquipmentList.add(bookEquipment);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bookEquipmentList;
    }
    public static boolean create(BookEquipment bookEquipment) {
    try {
        Connection con = getCon();

        String sql = "INSERT INTO BookEquipment (EquipmentId, ClientId, EquipmentName, TypeOfWorkout, AvailabilityDate, BookDate) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, bookEquipment.getEquipmentId());
        ps.setInt(2, bookEquipment.getClientId());
        ps.setString(3, bookEquipment.getEquipmentName());
        ps.setString(4, bookEquipment.getTypeOfWorkout());
        ps.setObject(5, bookEquipment.getAvailabilityDate());
        ps.setObject(6, bookEquipment.getBookDate());

        int rowsAffected = ps.executeUpdate();
        con.close();
        return rowsAffected == 1;
    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
}
    public static boolean update(BookEquipment bookEquipment) {
    try {
        Connection con = getCon();

        String sql = "UPDATE BookEquipment SET EquipmentId = ?, ClientId = ?, EquipmentName = ?, TypeOfWorkout = ?, AvailabilityDate = ?, BookDate = ? WHERE BookId = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, bookEquipment.getEquipmentId());
        ps.setInt(2, bookEquipment.getClientId());
        ps.setString(3, bookEquipment.getEquipmentName());
        ps.setString(4, bookEquipment.getTypeOfWorkout());
        ps.setObject(5, bookEquipment.getAvailabilityDate());
        ps.setObject(6, bookEquipment.getBookDate());
        ps.setInt(7, bookEquipment.getBookId());

        int rowsAffected = ps.executeUpdate();
        con.close();
        return rowsAffected == 1;
    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
}
public static boolean delete(int bookId) {
    boolean deleted = false;
    try {
        Connection con = getCon();

        String sql = "DELETE FROM BookEquipment WHERE BookId = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, bookId);

        int rowsDeleted = ps.executeUpdate();
        if (rowsDeleted > 0) {
            deleted = true;
            System.out.println("Booking with ID " + bookId + " deleted successfully.");
        } else {
            System.out.println("Booking with ID " + bookId + " not found.");
        }

        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    return deleted;
}
}