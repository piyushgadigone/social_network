<%-- 
    Document   : add_friend_servlet
    Created on : 15-Nov-2013, 7:41:53 PM
    Author     : Satyam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Added a new Friend</title>
    </head>
    <body>
        
        <h3>You are now friends with <%= request.getSession().getAttribute("login") %>!  </h3>
        <%
        out.print("<a href='ProfileServlet?page=1&patient=" + request.getSession().getAttribute("login") + "'/>View Profile</a>");
        %>
    </body>
</html>
