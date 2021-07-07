<%-- 
    Document   : login
    Created on : Jul 7, 2021, 11:01:57 AM
    Author     : Filippo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="index.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    </head>
    <body class="text-center">
        <form action="/2021_Giugno/Login" method="POST" class="form-signin center">
            <div class="form-group card">
                <label for="username">Username</label>
                <input type="text" name="username" placeholder="Your username" class="form-control formInput" required autofocus>
                <label for="password">Password</label>
                <input type="password" name="password" placeholder="Your password" class="form-control formInput" required autofocus>
                <button type="submit" class="btn btn-primary btn-block">Authenticate</button>
            </div>
        </form>
        <% if(request.getContextPath() == "/Auth") { %>
        <p>
            Le credenziali
        </p>
        <% } %>
    </body>
</html>
