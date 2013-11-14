<%-- 
    Document   : index
    Created on : 9-Nov-2013, 10:16:06 PM
    Author     : Satyam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPRaY Network</title>
    </head>
    <body>
        <h1>Welcome to the SPRaY Network!</h1>
        <form method="post" action="LoginServlet">
            First name: <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
