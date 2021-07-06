<% String username = (String) session.getAttribute("username");
    String logout = "";
    String login = "";
    String user = "";
    if (username != null) {
        user = "<span style=\"color:white\">" + username + "</span>";
        logout = "<a href=\"/2021_Giugno/Logout\" style=\"color:white; margin-left:2rem\">Logout</a>";
    } else {
        login = "<a href=\"/2021_Giugno/login.html\" style=\"color:white\">Login</a>";
    }
%>

<nav class="navbar navbar-dark bg-dark">
    <span style="color:white; margin-right: 10px">ASTE</span>
    <a href="/2021_Giugno/HomeController" style="color:white; margin-right: 5px">Aperte</a>
    <a href="/2021_Giugno/SoldController" style="color:white">Terminate</a>
    <span class="spacer"></span>
    <%= user %>
    <%= logout %>
    <%= login %>
</nav>