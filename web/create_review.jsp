<%-- 
    Document   : create_review
    Created on : 10-Nov-2013, 12:44:55 AM
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

    <title>Doctor home</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrapform.min.css" rel="stylesheet">

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

    <div class="container" style="height: 500px;">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="PatientServlet?page=home">Home</a></li>
          <li><a href="PatientServlet?page=profile">Profile</a></li>
          <li><a href="PatientServlet?page=reviews">Reviews</a></li>
          <li><a href="PatientServlet?page=friends">Friends</a></li>
          <li><a href="LogoutServlet">Logout</a></li>
        </ul>
        <h3 class="text-muted">Medicare</h3>
      </div>
        
      <form class="form-horizontal" action="ReviewServlet?type=insert" method="post">
       <%
          String docLogin = request.getParameter("docLogin");
          request.getSession().setAttribute("docLogin", docLogin);     
       %>
       <fieldset>

       <!-- Form Name -->
       <legend>Doctor Review</legend>

       <!-- Text input-->
       <div class="control-group">
         <label class="control-label" for="name">Doctor login</label>
         <div class="controls">
           <input id="name" name="name" type="text" value="<%=docLogin%>" class="input-xlarge" readonly>
         </div>
       </div>

       <!-- Textarea -->
       <div class="control-group">
         <label class="control-label input-large" for="comments">Comments</label>
         <div class="controls">                     
           <textarea style="width: 270px; height: 55px" id="comments" name="comments"></textarea>
         </div>
       </div>

       <!-- Select Basic -->
       <div class="control-group">
         <label class="control-label" for="stars">Rating</label>
         <div class="controls">
           <select id="stars" name="stars" class="input-small">
             <option>1</option>
             <option>2</option>
             <option selected="selected">3</option>
             <option>4</option>
             <option>5</option>
           </select>
         </div>
       </div>
       
       <!-- Button -->
        <div class="control-group">
          <label class="control-label" for=""></label>
          <div class="controls">
            <button type="submit" id="" name="" class="btn btn-success">Submit </button>
          </div>
        </div>

       </fieldset>
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