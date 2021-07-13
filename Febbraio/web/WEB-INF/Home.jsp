<%-- 
    Document   : Home
    Created on : Jul 12, 2021, 7:23:59 PM
    Author     : Filippo
--%>

<%@page import="it.unitn.disi.filippo.util.Config"%>
<% int games = Integer.parseInt((String) request.getAttribute(Config.activeGames)); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome to sudoku by Filippo Daniotti</h1>
        <img src="https://www.thesprucecrafts.com/thmb/xpQkE_t0ID7fRlYQ85VFAgWo18E=/3000x2000/filters:fill%28auto,1%29/sudoku-puzzle-160233854-5b05a8028e1b6e0036b7bcb2.jpg" width="600" height="400">
        <% if (games > 0) {%>
        <ul>
            <%for (int i = 1; i <= games; ++i) {%>
            <li><a href="/Febbraio/Game?id=<%=i%>">Sudoku no.<%=i%></a></li>
            <%}%>
        </ul>
        <%} else {%>
        <p>No active games were found, retry later</p>
        <%}%>
    </body>
</html>
