<%-- 
    Document   : doctor_profile
    Created on : 12-Nov-2013, 1:50:15 AM
    Author     : Piyush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Profile</title>
    </head>
    <body>
        <jsp:useBean id="doctor" class="social_network.Doctor" scope="request"/>
        <h1>Profile Information for <%= session.getAttribute("login") %></h1>
        <p> Name: <%= doctor.getFirstName() + " " + doctor.getMiddleName() + " " + doctor.getLastName() %><br/>
            Gender: <%= doctor.getGender() %><br/>
            Date of Birth: <%= doctor.getDob()%></br>
            License Year: <%= doctor.getLicenceYear()%></br>
            Specialization: 
            <% 
                    for(String s : doctor.getSpecialisations()) {
                        %>
                        <%= s + ", "%>
                        <%
                    }
            %></br>
            Address: </br>
            <% 
                    for(social_network.Address a : doctor.getAddresses()) {
                        %>
                        <%= a.prettyPrint()%></br>
                        <%
                    }
            %></br>
        </p>
    </body>
</html>
