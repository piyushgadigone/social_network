<%-- 
    Document   : admin_review_search_results
    Created on : 15-Nov-2013, 8:10:27 PM
    Author     : Piyush
--%>

<%@page import="social_network.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reviews Search Results</title>
    </head>
    <body>
        <h1>Reviews Search Results</h1>
        <%! ArrayList<Review> reviewsList;%>
    <% reviewsList = (ArrayList<Review>) request.getAttribute("reviewsSearchResults");%>
    <%
            if (reviewsList != null && reviewsList.size() > 0) {
                out.println("<table border=1>");
                out.println("<tr><th>Patient</th><th>Doctor</th><th>Comments</th><th>Ratings</th><th>Date/Time</th><th></th></tr>");
                for (Review rev : reviewsList) {
                    out.println("<tr><td>");
                    out.print(rev.getPatientLogin());
                    out.print("</td><td>");
                    out.print(rev.getDoctorLogin());
                    out.print("</td><td>");
                    out.print(rev.getComments());
                    out.print("</td><td>");
                    out.print(rev.getRating());
                    out.print("</td><td>");
                    out.print(rev.getDatetime());
                    out.print("</td><td>");
                    out.print("<a href=\"");
                    out.print("ReviewServlet?type=delete&patient_login="+rev.getPatientLogin()+"&doctor_login="+rev.getDoctorLogin()+"&datetime="+rev.getDatetime());
                    out.print("\">Delete</a>");
                }
                out.println("</table>");
            } else {
                out.println("<p>No reviews with given search parameters found.</p>");
            }
        %>
    </body>
</html>
