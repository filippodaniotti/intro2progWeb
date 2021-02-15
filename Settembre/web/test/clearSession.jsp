<%-- 
    Document   : clearSession
    Created on : Feb 15, 2021, 11:46:35 AM
    Author     : Filippo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clear session</title>
    </head>
    <body>
        <%
            session.invalidate();
            out.println("<p>Session has been cleared</p>");
        %>
    </body>
</html>
