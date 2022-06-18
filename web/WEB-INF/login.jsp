<%-- 
    Document   : login
    Created on : Jun 17, 2022, 6:36:48 PM
    Author     : Matt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Account Login</h1>
        <form action="" method="POST">
            <label>Username:</label>
            <input type="text" name="username" value="${username}">
            <br>
            <label>Password:</label>
            <input type="text" name="password" value="${password}">
            <br>
            <input type="submit" value="Login">
            
        </form>
        <p>${message}</p>
    </body>
</html>
