<%-- 
    Document   : FinalPage
    Created on : Jun 27, 2016, 9:00:02 PM
    Author     : Nabin
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
             <% Quiz q = (Quiz)request.getAttribute("quiz");%> 
            <div style="border:1px solid blue; width:500px; float: left; padding-left: 10px; padding-bottom: 5px"> 
            <h1><strong>The number Quiz</strong></h1> 
            <p>Your current Score is &nbsp<%= q.getCurrentScore()%></p> 
            <div> 
            <p>You have Completed the Number Quiz with a score &nbsp<%= q.getCurrentScore()%>&nbspout of 50</p> 
            </div> 
            <div> 
                <p>Your final grade is:
                    <Strong style="color:red">&nbsp<%= q.getGrade()%></Strong></p> 
            </div> 
        </div> 
        </form> 

    </body> 
</html>
