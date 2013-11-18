/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
 *
 * @author Piyush
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {
    private DoctorSearch createDoctorSearchObject(HttpServletRequest request) {
        
        DoctorSearch docSearch = new DoctorSearch();
        
        if(request.getParameter("login") != null) {
            String login = (String)request.getParameter("login");
            if(!login.isEmpty())
                docSearch.setLogin(login);
        }
        if(request.getParameter("firstname") != null) {
            String firstName = (String)request.getParameter("firstname");
            if(!firstName.isEmpty())
            docSearch.setFirstName(firstName);
        }
        
        if(request.getParameter("middlename") != null) {
            String middleName = (String)request.getParameter("middlename");
            if(!middleName.isEmpty())
            docSearch.setMiddleName(middleName);
        }
        if(request.getParameter("lastname") != null ) {
            String lastName = (String)request.getParameter("lastname");
            if(!lastName.isEmpty())
            docSearch.setLastName(lastName);
        }      
       
        if(request.getParameter("gender") != null) {
            String gender = (String)request.getParameter("gender");
            if(!gender.isEmpty()) {
                docSearch.setGender(gender);
            }
        }
        if(request.getParameter("recommended") != null) {
            String recommended = (String)request.getParameter("recommended");
            if(!recommended.isEmpty()) { 
                docSearch.setRecommendedByFriend(true);
                docSearch.setPatientLogin(request.getSession().getAttribute("login").toString());
            }
        }
        if(request.getParameter("numyears") != null) {
            Calendar now = Calendar.getInstance();
            java.util.Date curTime = now.getTime();
            String numYears = (String)request.getParameter("numyears");
            if(!numYears.isEmpty()) {
                int num_years_ago = Integer.parseInt(request.getParameter("numyears"));
                now.add(Calendar.YEAR, -num_years_ago);
                java.sql.Date licenseYear;
                licenseYear = new java.sql.Date(now.getTime().getTime());
                //Date licenseYear = Date.parse(request.getParameter("num_"))
                docSearch.setLicense_year(licenseYear);
            }
        }
        
        if(request.getParameter("specialisation") != null) {
            String specialisation = (String)request.getParameter("specialisation");
            if(!specialisation.isEmpty())
                docSearch.setSpecialisation(request.getParameter("specialisation"));
        }
        
        /*if(request.getParameter("streetNumber") != null) {
            String streetNumber = (String)request.getParameter("streetNumber");
            if(!streetNumber.isEmpty()) {
                int streetNo = Integer.parseInt(streetNumber);
                docSearch.setStreetNumber(streetNo);
            }
        }*/
        
        if(request.getParameter("stars")!= null) {
            String ratings = (String)request.getParameter("stars");
            if(!ratings.isEmpty()) {
                docSearch.setRating(Integer.parseInt(ratings));
            }
        }
        
        if(request.getParameter("street") != null) {
            String streetName = (String)request.getParameter("street");
            if(!streetName.isEmpty()) {
                docSearch.setStreetName(request.getParameter("street"));
            }
        }
        if(request.getParameter("postalCode") != null) {
            String postalCode = (String)request.getParameter("postalCode");
            if(!postalCode.isEmpty()) {
                docSearch.setPostalCode(request.getParameter("postalCode"));
            }
        }
        /*
        if(request.getParameter("houseNumber") != null) {
            String houseNumber = (String)request.getParameter("houseNumber");
            if(!houseNumber.isEmpty()) {
                docSearch.setHouseNumber(request.getParameter("houseNumber"));
            }
        }*/
        if(request.getParameter("city") != null) {
            String city = (String)request.getParameter("city");
            if(!city.isEmpty()) 
                docSearch.setCity(request.getParameter("city"));
        }
        if(request.getParameter("province") != null) {
            String province = (String)request.getParameter("province");
            if(!province.isEmpty())
                docSearch.setProvince(request.getParameter("province"));
        }
        
        return docSearch;
    }
    
    private void addAvgRating(ArrayList<Doctor> doctorList) {
        double avg_rating;
        for(int i = 0; i < doctorList.size(); i++) {
            avg_rating = 0;
            for(Review r : doctorList.get(i).getReviews()) {
                avg_rating += r.getRating();
            }
            if(doctorList.get(i).getReviews().size() > 0)
                avg_rating = avg_rating/doctorList.get(i).getReviews().size();
            doctorList.get(i).setAvgRating(avg_rating);
        }
    }
    
    // Sort based on avgRatings, then review date
    private void sort(ArrayList<Doctor> doctorList) {
        // Sort based on avgRatings
        Doctor doctor;
        int j;
        int i;
        for(j = 1; j < doctorList.size(); j++) {
            doctor = doctorList.get(j);
            for(i = j-1; i >= 0 && (doctorList.get(i).getAvgRating() < doctor.getAvgRating()); i--) {
                doctorList.set(i+1, doctorList.get(i));
            }
            doctorList.set(i+1,doctor);
        }
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "/index.jsp";;
        try {
            boolean validLogin;
            if (request.getSession().getAttribute("login") == null) {
                validLogin = false;
            } else {
                validLogin = true;
            }
            if(validLogin) {
                DoctorSearch ds = createDoctorSearchObject(request);

                ArrayList<Doctor> listOfDoctors = SearchDBAO.getSearchDoctors(ds);
                addAvgRating(listOfDoctors);
                sort(listOfDoctors);
            
                request.setAttribute("listOfDoctors", listOfDoctors);
                url = "/doctor_search_results.jsp";
            }

             /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("exception", ex);
            url = "/error.jsp";
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("exception", ex);
            url = "/error.jsp";
        } catch (Exception e) {
                request.setAttribute("exception", e);
                url = "/error.jsp";
        }finally {            
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
            out.close();
        } 
        
    }
/**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
