<%-- 
    Document   : reviews_search
    Created on : 15-Nov-2013, 6:53:30 PM
    Author     : Piyush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reviews Search</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css" />
        <script>
        $(function() {
          $( "#datepicker" ).datepicker();
        });
        $(function() {
          $( "#datepicker2" ).datepicker();
        });
        </script>
    </head>
    <body>
        <h1>Search for Reviews</h1>
        <form method="post" action="AdminSearchServlet">
            Doctor Login: <input type="text" name="doctor_login"><br>
            Patient Login: <input type="text" name="patient_login"><br>
            Comments: <input type="text" name="comments"><br>
            Minimum Rating: 
            <select name="min_rating">
                 <option value=""></option>
                 <option value="1">1</option>
                 <option value="2">2</option>
                 <option value="3">3</option>
                 <option value="4">4</option>
                 <option value="5">5</option>
            </select><br>
            Maximum Rating: 
            <select name="max_rating">
                 <option value=""></option>
                 <option value="1">1</option>
                 <option value="2">2</option>
                 <option value="3">3</option>
                 <option value="4">4</option>
                 <option value="5">5</option>
            </select><br>
            Minimum Date: <input type="text" id="datepicker" name="min_date" /><br>
            Maximum Date: <input type="text" id="datepicker2" name="max_date" /><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
