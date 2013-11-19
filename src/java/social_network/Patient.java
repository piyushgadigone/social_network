/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.util.ArrayList;

/**
 *
 * @author Satyam
 */
public class Patient {
    private String login;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;  
    private ArrayList<Review> reviewsMade;
    private ArrayList<Patient> friends;
    private ArrayList<Watch> watchList;
    private boolean isFriend = false;

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
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        if(emailAddress == null) emailAddress = "";
        this.emailAddress = emailAddress;
    }

    /**
     * @return the reviewsMade
     */
    public ArrayList<Review> getReviewsMade() {
        return reviewsMade;
    }

    /**
     * @param reviewsMade the reviewsMade to set
     */
    public void setReviewsMade(ArrayList<Review> reviewsMade) {
        this.reviewsMade = reviewsMade;
    }

    /**
     * @return the friends
     */
    public ArrayList<Patient> getFriends() {
        return friends;
    }

    /**
     * @param friends the friends to set
     */
    public void setFriends(ArrayList<Patient> friends) {
        this.friends = friends;
    }

    /**
     * @return the isFriend
     */
    public boolean isIsFriend() {
        return isFriend;
    }

    /**
     * @param isFriend the isFriend to set
     */
    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }

    /**
     * @return the watchList
     */
    public ArrayList<Watch> getWatchList() {
        return watchList;
    }

    /**
     * @param watchList the watchList to set
     */
    public void setWatchList(ArrayList<Watch> watchList) {
        this.watchList = watchList;
    }
}