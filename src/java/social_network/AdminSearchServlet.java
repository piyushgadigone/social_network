/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@WebServlet(name = "AdminSearchServlet", urlPatterns = {"/AdminSearchServlet"})
public class AdminSearchServlet extends HttpServlet {

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
             }
             if(validLogin) {
                ReviewSearch revSearch = new ReviewSearch();
                if(request.getParameter("doctor_login") != null && !request.getParameter("doctor_login").isEmpty()) {
                       revSearch.setDoctorLogin(request.getParameter("doctor_login"));
                }
                if(request.getParameter("patient_login") != null && !request.getParameter("patient_login").isEmpty()) {
                       revSearch.setPatientLogin(request.getParameter("patient_login"));
                }
                if(request.getParameter("comments") != null && !request.getParameter("comments").isEmpty()) {
                       revSearch.setComments(request.getParameter("comments"));
                }
                if(request.getParameter("min_date") != null && !request.getParameter("min_date").isEmpty()) {
                   SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                   java.util.Date parsedDate = dateFormat.parse(request.getParameter("min_date"));
                   java.sql.Date date = new java.sql.Date(parsedDate.getTime());
                   revSearch.setMinDateTime(date);
                }
                if(request.getParameter("max_date") != null && !request.getParameter("max_date").isEmpty()) {
                   SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                   java.util.Date parsedDate = dateFormat.parse(request.getParameter("max_date"));
                   java.sql.Date date = new java.sql.Date(parsedDate.getTime());
                   revSearch.setMaxDateTime(date);
                }
                if(request.getParameter("min_rating") != null && !request.getParameter("min_rating").isEmpty()) {
                       revSearch.setMinRatings(Integer.parseInt(request.getParameter("min_rating")));
                }
                if(request.getParameter("max_rating") != null && !request.getParameter("max_rating").isEmpty()) {
                       revSearch.setMaxRatings(Integer.parseInt(request.getParameter("max_rating")));
                }
               ArrayList<Review> listOfRevs = SearchDBAO.getSearchReviews(revSearch);
               request.setAttribute("reviewsSearchResults", listOfRevs);
               url = "/admin_review_search_results.jsp";
             }
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            url = "/error.jsp";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
            url = "/error.jsp";
        } catch (ParseException ex) {
            Logger.getLogger(AdminSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
