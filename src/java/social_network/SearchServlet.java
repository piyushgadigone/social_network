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

/**
 *
 * @author Piyush
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {
    private DoctorSearch createDoctorSearchObject(HttpServletRequest request) {
        
        DoctorSearch docSearch = new DoctorSearch();
        if(request.getParameter("first_name") != null) {
            docSearch.setFirstName(request.getParameter("first_name"));
        }
        if(request.getParameter("middle_name") != null) {
            docSearch.setMiddleName(request.getParameter("middle_name"));
        }
        if(request.getParameter("last_name") != null) {
            docSearch.setLastName(request.getParameter("last_name"));
        }
        if(request.getParameter("gender") != null) {
            docSearch.setGender(request.getParameter("gender"));
        }
        if(request.getParameter("num_years_experience") != null) {
            Calendar now = Calendar.getInstance();
            java.util.Date curTime = now.getTime();
            int num_years_ago = Integer.parseInt(request.getParameter("num_years_experience"));
            now.add(Calendar.YEAR, -num_years_ago);
            java.sql.Date licenseYear;
            licenseYear = new java.sql.Date(now.getTime().getTime());
            //Date licenseYear = Date.parse(request.getParameter("num_"))
            docSearch.setLicense_year(licenseYear);
        }
        if(request.getParameter("specialisation") != null) {
            docSearch.setSpecialisation(request.getParameter("specialisation"));
        }
        if(request.getParameter("street_number") != null) {
            docSearch.setStreetNumber(Integer.parseInt(request.getParameter("street_number")));
        }
        if(request.getParameter("street_name") != null) {
            docSearch.setStreetName(request.getParameter("street_name"));
        }
        if(request.getParameter("postal_code") != null) {
            docSearch.setPostalCode(request.getParameter("postal_code"));
        }
        if(request.getParameter("house_number") != null) {
            docSearch.setHouseNumber(request.getParameter("house_number"));
        }
        if(request.getParameter("city") != null) {
            docSearch.setCity(request.getParameter("city"));
        }
        if(request.getParameter("province") != null) {
            docSearch.setProvince(request.getParameter("province"));
        }
        
        return docSearch;
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
        try {
            
            DoctorSearch ds = createDoctorSearchObject(request);
            ds.setCity("Calgary");
            ds.setStreetNumber(1);
            ArrayList<Doctor> listOfDoctors = SearchDBAO.getSearchDoctors(ds);
            request.setAttribute("doctorSearchResults", listOfDoctors);
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
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
