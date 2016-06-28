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
        <form method='POST' action='QuizServlet'>
            <% Quiz q = (Quiz)request.getAttribute("quiz");%> 
            <div style="border:1px solid blue; width:500px; float: left; padding-left: 10px;
                 padding-bottom: 5px; padding-top: 5px">
                <div style="background-color:whitesmoke; height:10%">
                <label>Enter Your age First: </label> 
                <input type="text" name="age" value="<%=(String)request.getAttribute("age")%>"
                       size='5'/>
                <% if(request.getAttribute("message")!= null){%>
                <div style="color:red">
                 <%= (String) request.getAttribute("message")%>
                 </div>
                 <%}%>
            </div>
            <h1><strong>The number Quiz</strong></h1> 
            <p>Your current Score is &nbsp <%= q.getCurrentScore()%></p> 
            <p>Guess the Number in Sequence</p> 
            <p> &nbsp <%= (String)request.getAttribute("questions")%>
                <Strong style="color:red">,?</Strong>&nbsp]</p> 
            <div> 
                <strong> Your answer is:</strong> 
                <input type=number name=answer value=0 size=5 required="required"/> 
                <br> 
                <br> 
                <% if(request.getAttribute("wrongmessage")!= null){%>
             <div style="color:red">
              <%= ((String) request.getAttribute("wrongmessage"))%>
              </div>
             <%}%>
                <input type=submit name=submit value="Next" /> 
                &nbsp
                &nbsp
                <input type=button name=submit value="Hint" 
                       onclick="alert('<%= q.getCurrentHint()%>')" /> 
            </div> 
        </div> 
        </form> 

    </body> 
</html>
