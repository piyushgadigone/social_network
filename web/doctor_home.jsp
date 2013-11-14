<%-- 
    Document   : home_page
    Created on : 10-Nov-2013, 12:44:55 AM
    Author     : Satyam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <jsp:useBean id="doctor" class="social_network.Doctor" scope="request"/>
        Hey Doctor, <%= request.getSession().getAttribute("login") %><br/>
        <a href="DoctorServlet?page=profile">Profile</a>
        <a href="LogoutServlet">Logout</a>
        <h1>Reviews</h1>
            <%
                for (social_network.Review review : doctor.getReviews()) {
            %>
            Reviewer login: <%= review.getPatientLogin()%><br>
            Doctor: <%= review.getDoctorLogin()%><br>
            rating: <%= review.getRating()%><br>
            comments: <%= review.getComments()%><br>
            Date/Time: <%= review.getDatetime()%><br>
            <%
                }
            %> 
            </br></br>
    </body>
</html>