<%-- 
    Document   : PostMessage
    Created on : Jun 27, 2016, 2:03:13 PM
    Author     : 984984
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Introduction to JSP demo – postback page </title>
    </head>
    <body>
        <%! int count = 0; %>
        The count is now:
        <%= ++count %>

        <%-- This is a jsp scriptlet that increments the count --%>
        <!-- This is an html comment inserted by the increment comment -->
        <% count = count * 10; %>
        The count is now:
        <%= count %>

        </body>
</html>

