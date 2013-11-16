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
        String url = "/index.jsp";
        try {
            boolean validLogin;
            if (request.getSession().getAttribute("login") == null) {
                validLogin = false;
            } else {
                validLogin = true;

             String login = request.getSession().getAttribute("login").toString();
             PatientSearch patSearch = new PatientSearch();
             if(request.getParameter("login") != null) {
                 String patlogin = request.getParameter("login");
                 patSearch.setLogin(patlogin);
             }
             if(request.getParameter("firstname") != null) {
                 String firstName = request.getParameter("firstname");
                 patSearch.setFirstName(firstName);
             }
             if(request.getParameter("middlename") != null) {
                 String middlename = request.getParameter("middlename");
                 patSearch.setMiddleName(middlename);
             }
             if(request.getParameter("lastname") != null) {
                 String lastname = request.getParameter("lastname");
                 patSearch.setLastName(lastname);
             }
             if(request.getParameter("email") != null ) {
                 String email = request.getParameter("email");
                 patSearch.setEmailAddress(email);
             }
            ArrayList<Patient> listOfPats = SearchDBAO.getSearchPatients(patSearch);
            ArrayList<Patient> listOfFriends = PatientDBAO.getAllFriends(login);
            
            for(Patient p : listOfPats) {
                for(Patient f : listOfFriends) {
                    if(f.getLogin().equals(p.getLogin())) {
                        p.setIsFriend(true);
                        break;
                    }                                      
                }        
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            url = "/error.jsp";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            url = "/error.jsp";
        }finally {                   
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
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
