<%-- 
    Document   : patient_list
    Created on : 12-Nov-2013, 10:44:41 PM
    Author     : Satyam
--%>

<%@page import="social_network.Doctor"%>
<%@page import="social_network.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Search for Administrators</title>
    </head>
    <body>
        <h1>List of Patients</h1>
        <%! ArrayList<Patient> patientList;%>
    <% patientList = (ArrayList<Patient>) request.getAttribute("listOfPatients");%>
    <%
            if (patientList != null) {
                out.println("<h1>Patient Data</h1>");
                out.println("<table border=1>");
                out.println("<tr><th>Login</th><th>Name</th><th>Email</th><th>View More</th></tr>");
                for (Patient pat : patientList) {
                    out.println("<tr><td>");
                    out.print(pat.getLogin());
                    out.print("</td><td>");
                    out.print(pat.getFirstName() + " " + pat.getLastName());
                    out.print("</td><td>");
                    out.print(pat.getEmailAddress());
                    out.print("</td><td>");
                    String patLogin = pat.getLogin();
                    out.print("<a href=\"ProfileServlet?page=1&patient=" + patLogin + "\">Additional Information</a>");
                }
                out.println("</table>");
            } else {
                out.println("<p>Null</p>");
            }
        %>
        <h1>List of Doctor</h1>
        <%! ArrayList<Doctor> doctorList;%>
    <% doctorList = (ArrayList<Doctor>) request.getAttribute("listOfDoctors");%>
    <%
            if (patientList != null) {
                out.println("<h1>Doctor Data</h1>");
                out.println("<table border=1>");
                out.println("<tr><th>Login</th><th>Name</th><th>Gender</th><th>View More</th></tr>");
                for (Doctor doc : doctorList) {
                    out.println("<tr><td>");
                    out.print(doc.getLogin());
                    out.print("</td><td>");
                    out.print(doc.getFirstName() + " " + doc.getMiddleName() + " " + doc.getLastName());
                    out.print("</td><td>");
                    out.print(doc.getGender());
                    out.print("</td><td>");
                    String docLogin = doc.getLogin();
                    out.print("<a href=\"ProfileServlet?page=2&doctor=" + docLogin + "\">Additional Information</a>");
                }
                out.println("</table>");
            } else {
                out.println("<p>Null</p>");
            }
        %>
    </body>
</html>
