<%-- 
    Document   : create_review
    Created on : 15-Nov-2013, 9:40:39 PM
    Author     : Satyam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a Review</title>
    </head>
    <body>
        <h1>Begin to review Doctor</h1>
        <form method="post" action="ReviewServlet?type=insert">
            <p> <%=request.getParameter("doctor") %> </p>
            <% String docLogin = request.getParameter("doctor"); 
                request.getSession().setAttribute("docLogin", docLogin); %>
            Comments<input type="text" name="comments"><br>
            <label for="stars">Rating</label>
                    <select name="stars" id="stars" class="selectpicker">
                        <option value=""></option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select><br><br>
            <input type="submit" value="Submit Query">
        </form>
    </body>
</html>
