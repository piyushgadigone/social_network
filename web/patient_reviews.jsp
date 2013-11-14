<%-- 
    Document   : patient_profile
    Created on : 12-Nov-2013, 12:00:58 AM
    Author     : Yash Malik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="social_network.Review"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
        <jsp:useBean id="patient" class="social_network.Patient" scope="request"/>
        <h1>Profile Information for <%= session.getAttribute("login") %></h1>
        <p>
            <%!ArrayList<Review> reviewList;%>
            <%= reviewList = patient.getReviewsMade() %>
            <%
                for (Review review : reviewList) {
            %>
            Reviewer login: <%= review.getPatientLogin()%><br>
            Doctor: <%= review.getDoctorLogin()%><br>
            rating: <%= review.getRating()%><br>
            comments: <%= review.getComments()%><br>
            <%
                }
            %>           
        </p>
    </body>
</html>
