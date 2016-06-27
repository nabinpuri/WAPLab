/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspIntro.servlet;

/**
 *
 * @author 984984
 */
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jspIntro.Classes.RasdioState;
public class ChooseServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse
   response)
    throws ServletException, IOException
    {
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
    response)
    throws ServletException, IOException
    {
        RasdioState statejspcool= (RasdioState) request.getAttribute("statejspcool");
        RasdioState stateJSFwayCool= (RasdioState) request.getAttribute("stateJSFwayCool");
        RasdioState statemoonCheese= (RasdioState) request.getAttribute("statemoonCheese");
        if(statejspcool==null){
            statejspcool= new RasdioState();
        }
        if(stateJSFwayCool==null){
            stateJSFwayCool= new RasdioState();
        }
        if(statemoonCheese==null){
            statemoonCheese= new RasdioState();
        }
         
        String choice1 = request.getParameter("radioJSPCool");
        String choice2 = request.getParameter("JSFwayCool");
        String choice3 = request.getParameter("moonCheese");
        
        if (choice1 != null){
            statejspcool.setYesCheck(choice1.equals("1")?"True":"False");
            statejspcool.setNoCheck(choice1.equals("0")?"True":"False");
            request.setAttribute("statejspcool", statejspcool);
            
        }
        if (choice2 != null){
            stateJSFwayCool.setYesCheck(choice2.equals("1")?"True":"False");
            stateJSFwayCool.setNoCheck(choice2.equals("0")?"True":"False");
            request.setAttribute("stateJSFwayCool", stateJSFwayCool);
            
        }
        if (choice3 != null){
            statemoonCheese.setYesCheck(choice3.equals("1")?"True":"False");
            statemoonCheese.setNoCheck(choice3.equals("0")?"True":"False");
            request.setAttribute("statemoonCheese", statemoonCheese);
            
        }
        else{
            System.out.println("No choice made");
        }
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }
}
