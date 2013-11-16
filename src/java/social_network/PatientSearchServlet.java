/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Owner
 */
@WebServlet(name = "PatientSearchServlet", urlPatterns = {"/PatientSearchServlet"})
public class PatientSearchServlet extends HttpServlet {

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
        String url;
        try {
             String login = request.getSession().getAttribute("login").toString();
             PatientSearch patSearch = new PatientSearch();
             if(request.getParameter("login") != null) {
                 patSearch.setLogin(request.getParameter("login"));
             }
             if(request.getParameter("firstname") != null) {
                 patSearch.setFirstName(request.getParameter("firstname"));
             }
             if(request.getParameter("middlename") != null) {
                 patSearch.setMiddleName(request.getParameter("middlename"));
             }
             if(request.getParameter("last_name") != null) {
                 patSearch.setLastName(request.getParameter("lastname"));
             }
             if(request.getParameter("email") != null) {
                 patSearch.setEmailAddress(request.getParameter("email"));
             }
            ArrayList<Patient> listOfPats = SearchDBAO.getSearchPatients(patSearch);
            ArrayList<Patient> listOfFriends = PatientDBAO.getAllFriends(login);
            String curLogin = request.getSession().getAttribute("login").toString();
            
            for(Patient p : listOfPats) {
                for(Patient f : listOfFriends) {
                    if(p.getLogin().equals(f.getLogin())) {
                        p.setIsFriend(true);
                    }                                      
                }                 
            }
            for(Patient p : listOfPats) {
                 if(p.getLogin().equals(curLogin)) {
                     listOfPats.remove(p);  
                     break;
                 }
            }
            request.setAttribute("patientSearchResults", listOfPats);
            url = "/patient_search_results.jsp";
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PatientSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            url = "/error.jsp";
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            url = "/error.jsp";
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        }finally {            
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
