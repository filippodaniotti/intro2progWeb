<%-- 
    Document   : clearSession
    Created on : Jul 9, 2021, 11:53:34 AM
    Author     : Filippo
--%>

<%
    session.invalidate();
%>

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
        <title>Clear Session</title>
    </head>
    <body class="main-container center">
        <h1>Session has been invalidated, you will be redirect to the welcome page</h1>
        
        <script>
            $(document).ready(function() {
                setTimeout(function() {
                    window.location.replace('/');
                }, 3000);
            });
                
        </script>
    </body>
</html>
