<%-- 
    Document   : Game
    Created on : Jul 12, 2021, 11:26:22 PM
    Author     : Filippo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="it.unitn.disi.filippo.util.Config"%>
<%
    ArrayList<String> cells = (ArrayList<String>) request.getAttribute(Config.fixedCells);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="game.css">
        <script src="game.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <title>Game</title>
    </head>
    <body>
        <table>
            <%for (int i = 0; i < 9; ++i) {%>
            <tr>
                <%for (int j = 0; j < 9; ++j) {%>
                <td><input 
                        type="text" 
                        id="<%=i+1%><%=j+1%>" 
                        class="<%= (Config.isRed(i, j) ? "rose" : "blue")%>"
                        onchange="checkInput('<%=i%>', '<%=j%>')">
                </td>
                <%}%>
            </tr>
            <%}%>
        </table>
        <label for="row">Righa:</label>
        <input id="row" name="row">
        <label for="col">Colonna:</label>
        <input id="col" name="col">
        <button onclick="checkCell()">Verifica</button>

        <script>
            $(document).ready(function () {
            <%if (cells == null) {%>
                window.alert("Error in generated game, you will be redirected to home");
                setTimeout(function () {
                    window.location.replace('/Febbraio');
                }, 2000);
            <%} else {%>
                <%for (String cell : cells) {%>
                    fixedCells.push('<%=cell%>');
                <%}%>
                 initialize();
            <%}%>
            });
        </script>
    </body>
</html>
