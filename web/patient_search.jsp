<%-- 
    Document   : home_page
    Created on : 10-Nov-2013, 12:44:55 AM
    Author     : Yash Malik
--%>
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

    <title>Search</title>

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
      <form method="post" action="SearchServlet" class="query-form block-centered">
            <div class="well well block-centered">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control block-centered" name="username" id="username" placeholder="Enter Username">
                </div>
                <div class="form-group" style="float: left; width:48%">
                    <label for="firstname">First Name</label>
                    <input type="text" class="form-control block-centered" name="firstname" id="firstname" placeholder="Enter First Name">
                </div>
                <div class="form-group" style="float: right; width:48%">
                    <label for="lastname">Last Name</label>
                    <input type="text" class="form-control block-centered" name="lastname" id="lastname" placeholder="Enter Last Name">
                </div>
                <div class="form-group" style="float: left;">
                    <label for="gender">Gender</label>
                    <select name="gender" id="gender" class="selectpicker">
                        <option value="">Both</option>
                        <option value="m">Male</option>
                        <option value="f">Female</option>
                    </select>
                </div>
                
                <div class="form-group" style="float: left; padding-left: 20px;">
                    <label for="stars">Minimum Star Rating</label>
                    <select name="stars" id="stars" class="selectpicker">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
                
                <div class="form-group" style="float: left; padding-left: 20px; padding-right: 30px">
                    <label for="stars">Minimum years of experience</label>
                    <select name="stars" id="stars" class="selectpicker">
                        <option value="0">1</option>
                        <option value="1">2</option>
                        <option value="2">4</option>
                        <option value="3">4</option>
                        <option value="4">5</option>
                        <option value="5">10</option>
                    </select>
                </div>

                <div>
                    <p>Works at:</p>
                </div>

                <div class="form-group">
                    <label for="street">Street Name</label>
                    <input type="text" class="form-control block-centered" name="street" id="street" placeholder="Enter Street Name">
                </div>
                <div class="form-group">
                    <label for="street">City</label>
                    <input type="text" class="form-control block-centered" name="street" id="city" placeholder="Enter City">
                </div>

                <div class="form-group">
                    <label for="postalCode">Postal Code</label>
                    <input type="text" maxlength="6" class="form-control block-centered" name="postalCode" id="postalCode" placeholder="Enter Postal Code">
                </div>
                
                <div class="form-group">
                    <label for="province">Province</label>
                    <select class="selectpicker" name="province" id="province" >
                        <option>ON</option>
                        <option>QC</option>
                        <option>BC</option>
                        <option>AB</option>
                        <option>MB</option>
                        <option>SK</option>
                        <option>NS</option>
                        <option>NB</option>
                        <option>NL</option>
                        <option>PE</option>
                        <option>NT</option>
                        <option>YT</option>
                        <option>NY</option>
                    </select>
                </div>

                <div class="form-group">
                    <input type="checkbox" name="recommended"> Recommended By a Friend.
                </div>

                <button type="submit" class="btn btn-default ">Submit</button>
            </div>
        </form>
    </div> <!-- /container -->
    <div class="footer">
        <p>&copy; Medicare 2013</p>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>