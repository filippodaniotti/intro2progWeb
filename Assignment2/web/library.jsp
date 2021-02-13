<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! 
    // Prepare db connection information
    private String dbURL = "jdbc:derby://localhost:1527/LibraryDB";
    private String user = "pips";
    private String password = "puabadoa";
    public Connection conn = null;
    
    public void jspInit() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void jspDestroy(  ) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }


    private ArrayList<String> getTitles() {
        ArrayList<String> titles = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM BOOKS";
            ResultSet results = stmt.executeQuery(query);
            ResultSetMetaData md = results.getMetaData();
            while (results.next()) {
//                for (int i = 1; i <= md.getColumnCount(); ++i) {
//                    dbOutput.append(results.getString(i)).append("<br>");
//                }
//                dbOutput.append("<br>");
                titles.add(results.getString("TITLE"));
            }
        } catch (SQLException ex) {
//            dbOutput.append(" </h1>");
        }
        return titles;
    }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>MyLibrary</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="./js/library.js"></script>
    <link rel="stylesheet" href="./css/style.css"/>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />
  </head>
  <body>
      
      <div class="container-fluid newconwidth">
      <div class="row">
        <div class="title">
          <% out.print("<h1>Questa è la libreria di " + session.getAttribute("username") + "</h1>"); %>
        </div>
      </div>
      <div class="row">
        <div class="col-2" style="height: 100%;">
          <div class="sidebar">
            <ul class="list-group-flush">
              <%
                  ArrayList<String> titles = getTitles();
                  for (String t : titles) {
                      out.println("<div class=\"d-grid gap-2\"></div>");
                      out.println("<button class=\"btn btn-outline-dark\" type=\"button\" \"getDetails()\">" + t + "</button>");
                      out.println("</li>");
                  }
              %>
              <div id="demo"></div>
            </ul>
          </div>
        </div>
        <div class="col" style="background-color: antiquewhite">
          <div class="row" style="background-color: aquamarine">
            <div class="col">

            </div>
            <div class="col">
              <h5 id="author"></h5>
              <h3 id="title"></h3>
              <p id="description"></p>
            </div>
          </div>
          <div class="row" style="background-color: bisque">
            <div class="col">obj1</div>
            <div class="col">obj2</div>
            <div class="col">obj3</div>
            <div class="col">obj4</div>
            <div class="col">obj5</div>
          </div>
        </div>
      </div>
    </div>
      
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
      integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
      integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
