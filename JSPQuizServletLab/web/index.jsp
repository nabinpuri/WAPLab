<%-- 
    Document   : index
    Created on : Jun 27, 2016, 4:29:39 PM
    Author     : 984984
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quiz</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method="GET" action="QuizServlet">
            <div style="border:1px solid blue; width:500px; float: left; padding-left: 10px; padding-bottom: 5px">
            <h1><strong>The number Quiz</strong></h1>
            <div>
                <label>Enter Your age First: </label> 
                <input type="text" name="age" value="" size='5'/>
            </div>
            
            <% if(request.getAttribute("message")!= null){%>
             <div style="color:red">
              <%= ((String) request.getAttribute("message"))%>
              </div>
             <%}%>
             
            
            <div>
                <input type="submit" name="submit" value="start"/>
            </div>
        </div>
        </form>
        
    </body>
</html>
