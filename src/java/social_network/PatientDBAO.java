/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

/**
 *
 * @author Piyush
 */
import java.sql.*;
import java.util.ArrayList;
import static social_network.PatientDBAO.getConnection;
import static social_network.PatientDBAO.pwd;
import static social_network.PatientDBAO.url;
import static social_network.PatientDBAO.user;

public class PatientDBAO {
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

   public static boolean isPatient (String login) 
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       boolean isPatient = false;
       try {
           con = getConnection();
           stmt = con.createStatement();
           PreparedStatement pStmt = con.prepareStatement("SELECT * FROM Patient WHERE login=?");
           pStmt.setString(1, login);

           ResultSet resultSet = pStmt.executeQuery();
           isPatient = resultSet.first();
           return isPatient;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }
   
   public static boolean addFriend (String patientLogin, String friendLogin)
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       PreparedStatement pStmt = null;
       try {
           con = getConnection();
           
           pStmt = con.prepareStatement("INSERT INTO Friend (patient_login, friend_login) VALUES (?, ?)");
           pStmt.setString(1, patientLogin);
           pStmt.setString(2, friendLogin);
           pStmt.executeUpdate();
           return true;   
           
       }catch(SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }finally {
           if(pStmt != null) {
               pStmt.close();
           }
           if(con != null) {
               con.close();
           }
       }
   }

   
   public static ArrayList<Patient> getAllFriends (String login) 
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       PreparedStatement pStmt = null;
       try {
           con = getConnection();
           
           pStmt = con.prepareStatement("SELECT * FROM Friend WHERE patient_login=?");
           pStmt.setString(1, login);
           ResultSet resultSet;
           resultSet = pStmt.executeQuery();
           ArrayList<Patient> friends = new ArrayList<Patient>();
           while (resultSet.next()) {
               PreparedStatement prepSt = con.prepareStatement("SELECT * FROM Patient WHERE login=?");
               prepSt.setString(1, resultSet.getString("friend_login"));
               ResultSet resSet = prepSt.executeQuery();
               while (resSet.next()) {
                   Patient p = new Patient();
                   p.setLogin(login);
                   p.setFirstName(resSet.getString("first_name"));
                   p.setLastName(resSet.getString("last_name"));
                   p.setMiddleName(resSet.getString("middle_name"));
                   p.setEmailAddress(resSet.getString("email_address"));
                   friends.add(p);
               }
           }
           return friends;
       }finally {       
           if( pStmt != null) {
               pStmt.close();
           }
           if(con != null) {
               con.close();
           }
       }
   }
  
   public static Patient getPatientInfo (String login) 
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       Patient patient = new Patient();
       try {
           con = getConnection();
           stmt = con.createStatement();
           PreparedStatement pStmt = con.prepareStatement("SELECT * FROM Patient WHERE login=?");
           pStmt.setString(1, login);
           
           // add all fields
           ResultSet resultSet = pStmt.executeQuery();
           while (resultSet.next()) {
                patient.setLogin(login);
                patient.setFirstName(resultSet.getString("first_name"));
                patient.setLastName(resultSet.getString("last_name"));
                patient.setMiddleName(resultSet.getString("middle_name"));
                patient.setEmailAddress(resultSet.getString("email_address"));
           }
           
           // add all reviews made by this patient
           pStmt = con.prepareStatement("SELECT * FROM Reviews WHERE patient_login=?");
           pStmt.setString(1, login);
           resultSet = pStmt.executeQuery();
           ArrayList<Review> reviews = new ArrayList<Review>();
           while (resultSet.next()) {
                Review rev = new Review();
                rev.setComments(resultSet.getString("comments"));
                rev.setDoctorLogin(resultSet.getString("doctor_login"));
                rev.setPatientLogin(resultSet.getString("patient_login"));
                rev.setDatetime(resultSet.getTimestamp("datetime"));
                rev.setRating(resultSet.getInt("rating"));
                reviews.add(rev);
           } 
           patient.setReviewsMade(reviews);
           
           // add friends of this patient
           pStmt = con.prepareStatement("SELECT * FROM Friend WHERE patient_login=?");
           pStmt.setString(1, login);
           resultSet = pStmt.executeQuery();
           ArrayList<Patient> friends = new ArrayList<Patient>();
           while (resultSet.next()) {
               PreparedStatement prepSt = con.prepareStatement("SELECT * FROM Patient WHERE login=?");
               prepSt.setString(1, resultSet.getString("friend_login"));
               ResultSet resSet = prepSt.executeQuery();
               while (resSet.next()) {
                   Patient p = new Patient();
                   p.setLogin(login);
                   p.setFirstName(resSet.getString("first_name"));
                   p.setLastName(resSet.getString("last_name"));
                   p.setMiddleName(resSet.getString("middle_name"));
                   p.setEmailAddress(resSet.getString("email_address"));
                   friends.add(p);
               }
           } 
           patient.setFriends(friends);
           return patient;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }  
   
   public static ArrayList<Patient> getAllPatients() throws SQLException, ClassNotFoundException {
       Connection con = null;
       ArrayList<Patient> listOfPatients = new ArrayList<Patient>();
       PreparedStatement pStmt = null;
       try {
           con = getConnection();
           pStmt = con.prepareStatement("SELECT * FROM Patient");
           ResultSet resultSet = pStmt.executeQuery();
           
           while(resultSet.next()) {
               Patient pat = new Patient();
               pat.setFirstName(resultSet.getString("first_name"));
               pat.setLastName(resultSet.getString("last_name"));
               pat.setMiddleName(resultSet.getString("middle_name"));
               pat.setEmailAddress(resultSet.getString("email_address"));
               pat.setLogin(resultSet.getString("login"));
               listOfPatients.add(pat);
           }
           return listOfPatients;
       } finally {
           if (pStmt != null) {
                pStmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
       
   }
}
