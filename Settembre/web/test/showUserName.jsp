<%-- 
    Document   : showUsername
    Created on : Feb 15, 2021, 11:45:43 AM
    Author     : Filippo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Username</title>
    </head>
    <body>
        <p><%= session.getAttribute("user")%></p>
    </body>
</html>
