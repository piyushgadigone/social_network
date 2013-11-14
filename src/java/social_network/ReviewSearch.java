/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

/**
 *
 * @author Piyush
 */
public class ReviewSearch {
    private String doctorLogin;
    private String patientLogin;
    private String dateTime;
    private int ratings;
    private String comments;

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
     * @return the dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the ratings
     */
    public int getRatings() {
        return ratings;
    }

    /**
     * @param ratings the ratings to set
     */
    public void setRatings(int ratings) {
        this.ratings = ratings;
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
