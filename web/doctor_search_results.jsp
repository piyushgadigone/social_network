<%-- 
    Document   : doctor_search_results
    Created on : 14-Nov-2013, 1:09:26 AM
    Author     : Satyam
--%>

<%@page import="social_network.Doctor"%>
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

    <title>Doctor home</title>

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
      <h3>Search Results</h3><br>
      <%
         ArrayList<Doctor> doctorList = (ArrayList<Doctor>) request.getAttribute("listOfDoctors");
         for (social_network.Doctor result : doctorList) {
       %> 
            <h4><%= result.getFirstName() + "  " + result.getLastName()%></h4>
            <span>Specialization: </span>
            <i>
            <%
                ArrayList<String> specialisations = result.getSpecialisations();
                String delim = "";
                String print = "";
                for (String specialisation : specialisations ) {
                    print += delim;
                    print += specialisation;
                    delim = ", ";

                    out.print("</td><td>");

                }
                out.print(print);
            %>
            </i><br>
            <span>Gender: <i><%= result.getGender() %></i> </span><br>
      <%
           out.print("<a href=\"ProfileServlet?page=2&doctor=" + result.getLogin() + "\">View full profile</a>");           
           out.print("<a style=\"padding-left:15px\" href=\"create_review.jsp?doctor=" + result.getLogin() + "\">Review Doctor</a>");
         }
      %>       

    </div> <!-- /container -->
    <br>
    <div class="footer">
        <p>&copy; Medicare 2013</p>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
