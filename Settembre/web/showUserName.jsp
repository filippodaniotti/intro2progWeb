<%-- 
    Document   : showUserName
    Created on : Jul 8, 2021, 6:39:08 PM
    Author     : Filippo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="index.css">
        <link rel="stylesheet" href="https://latemar.science.unitn.it/esameWeb/Libraries/bootstrap.min.4.5.0.css">
        
        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/bootstrap.min.4.5.0.js"></script>
        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/jquery.min.3.4.1.js"></script>
        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/popper.min.1.16.0.js"></script>
        <title>Show username</title>
    </head>
    <body class="main-container center">
        <h1>User in session is: <%= session.getAttribute("name")%></h1>
    </body>
</html>
