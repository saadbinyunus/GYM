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

public class Equipment {

    private int equipmentId;
    private String equipmentName;
    private String typeOfWorkout;
    private LocalDate availabilityDate;

    public Equipment(int equipmentId, String equipmentName, String typeOfWorkout, LocalDate availabilityDate) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.typeOfWorkout = typeOfWorkout;
        this.availabilityDate = availabilityDate;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
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

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", typeOfWorkout='" + typeOfWorkout + '\'' +
                ", availabilityDate=" + availabilityDate +
                '}';
    }
}
