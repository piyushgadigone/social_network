/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class Watch {
    private String doctor_login;
    private String patient_login; 
    private ArrayList<Review> doctor_reviews;

    /**
     * @return the doctor_login
     */
    public String getDoctor_login() {
        return doctor_login;
    }

    /**
     * @param doctor_login the doctor_login to set
     */
    public void setDoctor_login(String doctor_login) {
        this.doctor_login = doctor_login;
    }

    /**
     * @return the patient_login
     */
    public String getPatient_login() {
        return patient_login;
    }

    /**
     * @param patient_login the patient_login to set
     */
    public void setPatient_login(String patient_login) {
        this.patient_login = patient_login;
    }

    /**
     * @return the doctor_reviews
     */
    public ArrayList<Review> getDoctor_reviews() {
        return doctor_reviews;
    }

    /**
     * @param doctor_reviews the doctor_reviews to set
     */
    public void setDoctor_reviews(ArrayList<Review> doctor_reviews) {
        this.doctor_reviews = doctor_reviews;
    }
}
