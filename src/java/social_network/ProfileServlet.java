/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Satyam
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

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
        String strQueryParam = request.getParameter("page");
        int intQueryParam = Integer.parseInt(strQueryParam);
        String patientLogin = request.getParameter("patient");
        String doctorLogin = request.getParameter("doctor");
        // two input parameters
        // current session user
        // login of the user whose profile they want to see
        try {
            String url = "/index.jsp";
            boolean validLogin;
            if (request.getSession().getAttribute("login") == null) {
                validLogin = false;
            } else {
                validLogin = true;
            }
            try {
                if(validLogin) {
                    if(request.getSession().getAttribute("role") != null) {
                        if(request.getSession().getAttribute("role").toString().equals("admin")) {
                            if (intQueryParam == 1) { // Patient Info
                                ArrayList<Review> listOfReviews = ReviewDBAO.getAllReviewsByPatient(patientLogin);
                                request.setAttribute("listOfReviews", listOfReviews);     
                                ArrayList<Patient> listOfFriends = PatientDBAO.getAllFriends(patientLogin);
                                request.setAttribute("listOfFriends", listOfFriends);
                                url = "/patient_view_for_admin.jsp";
                             } else if(intQueryParam == 2) {  // Doctor Info
                                 Doctor fullDoctorProfile = DoctorDBAO.getDoctorInfo(doctorLogin);
                                 ArrayList<Review> listOfReviews = ReviewDBAO.getAllReviewsForDoctor(doctorLogin);
                                 request.setAttribute("listOfReviews", listOfReviews); 
                                 request.setAttribute("doctor", fullDoctorProfile);
                                 url = "/doctor_view_for_admin.jsp";
                             }   
                        }else if(request.getSession().getAttribute("role").toString().equals("patient")){
                             if (intQueryParam == 1) { // Patient Info
                                ArrayList<Review> listOfReviews = ReviewDBAO.getAllReviewsByPatient(patientLogin);
                                request.setAttribute("listOfReviews", listOfReviews);     
                                ArrayList<Patient> listOfFriends = PatientDBAO.getAllFriends(patientLogin);
                                request.setAttribute("listOfFriends", listOfFriends);
                                url = "/patient_view_for_patient.jsp";
                             } else if(intQueryParam == 2) {  // Doctor Info
                                 Doctor partialDoctorProfile = DoctorDBAO.getDoctorInfoForPatient(doctorLogin);
                                 ArrayList<Review> listOfReviews = ReviewDBAO.getAllReviewsForDoctor(doctorLogin);
                                 request.setAttribute("listOfReviews", listOfReviews); 
                                 request.setAttribute("doctor", partialDoctorProfile);
                                 url = "/doctor_view_for_patient.jsp";
                             }   
                        }
                    }
                }
            } catch (Exception e) {
                request.setAttribute("exception", e);
                url = "/error.jsp"; // TODO: beautify exception page
            }
            getServletContext().getRequestDispatcher(url).forward(request, response);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfileServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
