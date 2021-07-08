<%-- 
    Document   : C
    Created on : Jul 7, 2021, 5:04:10 PM
    Author     : Filippo
--%>

<%@page import="it.unitn.disi.filippo.beans.RentBean"%>
<%@page import="it.unitn.disi.filippo.beans.RentsList"%>
<%
    String kind = (String) request.getAttribute("kind");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="C.js"></script>
        <link rel="stylesheet" href="index.css">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <title>C</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <jsp:useBean id="rents" class="it.unitn.disi.filippo.beans.RentsList" scope="request"/>

        <div class="main-container">
            <p>
            <h3><%= kind%></h3>
            <span class="spacer"></span>
            <button class="btn btn-primary" type="button" onclick="changeKind()">Scegli un'altra categoria</button>
        </p>
        <hr/>

        <div class="btn-group" role="group" aria-label="Basic outlined example">
            <% for (RentBean rent : rents) {%>
            <button type="button" class="btn btn-outline-primary" onclick="show(this)"><%= rent.getName()%></button>
            <%}%>
        </div>

        <hr/>

        <div class="hidden" id="detailTable">
            <table>
                <tr>
                    <td>
                        <table>
                            <tr>
                                <th>Nome</th>
                                <td id="rName"></td>
                            </tr>
                            <tr>
                                <th>Prezzo</th>
                                <td id="rPrice"></td>
                            </tr>
                            <tr>
                                <th>Punteggio</th>
                                <td id="rScore"></td>
                            </tr>
                            <tr>
                                <th id="hExtra"></th>
                                <td id="rExtra"></td>
                            </tr>

                        </table>
                    </td>
                    <td><img id="rImage" alt="Rent image"/></td>
                </tr>
            </table>
        </div>

    </div>



    <script>
        $(document).ready(function () {
            kind = "<%=(String) request.getAttribute("kind")%>";
            let current;
            let name;
            let price;
            let score;
            let extra;
            let image;
        <% for (RentBean rent : rents) {%>
            name = "<%=rent.getName()%>";
            price = "<%=rent.getPrice()%>";
            score = "<%=rent.getScore()%>";
            extra = "<%=rent.getExtra()%>";
            image = "<%=rent.getImage()%>";
            current = {
                name: name,
                price: price,
                score: score,
                extra: extra,
                image: image
            };
            rentsList.push(current);
        <%}%>
        });
    </script>



</body>
</html>
