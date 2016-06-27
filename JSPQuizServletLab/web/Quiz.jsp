<%-- 
    Document   : Quiz
    Created on : Jun 27, 2016, 4:47:38 PM
    Author     : 984984
--%>

<%@page import="quiz.model.classes.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html> 
    <head> 
        <title>Quiz</title> 
        <meta charset=UTF-8> 
        <meta name=viewport content=width=device-width, initial-scale=1.0> 
    </head> 
    <body> 
        <form method=POST action=quizServlet>
            <%!((Quiz)request.getAttribute("person"))) %> 
            <div style="border:1px solid blue; width:500px; float: left; padding-left: 10px; padding-bottom: 5px"> 
            <h1><strong>The number Quiz</strong></h1> 
            <p>Your current Score is &nbspscore</p> 
            <p>Guess the Number in Sequence</p> 
            <p> &nbspquestions</p> 
            <div> 
                <strong> Your answer is:</strong> 
                <input type=number name=answer value=0 size=5 required="required"/> 

                <br> 
                <br> 
                <input type=submit name=submit value=submit/> 
            </div> 
        </div> 
        </form> 

    </body> 
</html>;
