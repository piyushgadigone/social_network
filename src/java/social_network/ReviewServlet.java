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
 * @author Piyush
 */
@WebServlet(name = "ReviewServlet", urlPatterns = {"/ReviewServlet"})
public class ReviewServlet extends HttpServlet {

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
            String url = "/index.jsp";
            boolean validLogin;
            if (request.getSession().getAttribute("login") == null) {
                validLogin = false;
            } else {
                validLogin = true;
            }
            try {
                if(validLogin) {
                    String type = request.getParameter("type");
                    if (type.equals("delete")) {
                        String patient_login = request.getParameter("patient_login");
                        String doctor_login = request.getParameter("doctor_login");
                        String datetime = request.getParameter("datetime");
                        ReviewDBAO.deleteReview(patient_login, doctor_login, datetime);
                        url = "/reviews_search.jsp";
                     } else if(type.equals("insert")) {  
                         //TODO: Insert a review
                     } 
                }
            } catch (Exception e) {
                request.setAttribute("exception", e);
                url = "/error.jsp";
            }
            getServletContext().getRequestDispatcher(url).forward(request, response);
            //Admin curAdmin = AdminDBAO.getAdminInfo(request.getSession().getAttribute("login").toString());
            //request.setAttribute("admin", curAdmin);
            
            //getServletContext().getRequestDispatcher("/admin_home.jsp").forward(request, response);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReviewServlet at " + request.getContextPath() + "</h1>");
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
