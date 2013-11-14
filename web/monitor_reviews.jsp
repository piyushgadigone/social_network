<%-- 
    Document   : monitor_reviews
    Created on : 12-Nov-2013, 11:53:11 PM
    Author     : Satyam
--%>

<%@page import="social_network.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monitor Reviews</title>
    </head>
    <body>
        <h1>List of Reviews</h1>
        <%! ArrayList<Review> reviewsList;%>
    <% reviewsList = (ArrayList<Review>) request.getAttribute("listOfReviews");%>
    <%
            if (reviewsList != null) {
                out.println("<h1>Patient Data</h1>");
                out.println("<table border=1>");
                out.println("<tr><th>Patient</th><th>Doctor</th><th>Comments</th></tr>");
                for (Review rev : reviewsList) {
                    out.println("<tr><td>");
                    out.print(rev.getPatientLogin());
                    out.print("</td><td>");
                    out.print(rev.getDoctorLogin());
                    out.print("</td><td>");
                    out.print(rev.getComments());
                }
                out.println("</table>");
            } else {
                out.println("<p>Null</p>");
            }
        %>
    </body>
</html>
