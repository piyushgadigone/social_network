<%-- 
    Document   : doctor_profile
    Created on : 12-Nov-2013, 1:50:15 AM
    Author     : Yash Malik
--%>

<%@page import="social_network.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Doctor profile</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/jumbotron-narrow.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <style type="text/css">
      
      .profilelabel {
	color:#999;
	text-align:right;
	vertical-align:top;
	white-space:nowrap;
    }

  </style>
  <body>

    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="PatientServlet?page=profile">Profile</a></li>
          <li><a href="PatientServlet?page=reviews">Reviews</a></li>
          <li><a href="PatientServlet?page=friends">Friends</a></li>
          <li><a href="LogoutServlet">Logout</a></li>
        </ul>
        <h3 class="text-muted">Medicare</h3>
      </div>
      <div style="height: 800px;">
      <h3>Profile</h3>
      <jsp:useBean id="doctor" class="social_network.Doctor" scope="request"/>
        <p> <span class="profilelabel">Login</span> <%= doctor.getLogin() %><br/>
            <span class="profilelabel">Name:</span> <%= doctor.getFirstName() + " " + doctor.getMiddleName() + " " + doctor.getLastName() %><br/>
            <span class="profilelabel">Gender:</span> <%= doctor.getGender() %><br/>
            <span class="profilelabel">Date of Birth:</span> <%= doctor.getDob()%></br>
            <span class="profilelabel">License Year:</span><%= doctor.getLicenceYear()%></br>
            <span class="profilelabel">Specialization:</span>
            <% 
                String delim = "";
                String print = "";
                for (String specialisation : doctor.getSpecialisations() ) {
                    print += delim;
                    print += specialisation;
                    delim = ", ";

                    out.print("</td><td>");
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
        <h3>Reviews</h3>
        <p>
      <div class="row ">
          <div class="col-lg-6" style="width:80%">
            <%
               ArrayList<Review> reviewList;
               reviewList = (ArrayList<Review>) request.getAttribute("listOfReviews");
               for (social_network.Review review : reviewList) {
            %>
                      <h4><%= review.getPatientLogin()%> gave you <%= review.getRating()%> stars</h4>
                      <p><i><%= review.getDatetime()%></i></p>
                      <p><%= review.getComments()%></p>
            <%
               }
            %> 
          </div>
          </br></br>
      </div>
            
        </p>
      </div>

    </div> <!-- /container -->
    <div class="footer">
        <p>&copy; Medicare 2013</p>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>

