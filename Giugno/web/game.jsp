<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <title>Minesweeper</title>
    </head>
    <body>
        <h1>Areo <%= session.getAttribute("name")%></h1>
        <div>
            <table class="table table-bordered">
                <%
                    for (int i = 0; i < 9; ++i) {
                        out.println("<tr>");
                        for (int j = 0; j < 9; ++j) {
                            out.println("<td style='height: 50px; text-align: center;' class='table-light' id='cell_" + i + "_" + j + "' onClick='clickCell(" + i + "," + j + ")'>  </td>");
                        }
                        out.println("</tr>");
                    }
                %>
            </table>
        </div>
        <div>
            <form action="" method="GET">
                <button type="submit" value="Test"></button>
                <select id="selectRow">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                </select>
                <select id="selectCol">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                </select>
            </form>
            <form action="GameInit">
                <button type="submit" value="Restart"></button>
            </form>

            <div id="demo">

            </div>
            
        </div>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="js/frontend.js"></script>
        <script>name = "<%= session.getAttribute("name")%>";</script>
    </body>
</html>
