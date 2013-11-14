/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

/**
 *
 * @author Satyam
 */
public class Friend {
    private String patientLogin;
    private String friendLogin;
    
    public String getPatientLogin() {
        return this.patientLogin;
    }
    
    public String getFriendLogin() {
        return this.friendLogin;
    }
    
    public void setPatientLogin(String patientLogin) {
        this.patientLogin = patientLogin;
    }
    
    public void setFriendLogin(String friendLogin) {
        this.friendLogin = friendLogin;
    }
}
