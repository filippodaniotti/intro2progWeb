<%@page import="java.util.ArrayList"%>
<%@page import="it.unitn.disi.pips.web.app.MessageQueue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/reader.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <title>Reader</title>
    </head>
    <body>        
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-6">
                    <h1 class="text-center">Ciao, lettore!</h1>
                    <table class="table table-bordered table-striped">
                        <thead class="thead-light">
                            <tr>
                                <th colspan="6">
                                    Aggiornamenti
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Object queue = application.getAttribute("queue");
                                
                                if (queue == null) {
                                    out.println("<tr><td>nessun servizio disponibile ora.</tr></td>");
                                } else {
                                    
                                    int counter = (int)session.getAttribute("count");
                                    int diff = ((MessageQueue)queue).size() - counter;
                                    
                                    if (diff == 0) {
                                        out.println("<tr><td>Niente di nuovo al momento.</tr></td>");
                                    } else {
                                        ArrayList<String> msgs = ((MessageQueue)queue).getLastNMsg(diff);
                                        
                                        for (String msg : msgs) {
                                            out.println("<tr id=\"" + (counter + 1) +"\">");
                                            out.println("<td colspan=\"1\">" + (++counter) + "</td>");
                                            out.println("<td colspan=\"5\" class=\"msg\">" + msg + "</td>");
                                            out.println("</tr>");
                                        }
                                        session.setAttribute("count", counter);
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                        <div class="fomr-inline">
                            <input type="text" class="form-control" id="textbar">
                            <button type="button" class="btn btn-dark" onclick="changeTimeout();">Cambia refresh rate</button>
                        </div>
                </div>
            </div>
        </div>

                        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
        
        <script>
            $(document).ready(highlight);
            $(document).ready(setRR);
        </script>
    </body>
</html>
