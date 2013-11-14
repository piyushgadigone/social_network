<%-- 
    Document   : home_page
    Created on : 10-Nov-2013, 12:44:55 AM
    Author     : Yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <jsp:useBean id="authentication" class="social_network.Authentication" scope="session"/>
        Hey patient, <%= authentication.getLogin() %><br/>
        <div>
            <a href="PatientServlet?page=profile">View Profile</a>
            <a href="PatientServlet?page=reviews">View Reviews</a>
            <a href="PatientServlet?page=friends">Friends</a>
            <a href="PatientServlet?page=logout">Logout</a>
        </div>
    </body>
</html>
