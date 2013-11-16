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
        String url = null;
        try {
            boolean validLogin = true;
            
            String login;
            String password = "";
            if (request.getParameter("authenticate")!= null && request.getParameter("authenticate").equals("yes")) {
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
                boolean correctCredentials = AuthenticationDBAO.authenticate(authentication.getLogin(), authentication.getHashedPassword());
                //boolean correctCredentials = AuthenticationDBAO.isValidLogin(authentication);
                if(validLogin || correctCredentials) {
                    if (PatientDBAO.isPatient(authentication.getLogin())) {
                        session.setAttribute("login", authentication.getLogin());
                        session.setAttribute("role", "patient");
                        url = "/patient_home.jsp";
                    } else if(DoctorDBAO.isDoctor(authentication.getLogin())) {
                        session.setAttribute("login", authentication.getLogin());
                        session.setAttribute("role", "doctor");
                        Doctor doctor = DoctorDBAO.getDoctorInfo(authentication.getLogin());
                        request.setAttribute("doctor", doctor);
                        url = "/doctor_home.jsp";
                    }  else if(AdminDBAO.isAdmin(authentication.getLogin())) {
                        session.setAttribute("login", authentication.getLogin());
                        session.setAttribute("role", "admin");
                        Admin curAdmin = null;
                        try {
                            curAdmin = AdminDBAO.getAdminInfo(request.getSession().getAttribute("login").toString());
                        } catch (SQLException ex) {
                            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        session.setAttribute("admin", curAdmin);
                        url = "/admin_home.jsp";
                    }
                }
                else if (correctCredentials == false){
                    url = "/index.jsp";
                    request.setAttribute("incorrect_credentials", "yes");
                }
                else {
                    url = "/index.jsp";
                }
            } catch (Exception e) {
                request.setAttribute("exception", e);
                url = "/error.jsp";
            }
            
            getServletContext().getRequestDispatcher(url).forward(request, response);
            
            
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
