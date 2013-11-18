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
public class DoctorSearch {
    private String login = null;
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;
    private String gender = null;
    private Date license_year = null;
    private String specialisation = null;
    private int streetNumber = 0;
    private String streetName = null;
    private String postalCode = null;
    private String houseNumber = null;
    private String city = null;
    private String province = null;
    private double rating = -1;
    private boolean recommendedByFriend = false;
    private String patientLogin = null; //Set if recommendedByFriend is set to true


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
        this.gender = gender;
    }

    /**
     * @return the license_year
     */
    public Date getLicense_year() {
        return license_year;
    }

    /**
     * @param license_year the license_year to set
     */
    public void setLicense_year(Date license_year) {
        this.license_year = license_year;
    }

    /**
     * @return the specialisation
     */
    public String getSpecialisation() {
        return specialisation;
    }

    /**
     * @param specialisation the specialisation to set
     */
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    /**
     * @return the streetNumber
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * @param streetNumber the streetNumber to set
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the houseNumber
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return the recommendedByFriend
     */
    public boolean isRecommendedByFriend() {
        return recommendedByFriend;
    }

    /**
     * @param recommendedByFriend the recommendedByFriend to set
     */
    public void setRecommendedByFriend(boolean recommendedByFriend) {
        this.recommendedByFriend = recommendedByFriend;
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
}
