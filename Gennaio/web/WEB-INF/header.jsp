<%
    String user = (String)session.getAttribute("user");
%>

<nav class="navbar navbar-dark bg-dark">
    <span style="color: white">ALLOGGI</span>
    <span class="spacer"></span>
    <span style="color: white"><%= user %></span>
    <a href="/Gennaio/Logout" style="color: white; margin-left: 3rem">Dimenticami</a>
</nav>