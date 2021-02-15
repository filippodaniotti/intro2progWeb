<%-- 
    Document   : showCoppia
    Created on : Feb 15, 2021, 11:46:25 AM
    Author     : Filippo
--%>

<%@page import="it.unitn.disi.pips.web.app.Coppia"%>
<%@page import="it.unitn.disi.pips.web.app.MappaDiCoppie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Coppia</title>
    </head>
    <body>
        <h1>Show coppia</h1>
        <p>User is <%= session.getAttribute("user")%></p>
        <%
            String user = (String)session.getAttribute("user");
            MappaDiCoppie map = (MappaDiCoppie)application.getAttribute("map");
            Coppia c;
            for (String key : map.keySet()) {
                c = map.get(key);
                if (user.equals(c.getFirst()) || user.equals(c.getSecond())){
                    out.println("<p>They belong to Coppia: " + key + "</p>");
                    break;
                }
            }
        %>
    </body>
</html>
