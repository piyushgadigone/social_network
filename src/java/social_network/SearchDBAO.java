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
import static social_network.SearchDBAO.getConnection;
import static social_network.SearchDBAO.pwd;
import static social_network.SearchDBAO.url;
import static social_network.SearchDBAO.user;

public class SearchDBAO {
    public static final String url = "jdbc:mysql://eceweb.uwaterloo.ca:3306/";
    public static final String user = "user_s52gupta";
    public static final String pwd = "user_s52gupta";

   public static ArrayList<Patient> getSearchPatients(PatientSearch ps) 
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       String query = null;
       try {
           con = getConnection();
           stmt = con.createStatement();
           query = "SELECT distinct login FROM Patient WHERE ";
           
           if(ps != null) {
                if(ps.getLogin()!= null)
                    query += "login LIKE '%"+ps.getLogin()+"%' AND ";
                if(ps.getFirstName() != null)
                    query += "first_name LIKE '%"+ps.getFirstName()+"%' AND ";
                if(ps.getMiddleName() != null)
                    query += "middle_name LIKE '%"+ps.getMiddleName()+"%' AND ";
                if(ps.getLastName() != null)
                    query += "last_name LIKE '%"+ps.getLastName()+"%' AND ";
                if(ps.getEmailAddress()!= null)
                    query += "last_name LIKE '%"+ps.getEmailAddress()+"%' AND ";
           }
           query+="1=1;";
           ResultSet resultSet = stmt.executeQuery(query);
           
           ArrayList<Patient> patientList = new ArrayList<Patient>();
           while(resultSet.next()) {
               patientList.add(PatientDBAO.getPatientInfo(resultSet.getString("login")));
           }
           return patientList;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }
   
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
    
   public static ArrayList<String> getDoctorsRecommendedByFriends(String login) 
        throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       try {
           con = getConnection();
           stmt = con.createStatement();
           ArrayList<String> doctorList = new ArrayList<String>();
           PreparedStatement pStmt = con.prepareStatement("SELECT doctor_login FROM recommended_doctors WHERE patient_login=? ;");
           pStmt.setString(1, login);

           ResultSet resultSet = pStmt.executeQuery();
           while(resultSet.next()) {
               doctorList.add(resultSet.getString("doctor_login"));
           }
           return doctorList;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }
   
   public static ArrayList<String> getDoctorsWithAvgRating(int avg_rating) 
                        throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       try {
           con = getConnection();
           stmt = con.createStatement();
           ArrayList<String> doctorList = new ArrayList<String>();
           PreparedStatement pStmt = con.prepareStatement("SELECT doctor_login, AVG(Rating) FROM Reviews " +
            "GROUP BY doctor_login "+
            "HAVING AVG(rating) >= ?");
           pStmt.setInt(1, avg_rating);

           ResultSet resultSet = pStmt.executeQuery();
           while(resultSet.next()) {
               doctorList.add(resultSet.getString("doctor_login"));
           }
           return doctorList;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }

   public static ArrayList<Doctor> getSearchDoctors(DoctorSearch ds) 
           throws ClassNotFoundException, SQLException {
       Connection con = null;
       Statement stmt = null;
       String query = null;
       try {
           con = getConnection();
           stmt = con.createStatement();
           query = "SELECT distinct Doctor.login FROM Doctor LEFT JOIN Specialisation ON Doctor.login = Specialisation.login"
                   + " LEFT JOIN Address ON Doctor.login = Address.login WHERE ";
           
           if(ds!=null) {
                if(ds.getLogin()!= null)
                    query += "login LIKE '%"+ds.getLogin()+"%' AND ";
                if(ds.getFirstName() != null)
                    query += "first_name LIKE '%"+ds.getFirstName()+"%' AND ";
                if(ds.getMiddleName() != null)
                    query += "middle_name LIKE '%"+ds.getMiddleName()+"%' AND ";
                if(ds.getLastName() != null)
                    query += "last_name LIKE '%"+ds.getLastName()+"%' AND ";
                if(ds.getGender()!= null)
                    query += "gender LIKE '%"+ds.getGender()+"%' AND ";
                if(ds.getLicense_year()!= null)
                    query += "license_year < '"+ds.getLicense_year()+"' AND ";
                if(ds.getSpecialisation()!= null)
                    query += "area_of_specialisation LIKE '%"+ds.getSpecialisation()+"%' AND ";
                if(ds.getStreetNumber()!= 0)
                    query += "street_number LIKE "+ds.getStreetNumber()+" AND ";
                if(ds.getStreetName()!= null)
                    query += "street_name LIKE '%"+ds.getStreetName()+"%' AND ";
                if(ds.getPostalCode()!= null)
                    query += "postal_code LIKE '%"+ds.getPostalCode()+"%' AND ";
                if(ds.getHouseNumber()!= null)
                    query += "house_number LIKE '%"+ds.getHouseNumber()+"%' AND ";
                if(ds.getCity()!= null)
                    query += "city LIKE '"+ds.getCity()+"' AND ";
                if(ds.getProvince()!= null)
                    query += "province LIKE '"+ds.getProvince()+"' AND ";
                }
            query+="1=1;";
           ResultSet resultSet = stmt.executeQuery(query);
           ArrayList<String> doctorLoginList = new ArrayList<String>();
           while(resultSet.next()) {
               doctorLoginList.add(resultSet.getString("login"));
           }
           
           ArrayList<String> tmpList = null;
           if(ds.getRating()>=0) {
             tmpList = getDoctorsWithAvgRating(ds.getRating());  
             for(int i = 0; i < doctorLoginList.size();) {
                 if(!exists(tmpList,doctorLoginList.get(i))) {
                     doctorLoginList.remove(i);
                 }
                 else {
                     i++;
                 }
             }
           }
           
           tmpList = null;
           if(ds.isRecommendedByFriend()) {
             tmpList = getDoctorsRecommendedByFriends(ds.getPatientLogin());  
             for(int i = 0; i < doctorLoginList.size();) {
                 if(!exists(tmpList,doctorLoginList.get(i))) {
                     doctorLoginList.remove(i);
                 }
                 else {
                     i++;
                 }
             }
           }
           
           ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
           for(String s : doctorLoginList) {
               doctorList.add(DoctorDBAO.getDoctorInfo(s));
           }
           return doctorList;
       } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }    
       }
   }
   
   public static boolean exists(ArrayList<String> list, String str) {
       for(String a : list) {
           if(str.equals(a)) return true;
       }
       return false;
   }
}
