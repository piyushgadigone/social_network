<%-- 
    Document   : doctor_profile
    Created on : 12-Nov-2013, 1:50:15 AM
    Author     : Yash Malik
--%>
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
          <li><a href="LoginServlet">Home</a></li>
          <li class="active"><a href="PatientServlet?page=profile">Profile</a></li>
          <li><a href="PatientServlet?page=reviews">Reviews</a></li>
          <li><a href="PatientServlet?page=friends">Friends</a></li>
          <li><a href="PatientServlet?page=watch">Watch</a></li>
          <li><a href="LogoutServlet">Logout</a></li>
        </ul>
        <h3 class="text-muted">Medicare</h3>
      </div>
      <div>
      <h3>Profile</h3>
      <jsp:useBean id="patient" class="social_network.Patient" scope="request"/>
        <p> 
            <span class="profilelabel">Login: </span><%= patient.getLogin()%></br>
            <span class="profilelabel">Name: </span> 
              <%= patient.getFirstName() + " " + patient.getMiddleName() + " " + patient.getLastName() %><br/>
            <span class="profilelabel">Email-address: </span> <%= patient.getEmailAddress()%>
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
