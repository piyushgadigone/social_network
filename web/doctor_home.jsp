<%-- 
    Document   : home_page
    Created on : 10-Nov-2013, 12:44:55 AM
    Author     : Yash
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

    <div class="container" style="min-height: 550px;">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="DoctorServlet?page=profile">Profile</a></li>
          <li><a href="LogoutServlet">Logout</a></li>
        </ul>
        <h3 class="text-muted">Medicare</h3>
      </div>
      <jsp:useBean id="doctor" class="social_network.Doctor" scope="request"/>
      <div class="jumbotron">
        <h1>The medical network</h1>
        <p class="lead">
            <%= request.getSession().getAttribute("login") %>, welcome to the network of all networks!
        </p>
      </div>
      <div class="row marketing">
          <div class="col-lg-6" style="width:80%">
            <%
               for (social_network.Review review : doctor.getReviews()) {
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

    </div> <!-- /container -->
    <div class="footer">
        <p>&copy; Medicare 2013</p>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>