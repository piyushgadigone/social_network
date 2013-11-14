<%-- 
    Document   : patient_profile
    Created on : 12-Nov-2013, 12:00:58 AM
    Author     : Yash Malik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
        <jsp:useBean id="patient" class="social_network.Patient" scope="request"/>
        <h1>Profile Information for <%= session.getAttribute("login") %></h1>
        <p> Name: <%= patient.getFirstName() + " " + patient.getMiddleName() + " " + patient.getLastName() %><br/>
            Email address: <%= patient.getEmailAddress() %><br/>
        </p>
    </body>
</html>