<%-- 
    Document   : showCoppia
    Created on : Jul 8, 2021, 11:19:00 PM
    Author     : Filippo
--%>

<%@page import="it.unitn.disi.filippo.commons.MappaDiCoppie"%>
<%@page import="it.unitn.disi.filippo.commons.Coppia"%>
<%@page import="java.util.HashMap"%>
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
        <title>Show coppia</title>
    </head>
    <body class="main-container center">
        <%MappaDiCoppie map = (MappaDiCoppie)application.getAttribute("map");
            if (map.containsKey(application.getAttribute("name"))) {%>
            <h1>Current coppia: <%= map.get(session.getAttribute("name"))%></h1>  
        <%} else {%>
            <h1>No coppia in MappaDiCoppie</h1>                
        <%}%>
    </body>
</html>
