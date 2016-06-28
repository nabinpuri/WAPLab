<%-- 
    Document   : index
    Created on : Jun 28, 2016, 1:49:00 PM
    Author     : 984984
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
    <h1 align=”center”>Beer Selection Page</h1>
    <form method="POST" action="SelectBeer.do">
        Select beer characteristics<p>
        Color:
            <select name="color" size="1">
            <option value="light"> light </option>
            <option value="amber"> amber </option>
            <option value="brown"> brown </option>
            <option value="dark"> dark </option>
        </select>
        <br><br>
        <center style="float:left">
            <input type="SUBMIT">
        </center>
    </form>
    </body>
</html>