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
import static social_network.DoctorDBAO.getConnection;
import static social_network.DoctorDBAO.pwd;
import static social_network.DoctorDBAO.url;
import static social_network.DoctorDBAO.user;

public class DoctorDBAO {
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

   public static boolean isDoctor (String login) 
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       boolean isDoctor = false;
       try {
           con = getConnection();
           stmt = con.createStatement();
           PreparedStatement pStmt = con.prepareStatement("SELECT login FROM Doctor WHERE login=?");
           pStmt.setString(1, login);

           ResultSet resultSet = pStmt.executeQuery();
           isDoctor = resultSet.first();
           return isDoctor;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }
   
    public static ArrayList<String> getDistinctSpecializations () 
           throws ClassNotFoundException, SQLException {
       ArrayList<String> specialisations = null;
       Connection con = null;
       Statement stmt = null;
       try {
           con = getConnection();
           stmt = con.createStatement();
           PreparedStatement pStmt = con.prepareStatement(
                   "SELECT DISTINCT area_of_specialisation FROM Specialisation");
           ResultSet resultSet = pStmt.executeQuery();
           specialisations = new ArrayList<String>();
           while (resultSet.next()) {
                specialisations.add(resultSet.getString("area_of_specialisation"));
           } 
           return specialisations;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
    }

   public static Doctor getDoctorInfoForPatient (String login) 
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       Doctor doctor = new Doctor();
       try {
           con = getConnection();
           stmt = con.createStatement();
           PreparedStatement pStmt = con.prepareStatement("SELECT * FROM Doctor WHERE login=?");
           pStmt.setString(1, login);
           
           ResultSet resultSet = pStmt.executeQuery();
           
           ArrayList<Address> addresses = new ArrayList<Address>();
           ArrayList<String> specialisations = new ArrayList<String>();
           while (resultSet.next()) {
                doctor.setLogin(login);
                doctor.setFirstName(resultSet.getString("first_name"));
                doctor.setLastName(resultSet.getString("last_name"));
                doctor.setMiddleName(resultSet.getString("middle_name"));
                doctor.setGender(resultSet.getString("gender"));
                doctor.setLicenceYear(resultSet.getDate("license_year"));
           }
           
           pStmt = con.prepareStatement("SELECT * FROM Specialisation WHERE login=?");
           pStmt.setString(1, login);
           
           resultSet = pStmt.executeQuery();
           while (resultSet.next()) {
                specialisations.add(resultSet.getString("area_of_specialisation"));
           }
           
           pStmt = con.prepareStatement("SELECT * FROM Address WHERE login=?");
           pStmt.setString(1, login);
           
           resultSet = pStmt.executeQuery();
           while (resultSet.next()) {
                if(resultSet.getString("type").equals("work")) {
                    Address address = new Address();
                    address.setCity(resultSet.getString("city"));
                    address.setHouseNumber(resultSet.getString("house_number"));
                    address.setPostalCode(resultSet.getString("postal_code"));
                    address.setProvince(resultSet.getString("province"));
                    address.setStreetName(resultSet.getString("street_name"));
                    address.setStreetNumber(resultSet.getString("street_number"));

                    address.setType(resultSet.getString("type"));
                    addresses.add(address);
                }
           }
                                 
           doctor.setSpecialisations(specialisations);
           doctor.setAddresses(addresses);
           return doctor;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }
   
   public static Doctor getDoctorInfo (String login) 
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       Doctor doctor = new Doctor();
       try {
           con = getConnection();
           stmt = con.createStatement();
           PreparedStatement pStmt = con.prepareStatement("SELECT * FROM Doctor WHERE login=?");
           pStmt.setString(1, login);
           
           ResultSet resultSet = pStmt.executeQuery();
           
           ArrayList<Address> addresses = new ArrayList<Address>();
           ArrayList<String> specialisations = new ArrayList<String>();
           ArrayList<Review> reviews = new ArrayList<Review>();
           while (resultSet.next()) {
                doctor.setLogin(login);
                doctor.setFirstName(resultSet.getString("first_name"));
                doctor.setLastName(resultSet.getString("last_name"));
                doctor.setMiddleName(resultSet.getString("middle_name"));
                doctor.setGender(resultSet.getString("gender"));
                doctor.setLicenceYear(resultSet.getDate("license_year"));
                doctor.setDob(resultSet.getDate("date_of_birth"));
           }
           
           pStmt = con.prepareStatement("SELECT * FROM Specialisation WHERE login=?");
           pStmt.setString(1, login);
           
           resultSet = pStmt.executeQuery();
           while (resultSet.next()) {
                specialisations.add(resultSet.getString("area_of_specialisation"));
           }
           
           pStmt = con.prepareStatement("SELECT * FROM Address WHERE login=?");
           pStmt.setString(1, login);
           
           resultSet = pStmt.executeQuery();
           while (resultSet.next()) {
                Address address = new Address();
                address.setCity(resultSet.getString("city"));
                address.setHouseNumber(resultSet.getString("house_number"));
                address.setPostalCode(resultSet.getString("postal_code"));
                address.setProvince(resultSet.getString("province"));
                address.setStreetName(resultSet.getString("street_name"));
                address.setStreetNumber(resultSet.getString("street_number"));
                address.setType(resultSet.getString("type"));
                addresses.add(address);
           }
           
           pStmt = con.prepareStatement("SELECT * FROM Reviews WHERE doctor_login=?");
           pStmt.setString(1, login);
           
           resultSet = pStmt.executeQuery();
           while (resultSet.next()) {
                Review review = new Review();
                review.setComments(resultSet.getString("comments"));
                review.setDoctorLogin(resultSet.getString("doctor_login"));
                review.setPatientLogin(resultSet.getString("patient_login"));
                review.setRating(resultSet.getInt("rating"));
                review.setDatetime(resultSet.getTimestamp("datetime"));
                reviews.add(review);
           }
           
           doctor.setSpecialisations(specialisations);
           doctor.setAddresses(addresses);
           doctor.setReviews(reviews);
           return doctor;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }
   
    public static ArrayList<Doctor> getAllDoctors() throws SQLException, ClassNotFoundException {
       Connection con = null;
       ArrayList<Doctor> listOfDoctors = new ArrayList<Doctor>();
       PreparedStatement pStmt = null;
       try {
           con = getConnection();
           pStmt = con.prepareStatement("SELECT * FROM Doctor");
           ResultSet resultSet = pStmt.executeQuery();
           
           while(resultSet.next()) {
               Doctor doc = new Doctor();
               doc.setFirstName(resultSet.getString("first_name"));
               doc.setLastName(resultSet.getString("last_name"));
               doc.setMiddleName(resultSet.getString("middle_name"));
               doc.setLogin(resultSet.getString("login"));
               doc.setGender(resultSet.getString("gender"));
               doc.setLicenceYear(resultSet.getDate("license_year"));
               doc.setDob(resultSet.getDate("date_of_birth"));
               listOfDoctors.add(doc);         
           }
           
           return listOfDoctors;
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
