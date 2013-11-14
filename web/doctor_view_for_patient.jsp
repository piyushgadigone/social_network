<%-- 
    Document   : doctor_view_for_patient
    Created on : 13-Nov-2013, 11:21:58 PM
    Author     : Satyam
--%>

<%@page import="social_network.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor View for Patient</title>
    </head>
    <body>
        <h1>Doctor View for Patient</h1>
        <jsp:useBean id="doctor" class="social_network.Doctor" scope="request"/>
        <p> <span class="profilelabel">Name:</span> <%= doctor.getFirstName() + " " + doctor.getMiddleName() + " " + doctor.getLastName() %><br/>
            <span class="profilelabel">Gender:</span> <%= doctor.getGender() %><br/>
            <span class="profilelabel">License Year:</span><%= doctor.getLicenceYear()%></br>
            <span class="profilelabel">Specialization:</span>
            <% 
                    for(String s : doctor.getSpecialisations()) {
                        %>
                        <%= s + ", "%>
                        <%
                    }
            %></br>
            <span class="profilelabel">Address:</span> </br>
            <% 
                    for(social_network.Address a : doctor.getAddresses()) {
                        %>
                        <%= a.prettyPrint()%></br>
                        <%
                    }
            %></br>
        </p>
          <%! ArrayList<Review> reviewList;%>
    <% reviewList = (ArrayList<Review>) request.getAttribute("listOfReviews");%>
    <%
            if (reviewList != null) {
                out.println("<h2>Reviews Given</h2>");
                out.println("<table border=1>");
                out.println("<tr><th>Patient Who Reviewed</th><th>Comments</th><th>Rating</th><th>Date</th></tr>");
                for (Review rev : reviewList) {
                    out.println("<tr><td>");
                    out.print(rev.getPatientLogin());
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
    </body>
</html>
