<%-- 
    Document   : showContext
    Created on : Feb 15, 2021, 11:46:17 AM
    Author     : Filippo
--%>

<%@page import="it.unitn.disi.pips.web.app.WaitingRoom"%>
<%@page import="it.unitn.disi.pips.web.app.MappaDiCoppie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            WaitingRoom room = (WaitingRoom)application.getAttribute("wRoom");
            MappaDiCoppie map = (MappaDiCoppie)application.getAttribute("map");
            String sRoom = room.toString();
            String sMap = map.toString();
            out.println("<h1>Waiting room</h1>");
            out.println(sRoom);
            out.println("<h1>Mappa</h1>");
            out.println(sMap);
        %>
    </body>
</html>
