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
public class Trainer {
    private int trainerId;
    private String trainerName;
    private String specialty;
    private String gender;
    private int phoneNumber;

    public Trainer(int trainerId, String trainerName, String specialty, String gender, int phoneNumber) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.specialty = specialty;
        this.gender = gender;
        //this.availabilityDate = availabilityDate;
        this.phoneNumber = phoneNumber;
    }
    
    public boolean isAvailable(){
        return true;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        String availabilityDate = "x";
        return "TrainerInfo{" +
                "trainerId=" + trainerId +
                ", trainerName='" + trainerName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", gender='" + gender + '\'' +
                ", availabilityDate='" + availabilityDate + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}