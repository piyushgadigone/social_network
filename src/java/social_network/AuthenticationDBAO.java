/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

/**
 *
 * @author Satyam
 */
import java.sql.*;
import java.util.ArrayList;

public class AuthenticationDBAO {
    public static final String url = "jdbc:mysql://eceweb.uwaterloo.ca:3306/";
    public static final String user = "user_s52gupta";
    public static final String pwd = "user_s52gupta";

    public static void testConnection()
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            con = getConnection();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pwd);
        Statement stmt = null;
        try {
            con.createStatement();
            stmt = con.createStatement();
            stmt.execute("USE ece356db_s52gupta;");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return con;
    }

   public static boolean isValidLogin (Authentication authentication) 
           throws ClassNotFoundException, SQLException
   {
       Connection con = null;
       Statement stmt = null;
       boolean loginSuccessful = false;
       try {
           con = getConnection();
           stmt = con.createStatement();
           PreparedStatement pStmt = con.prepareStatement("SELECT * FROM Authentication WHERE login=?");
           pStmt.setString(1, authentication.getLogin());

           ResultSet resultSet = pStmt.executeQuery();
           while (resultSet.next()) {
                if(authentication.getHashedPassword().equals(resultSet.getString("hashed_password"))) {
                    loginSuccessful = true;
                }
           }
           return loginSuccessful;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }

  
}
