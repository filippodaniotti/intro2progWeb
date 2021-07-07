<%-- 
    Document   : DetailView
    Created on : Jul 6, 2021, 5:16:58 PM
    Author     : Filippo
--%>


<%@page import="java.util.Date"%>
<%@page import="it.unitn.disi.filippo.beans.ItemBean"%>
<%@page import="it.unitn.disi.filippo.beans.ItemBeanList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="index.css">
        <script src="detail.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Aste Terminate</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <jsp:useBean id="item" class="it.unitn.disi.filippo.beans.ItemBean" scope="request"/>
        <div class="main-container">
            <h1>
                <%= item.getTitle()%>
            </h1>
            <hr/>

            <p>
                <%= item.getDescription()%>
            </p>
            <br/>

            Miglior prezzo: <%= item.getCurrentPrice()%>
            <br/>

            <% if ((Boolean)request.getAttribute("isAuctionOn")) {%>
                <% if ((Boolean)request.getAttribute("isBestOfferer")) {%>
                <p>ATTUALMENTE SEI IL MIGLIOR OFFERENTE</p><br/>

                <% } else {%>

                Miglior offerente: <%= item.getBestOfferer()%>
                <br/>

                <form action="" method="POST">
                    <label for="offer">Fai un'offerta</label>
                    <input type="text" id="offer" onchange="isInt()"><br/>
                    <span id="error" class="text-danger"></span>
                    <br/>
                    <button class="btn btn-primary" id="submitOffer" onclick="isInt()" disabled>Lancia offerta</button>
                </form>
                <%}%>
                Tempo rimasto: <span id="time"><%= (item.getDeadline().getTime() - new Date().getTime()) / 1000%></span>
            <% } else { %> 
                <p>L'oggetto è stato venduto</p>
                <% if ((Boolean)request.getAttribute("isBestOfferer")) {%>
                    <p>Ti sei aggiudicato l'asta!</p>
                <%}%>
            <%}%>
            <br/>
        </div>
        <script>
            $(document).ready(function () {
                bestOffer = <% item.getCurrentPrice();%>
                <% if ((Boolean)request.getAttribute("isAuctionOn")) {%>
                setInterval(wallclock, 1000);
                setInterval(update, 10000);
                <%}%>
            });
        </script>

    </body>
</html>


