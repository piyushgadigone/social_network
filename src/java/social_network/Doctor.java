/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Owner
 */
public class Doctor {
    private String login;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private Date dob;
    private Date licenceYear;
    private ArrayList<String> specialisations;
    private ArrayList<Address> addresses;
    private ArrayList<Review> reviews;
    private double avgRating;

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        if(firstName == null) firstName = "";
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        if(middleName == null) middleName = "";
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        if(lastName == null) lastName = "";
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        if(gender == null) gender = "";
        this.gender = gender;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the licenceYear
     */
    public Date getLicenceYear() {
        return licenceYear;
    }

    /**
     * @param licenceYear the licenceYear to set
     */
    public void setLicenceYear(Date licenceYear) {
        this.licenceYear = licenceYear;
    }

    /**
     * @return the specialisations
     */
    public ArrayList<String> getSpecialisations() {
        return specialisations;
    }

    /**
     * @param specialisations the specialisations to set
     */
    public void setSpecialisations(ArrayList<String> specialisations) {
        this.specialisations = specialisations;
    }

    /**
     * @return the addresses
     */
    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the review
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    /**
     * @param review the review to set
     */
    public void setReviews(ArrayList<Review> review) {
        this.reviews = review;
    }

    /**
     * @return the avgRating
     */
    public double getAvgRating() {
        return avgRating;
    }

    /**
     * @param avgRating the avgRating to set
     */
    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
  
}
