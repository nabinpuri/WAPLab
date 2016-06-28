<%-- 
    Document   : beeradvise
    Created on : Jun 28, 2016, 1:49:57 PM
    Author     : 984984
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <body>
    <form method="POST" action="SelectBeer.do">
        <h1><strong>Beer Selection Advice</strong></h1>
        <h3><br><strong>Try: </strong></h3><br>
        <table style="border:2px solid black;">
            <tr>
                <th style="border:2px solid black;">Brands</th>
            </tr>
            <c:forEach var="advise" items="${results}">
            <tr style="border:2px solid black;">
                <td style="color:blue; border:2px solid black;">${advise}</td>
            </tr>
                </c:forEach>
        </table>
    </form>
    </body>
</html>
