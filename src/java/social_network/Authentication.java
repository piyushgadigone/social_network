/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

/**
 *
 * @author Satyam
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authentication {
    private String login;
    private String hashed_password; 
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setPassword(String password) {
        //TODO: SHA2 Hashing
        this.hashed_password = password;
    }
    
    public String getHashedPassword() {
        return hashed_password;
    }
    
}
