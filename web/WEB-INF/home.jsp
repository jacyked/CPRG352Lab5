<%-- 
    Document   : home
    Created on : Jun 17, 2022, 6:37:04 PM
    Author     : Matt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello ${username}</h1>
        <p>
            <a href="/MyLogin/login?logout='true'" name="logout">Log Out</a>
        </p>
        
    </body>
</html>
