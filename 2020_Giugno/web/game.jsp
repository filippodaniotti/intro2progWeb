<%-- 
    Document   : game
    Created on : Jul 4, 2021, 12:54:00 AM
    Author     : Filippo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game</title>
        <link rel="stylesheet" href="index.css">
        <script src="index.js"></script>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body class="text-center" style="padding: 20px">
        <h1>Hello 
            <%= session.getAttribute("username") %>
        </h1>
        
        <table id="mainTable">
            <% 
                for (int i = 0; i < 9; ++i) {
                    out.println("<tr>");
                    for (int j = 0; j < 9; ++j) {
                        String xy = "" + i + j;
                        out.println("<td id=\"" + xy + "\" class=\"cell\" onclick=\"clickCell("+i+","+j+")\"></td>");
                    }                    
                    out.println("</tr>");
                }
            %>
        </table>
        
        <button class="btn btn-md btn-primary button" onclick="resetGame()">Reset</button>
        <button class="btn btn-md btn-primary button" onclick="handleTestButton()">Test</button>
        <select id="row">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
        </select>
        
        <select id="column">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
        </select>
        
    </body>
</html>
