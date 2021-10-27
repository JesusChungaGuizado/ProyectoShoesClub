<%-- 
    Document   : Menu
    Created on : 25-oct-2021, 12:16:52
    Author     : Jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Object[]fil=(Object[])session.getAttribute("SesionCliente"); %>
        <%= fil[0] %>
        <%= fil[1] %>
        <%= fil[2] %>
        <%= fil[3] %>
        <%= fil[4] %>
        <%= fil[5] %>
        <%= fil[6] %>
        <%= fil[7] %>
    </body>
</html>
