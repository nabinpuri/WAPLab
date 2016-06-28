/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quiz.model.classes.Quiz;

/**
 *
 * @author 984984
 */
@WebServlet(name = "QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuizServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        String age= request.getParameter("age");
        String message=validateAge(age);
        request.setAttribute("age", age);
        if(message.equals("goodTOGo")){
            Quiz quiz= new Quiz();
            String question= quiz.getNextQuestion();
            request.setAttribute("questions", question);
            request.setAttribute("quiz", quiz);  
            s.setAttribute("quiz", quiz);
            
             RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
             dispatch.forward(request, response);
        }
        else{
            RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
            request.setAttribute("message", message);
             dispatch.forward(request, response);
        }
    }
   private String validateAge(String age){
       String msg="goodTOGo";
       try{
           int ages= Integer.parseInt(age);
           
           if(ages<4 || ages>100){
               msg="Age must be between 4 and 100";
           }
       }
       catch(Exception e){
           msg="Enter only Number";
       }
       finally{
           return msg;
       }
   }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession s = request.getSession();
            Quiz quiz = (Quiz) s.getAttribute("quiz");
            request.setAttribute("",quiz);
            
            String age= request.getParameter("age");
            String message=validateAge(age);
            request.setAttribute("age", age);
            
            if(!message.equals("goodTOGo")){//check age
                request.setAttribute("message", message);
                String question= quiz.getCurrentQuestion();
                request.setAttribute("questions", question);
                request.setAttribute("quiz", quiz); 
                s.setAttribute("quiz", quiz);
                RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
                dispatch.forward(request, response);
            }
            else{
                 if(quiz==null){
                    quiz= new Quiz();
                }
                else if(quiz.getCurrentTryNo()<3){//check if already tried 3

                    int answer= Integer.parseInt(request.getParameter("answer")) ;
                    
                    boolean verified=quiz.verifyAnswer(answer);//currentTryNoIncreases here

                    if(verified){//check if answer correct
                        gotoNextQUestion(quiz,request,response,s);
                    }
                    if(!verified && quiz.getCurrentTryNo()<3){//check if chance left
                        String wrongmessage= "your  answer is wrong "+(3-quiz.getCurrentTryNo()+" chance remaining");
                        request.setAttribute("wrongmessage", wrongmessage);
                        String question= quiz.getCurrentQuestion();
                        request.setAttribute("questions", question);

                        request.setAttribute("quiz", quiz); 
                        s.setAttribute("quiz", quiz);
                        RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
                        dispatch.forward(request, response);
                    }
                    else if(!verified && quiz.getCurrentTryNo()==3){//check if last try
                        String wrongmessage= "You have tried all 3 times. The correct answer is "
                                + quiz.getCorrectAnswer();
                        request.setAttribute("wrongmessage", wrongmessage);
                        String question= quiz.getCurrentQuestion();
                        request.setAttribute("questions", question);
                        
                        request.setAttribute("quiz", quiz); 
                        s.setAttribute("quiz", quiz);
                        RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
                        dispatch.forward(request, response);
                    }
                }
                else{
                    quiz.setCurrentTryNo(0);
                    gotoNextQUestion(quiz,request,response,s);
                }
            }
           
            
        //processRequest(request, response);
    }
    
     private void gotoNextQUestion(Quiz quiz,HttpServletRequest request, HttpServletResponse response,HttpSession s) 
             throws ServletException,IOException {
                if(quiz.hasNext()){
                 String question= quiz.getNextQuestion();
                 request.setAttribute("quiz", quiz); 
                 request.setAttribute("questions", question);
                 //String hint= quiz.getCurrentHint();
                 //request.setAttribute("hint", hint);
                 s.setAttribute("quiz", quiz);
                 RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
                 dispatch.forward(request, response);
                //out.print(page);
                }
                else{
                    quiz.setQuizEnded(true);
                 request.setAttribute("quiz", quiz);  
                 RequestDispatcher dispatch = request.getRequestDispatcher("FinalPage.jsp");
                 dispatch.forward(request, response);
                
            }
    }
        

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
