<%-- 
    Document   : HomeView
    Created on : Jul 5, 2021, 11:15:55 AM
    Author     : Filippo
--%>

<%@page import="it.unitn.disi.filippo.beans.ItemBean"%>
<%@page import="it.unitn.disi.filippo.beans.ItemBeanList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="index.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Catalogo</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <jsp:useBean id="activeItems" class="it.unitn.disi.filippo.beans.ItemBeanList" scope="request"/>
        <div class="main-container">
            <% for (ItemBean item : activeItems) {%>
            <p>
                <a href="/2021_Giugno/DetailController?id=<%= item.getID() %>">
                    <%= item.getTitle()%>
                </a>
                <br/>
                Attuale miglior prezzo: <%= item.getCurrentPrice() %>
                <br/>
                Scade il: <%= item.getDeadline()%>
            </p>
            <hr>
            <% }%>
        </div>
    </body>
</html>
