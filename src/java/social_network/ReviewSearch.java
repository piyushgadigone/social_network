/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.sql.Date;

/**
 *
 * @author Piyush
 */
public class ReviewSearch {
    private String doctorLogin = null;
    private String patientLogin = null;
    private Date minDateTime = null;
    private int minRatings = -1;
    private Date maxDateTime = null;
    private int maxRatings = -1;
    private String comments = null;

    /**
     * @return the doctorLogin
     */
    public String getDoctorLogin() {
        return doctorLogin;
    }

    /**
     * @param doctorLogin the doctorLogin to set
     */
    public void setDoctorLogin(String doctorLogin) {
        this.doctorLogin = doctorLogin;
    }

    /**
     * @return the patientLogin
     */
    public String getPatientLogin() {
        return patientLogin;
    }

    /**
     * @param patientLogin the patientLogin to set
     */
    public void setPatientLogin(String patientLogin) {
        this.patientLogin = patientLogin;
    }

    /**
     * @return the minDateTime
     */
    public Date getMinDateTime() {
        return minDateTime;
    }

    /**
     * @param minDateTime the minDateTime to set
     */
    public void setMinDateTime(Date minDateTime) {
        this.minDateTime = minDateTime;
    }

    /**
     * @return the minRatings
     */
    public int getMinRatings() {
        return minRatings;
    }

    /**
     * @param minRatings the minRatings to set
     */
    public void setMinRatings(int minRatings) {
        this.minRatings = minRatings;
    }

    /**
     * @return the maxDateTime
     */
    public Date getMaxDateTime() {
        return maxDateTime;
    }

    /**
     * @param maxDateTime the maxDateTime to set
     */
    public void setMaxDateTime(Date maxDateTime) {
        this.maxDateTime = maxDateTime;
    }

    /**
     * @return the maxRatings
     */
    public int getMaxRatings() {
        return maxRatings;
    }

    /**
     * @param maxRatings the maxRatings to set
     */
    public void setMaxRatings(int maxRatings) {
        this.maxRatings = maxRatings;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

   
}
