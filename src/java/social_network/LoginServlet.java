/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package social_network;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Satyam
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        try {
            boolean validLogin = true;
            
            String login;
            String password = "";
            if (request.getSession().getAttribute("login") == null) {
                validLogin = false;
                login = request.getParameter("login");
                password = request.getParameter("password");
            } else {
                login = request.getSession().getAttribute("login").toString();
            }
            Authentication authentication = new Authentication();
            authentication.setLogin(login);
            authentication.setPassword(password);
            
            try {
                if(validLogin || AuthenticationDBAO.isValidLogin(authentication)) {
                    if (PatientDBAO.isPatient(authentication.getLogin())) {
                        session.setAttribute("login", authentication.getLogin());
                        request.getServletContext().getRequestDispatcher("/patient_home.jsp").forward(request, response);
                    } else if(DoctorDBAO.isDoctor(authentication.getLogin())) {
                        session.setAttribute("login", authentication.getLogin());
                        Doctor doctor = DoctorDBAO.getDoctorInfo(authentication.getLogin());
                        request.setAttribute("doctor", doctor);
                        request.getServletContext().getRequestDispatcher("/doctor_home.jsp").forward(request, response);
                    }  else if(AdminDBAO.isAdmin(authentication.getLogin())) {
                        session.setAttribute("login", authentication.getLogin());
                        Admin curAdmin = null;
                        try {
                            curAdmin = AdminDBAO.getAdminInfo(request.getSession().getAttribute("login").toString());
                        } catch (SQLException ex) {
                            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        session.setAttribute("admin", curAdmin);
                        request.getServletContext().getRequestDispatcher("/admin_home.jsp").forward(request, response);
                        
                    }
                }
                else {
                    request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
