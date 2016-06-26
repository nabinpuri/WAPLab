/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quiz.business.Quiz;

/**
 *
 * @author Nabin
 */
public class quizServlet extends HttpServlet {

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
            out.println("<title>Servlet quizServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet quizServlet at " + request.getContextPath() + "</h1>");
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
            Quiz quiz ;
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            quiz= new Quiz();
                
            if(quiz.hasNext()){
                String question= quiz.getNextQuestion();
                s.setAttribute("quiz", quiz);
                String score=String.valueOf(quiz.getCurrentScore());
                String page=createQuizPage(question,score);
                out.print(page);
            }
            else{
                String score=String.valueOf(quiz.getCurrentScore());
                out.print(createFinalPage(score));
                
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
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if(quiz==null){
                quiz= new Quiz();
            }
            else{
                int answer= Integer.parseInt(request.getParameter("answer")) ;
                quiz.verifyAnswer(answer);
                
            }
            if(quiz.hasNext()){
                String question= quiz.getNextQuestion();
                s.setAttribute("quiz", quiz);
                String score=String.valueOf(quiz.getCurrentScore());
                String page=createQuizPage(question,score);
                out.print(page);
            }
            else{
                String score=String.valueOf(quiz.getCurrentScore());
                out.print(createFinalPage(score));
                
            }
            
            
            
    }

    private String createQuizPage(String questions,String score){
        
        String page="<html>\n" +
                "    <head>\n" +
                "        <title>Quiz</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <form method=\"POST\" action=\"quizServlet\">\n" +
                "            <div style=\"border:1px solid blue; width:500px; float: left; padding-left: 10px; padding-bottom: 5px\">\n" +
                "            <h1><strong>The number Quiz</strong></h1>\n" +
                "            <p>Your current Score is &nbsp"+score+"</p>\n" +
                "            <p>Guess the Number in Sequence</p>\n" +
                "            <p> &nbsp"+questions+"</p>\n" +
                "            <div>\n" +
                "                <strong> Your answer is:</strong>\n" +
                "                <input type=\"number\" name=\"answer\" value=\"0\"size=\"5\"/>\n" +
                "                \n" +
                "                <br>\n" +
                "                <br>\n" +
                "                <input type=\"submit\" name=\"submit\" value=\"submit\"/>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        </form>\n" +
                "        \n" +
                "    </body>\n" +
                "</html>";
        
        return page;
    }
    
    private String createFinalPage(String score){
        String page="<html>\n" +
                "    <head>\n" +
                "        <title>Quiz</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <form method=\"POST\" action=\"quizServlet\">\n" +
                "            <div style=\"border:1px solid blue; width:500px; float: left; padding-left: 10px; padding-bottom: 5px\">\n" +
                "            <h1><strong>The number Quiz</strong></h1>\n" +
                "            <p>Your current Score is &nbsp"+score+"</p>\n" +
                "            <div>\n" +
                "            <p>You have Completed the Number Quix with a score &nbsp"+score+"&nbspout of 5</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        </form>\n" +
                "        \n" +
                "    </body>\n" +
                "</html>";
        return page;
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
