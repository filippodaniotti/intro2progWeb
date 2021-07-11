<%-- 
    Document   : Viewer
    Created on : Jul 10, 2021, 3:30:00 PM
    Author     : Filippo
--%>
<%
    boolean none = Boolean.parseBoolean((String)request.getAttribute("none"));
%>

<%@page import="it.unitn.disi.filippo.beans.MessageQueue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/viewer.js"></script>
        <link rel="stylesheet" href="main.css">        
        <link rel="stylesheet" type="text/css" href="https://latemar.science.unitn.it/esameWeb/Libraries/bootstrap.min.4.5.0.css">
        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/jquery.min.3.4.1.js"></script>
        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/popper.min.1.16.0.js"></script>
        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/bootstrap.min.4.5.0.js"></script>
        <title>Webcasting</title>
    </head>
    <body>
        <div class="main-container text-center">
            <jsp:useBean id="messages" class="it.unitn.disi.filippo.beans.MessageQueue" scope="request"/>
            <%if (!none) {%>
            <%if (messages.size() > 0) {%>
            <table>
                <th>Aggiornamenti</th>
                <%for (String msg : messages) {%>
                <tr><td id="<%=messages.indexOf(msg)%>"><%=msg%></td></tr>
                    <%}%>
            </table>
            <%} else {%>
            <h2>Niente di nuovo al momento</h2>
            <%}%>
            <button class="btn btn-primary" onclick="readAll()">View all messages</button>
            <%} else {%>
            <h2>Nessun evento attivo</h2>
            <%}%>
            <br>
            <input id="rate" type="text" placeholder="<%=request.getAttribute("rate")%>">
        </div>

        <script>
            $(document).ready(function () {
                messageCount = "<%=messages.size()%>";
                if (messageCount && messageCount > 0) {
                    highlight();
                }
                refreshRate = "<%=request.getAttribute("rate")%>";
                window.history.replaceState({}, "", "Viewer");
                refresh();
            });
        </script>
    </body>
</html>
