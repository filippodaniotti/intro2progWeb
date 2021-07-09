<%-- 
    Document   : game
    Created on : Jul 8, 2021, 4:43:30 PM
    Author     : Filippo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="it.unitn.disi.filippo.commons.Coppia"%>
<%@page import="it.unitn.disi.filippo.commons.MappaDiCoppie"%>
<%
    String key = (String) session.getAttribute("gameKey");
    MappaDiCoppie map = (MappaDiCoppie) application.getAttribute("map");
    Coppia current = map.get(key);

    ArrayList<String> wordList = null;
    String user = (String) session.getAttribute("name");
    if (user.equals(key)) {
        wordList = current.getList1();
    } else {
        wordList = current.getList2();
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="index.css">

        <script src="js/game.js"></script>
        <link rel="stylesheet" href="https://latemar.science.unitn.it/esameWeb/Libraries/bootstrap.min.4.5.0.css">

        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/popper.min.1.16.0.js"></script>
        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/jquery.min.3.4.1.js"></script>
        <script src="https://latemar.science.unitn.it/esameWeb/Libraries/bootstrap.min.4.5.0.js"></script>
        <title>Game</title>
    </head>
    <body>
        <div class="main-container">
            <h1>Il gioco</h1>
            <div class="row">
                <div class="main-container column">
                    <img src="<%=current.getImage()%>" alt="image" width="500" height="400">
                    <hr/>
                    <div class="input-group" id="wordField">
                        <input class="form-control" id="word" placeholder="Type your word" autofocus>
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="button" onclick="sendWord('<%=key%>', '<%=user%>')">Go!</button>
                        </span>
                    </div>
                </div>
                <div class="main-container column">
                    <h3>Current words</h3>
                    <hr>
                    <ul id="wordList">
                        <%for (String word : wordList) {%>
                            <li><%=word%></li>
                        <%}%>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
