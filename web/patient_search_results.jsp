<%-- 
    Document   : doctor_profile
    Created on : 12-Nov-2013, 1:50:15 AM
    Author     : Yash Malik
--%>
<%@page import="social_network.Patient"%>
<%@page import="java.util.ArrayList"%>
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

    <div class="container" style="min-height: 550px;">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="PatientServlet?page=home">Home</a></li>
          <li><a href="PatientServlet?page=profile">Profile</a></li>
          <li><a href="PatientServlet?page=reviews">Reviews</a></li>
          <li><a href="PatientServlet?page=friends">Friends</a></li>
          <li><a href="PatientServlet?page=watch">Watch</a></li>
          <li><a href="LogoutServlet">Logout</a></li>
        </ul>
        <h3 class="text-muted">Medicare</h3>
      </div>
      
      <div>
      <h3>Search Results</h3><br>
      <%
         ArrayList<Patient> results = (ArrayList<Patient>) request.getAttribute("patientSearchResults");
         if (results.size() == 0) {
             out.print("<i>Your query didn't match our database.</i>");
         }
         for (social_network.Patient result : results) {             
            String friendLogin = result.getLogin();
       %>
            <h4><%= result.getFirstName() + "  " + result.getLastName()%></h4>
            <p><i><%= result.getEmailAddress() %></i></p>
      <%
        if(!result.isIsFriend())
            out.print("<a href=\"AddFriendServlet?friendLogin=" +  friendLogin + "\">Add Friend</a>");
         }
      %> 

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
