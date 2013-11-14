<%-- 
    Document   : doctor_search_results
    Created on : 14-Nov-2013, 1:09:26 AM
    Author     : Satyam
--%>

<%@page import="social_network.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Search Results</title>
    </head>
    <body>
        <h1>Doctor Search Results</h1>
        <%! ArrayList<Doctor> doctorList;%>
    <% doctorList = (ArrayList<Doctor>) request.getAttribute("listOfDoctors");%>
    <%
            if (doctorList != null) {
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
