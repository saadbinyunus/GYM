/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author student
 */


import java.time.LocalDate;

public class BookEquipment {
    private int bookId;
    private int equipmentId;
    private int clientId;
    private String equipmentName;
    private String typeOfWorkout;
    private LocalDate availabilityDate;
    private LocalDate bookDate;

    public BookEquipment(int bookId, int equipmentId, int clientId, String equipmentName, String typeOfWorkout, LocalDate availabilityDate, LocalDate bookDate) {
        this.bookId = bookId;
        this.equipmentId = equipmentId;
        this.clientId = clientId;
        this.equipmentName = equipmentName;
        this.typeOfWorkout = typeOfWorkout;
        this.availabilityDate = availabilityDate;
        this.bookDate = bookDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getTypeOfWorkout() {
        return typeOfWorkout;
    }

    public void setTypeOfWorkout(String typeOfWorkout) {
        this.typeOfWorkout = typeOfWorkout;
    }

    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDate bookDate) {
        this.bookDate = bookDate;
    }

    @Override
    public String toString() {
        return "BookEquipment{" +
                "bookId=" + bookId +
                ", equipmentId=" + equipmentId +
                ", clientId=" + clientId +
                ", equipmentName='" + equipmentName + '\'' +
                ", typeOfWorkout='" + typeOfWorkout + '\'' +
                ", availabilityDate=" + availabilityDate +
                ", bookDate=" + bookDate +
                '}';
    }
}