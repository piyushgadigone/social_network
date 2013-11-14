<%-- 
    Document   : patient_view_for_admin
    Created on : 13-Nov-2013, 9:36:50 PM
    Author     : Satyam
--%>

<%@page import="social_network.Patient"%>
<%@page import="social_network.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient view for Administrator</title>
    </head>
    <body>
        <h1>Patient View for Administrator</h1>
         <%! ArrayList<Review> reviewList;%>
    <% reviewList = (ArrayList<Review>) request.getAttribute("listOfReviews");%>
    <%
            if (reviewList != null) {
                out.println("<h2>Reviews Given</h2>");
                out.println("<table border=1>");
                out.println("<tr><th>Doctor Reviewed</th><th>Comments</th><th>Rating</th><th>Date</th></tr>");
                for (Review rev : reviewList) {
                    out.println("<tr><td>");
                    out.print(rev.getDoctorLogin());
                    out.print("</td><td>");
                    out.print(rev.getComments());
                    out.print("</td><td>");
                    out.print(rev.getRating());
                    out.print("</td><td>");
                    out.print(rev.getDatetime());
                }
                out.println("</table>");
            } else {
                out.println("<p>Null</p>");
            }
        %>
        </br>
        <%! ArrayList<Patient> friendsList;%>
    <% friendsList = (ArrayList<Patient>) request.getAttribute("listOfFriends");%>
    <%
            if (friendsList != null) {
                out.println("<h2>Friends Added</h2>");
                out.println("<table border=1>");
                out.println("<tr><th>Name</th><th>Email Address</th></tr>");
                for (Patient frnd : friendsList) {
                    out.println("<tr><td>");
                    out.print(frnd.getFirstName() + " " + frnd.getMiddleName() + " " + frnd.getLastName());
                    out.print("</td><td>");
                    out.print(frnd.getEmailAddress());
                }
                out.println("</table>");
            } else {
                out.println("<p>Null</p>");
            }
        %>
    </body>
</html>
