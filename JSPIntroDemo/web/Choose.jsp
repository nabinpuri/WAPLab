<%-- 
    Document   : Choose
    Created on : Jun 27, 2016, 3:30:31 PM
    Author     : 984984
--%>

<html>
 <head>
 <title>Choose</title>
 </head>
 <body>
    <form method='post' action='ChooseServlet'>
        <p>Is JSP cool?</p>
        <input type='radio' value='1' name='radioJSPCool' 
               ${statejspcool.yesCheck == 'True'? 'checked':''}>
               <span>Yes</span><br/>
        <input type='radio' value='0' name='radioJSPCool'
               ${statejspcool.noCheck == 'True'? 'checked':''}>
        <span>No</span><br/>
        <input type='submit' name='btnSubmit' value='Submit'/>
        <p>Is JSF way cool?</p>
        <input type='radio' value='1' name='JSFwayCool'
               ${stateJSFwayCool.yesCheck == 'True'? 'checked':''}>
        <span>Yes</span><br/>
        <input type='radio' value='0' name='JSFwayCool'
               ${stateJSFwayCool.noCheck == 'True'? 'checked':''}>
        <span>No</span><br/>
        <input type='submit' name='btnSubmit' value='Submit'/>
        <p>Is the moon made of cheese?</p>
        <input type='radio' value='1' name='moonCheese'
               ${statemoonCheese.yesCheck == 'True'? 'checked':''}>
        <span>Yes</span><br/>
        <input type='radio' value='0' name='moonCheese'
               ${statemoonCheese.noCheck == 'True'? 'checked':''}>
        <span>No</span><br/>
        <input type='submit' name='btnSubmit' value='Submit'/>
    </form>
 </body>
 </html>


