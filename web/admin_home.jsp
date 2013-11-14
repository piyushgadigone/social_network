<%-- 
    Document   : admin_home
    Created on : 12-Nov-2013, 9:02:38 PM
    Author     : Satyam
--%>

<%@page import="social_network.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Home Page</title>
     <!--<script type="text/javascript">

      function activateTab(pageId) {
          var tabCtrl = document.getElementById('tabCtrl');
          var pageToActivate = document.getElementById(pageId);
          for (var i = 0; i < tabCtrl.childNodes.length; i++) {
              var node = tabCtrl.childNodes[i];
              if (node.nodeType == 1) { /* Element */
                  node.style.display = (node == pageToActivate) ? 'block' : 'none';
              }
          }
      }

    </script>-->
    </head>
    <body>
      <jsp:useBean id="admin" class="social_network.Admin" scope="session"/>
      
      <!--<h1>Welcome, <%= admin.getFirst_name()%></h1>-->
        <!--<ul>
      <li>
        <a href="javascript:activateTab('userSearch')">User Search</a>
      </li>
      <li>
        <a href="javascript:activateTab('monitorReviews')">Monitor Reviews</a>
      </li>
      <li>
          <a href="javascdript:activateTab('logout')">Logout</a>
      </li>
    </ul>-->
        
      <a href='AdminServlet?page=1'>User Search</a> </br>
      <a href='AdminServlet?page=2'>Monitor Reviews</a> </br>
      <a href='AdminServlet?page=3'>Logout</a> </br>
      <!--<div id="logout" style="display: none;">Logout</div>-->
    
  </body>
    
</html>


