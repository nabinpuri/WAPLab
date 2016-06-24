/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs472.improvedClaculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 984984
 */
public class Calculator extends HttpServlet {

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
            out.println("<title>Servlet Calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Calculator at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String add1 = request.getParameter("add1");
        String add2 = request.getParameter("add2");
        String mul1 = request.getParameter("mul1");
        String mul2= request.getParameter("mul2");
        response.setContentType("text/html");
       String resultAdd="";
        String resultmul="";
        //out.print("test");
        int sum=0;
        if((!add1.equals(" "))&&(!add2.equals(" "))){
            if((!(add1.equals("")))&& (!add2.equals(""))){
            sum=Integer.parseInt(add1) + Integer.parseInt(add2);
            
           // request.setAttribute("add3",sum);
            }
             else{
            add1="&nbsp";
            add2="&nbsp";
            }
        }
        
        else{
            add1="&nbsp";
            add2="&nbsp";
        }
        String sums= sum==0?"&nbsp":""+sum;
        
        resultAdd="<input type=\"number\"  name=\"add3\" value="+sums+" /> ";
        int mul=0;
        if((!mul1.equals(" "))&& (!mul2.equals(" ")))
        {
          if((!mul1.equals(""))&& (!mul2.equals(""))){
            mul=Integer.parseInt(mul1)*Integer.parseInt(mul2);
            
            } 
          else{
            mul1="&nbsp";
            mul2="&nbsp";
        }
        }
        
        else{
            mul1="&nbsp";
            mul2="&nbsp";
        }
        String mult= mul==0?"&nbsp":""+mul;
        resultmul="<input type=\"number\"  name=\"mul3\" value="+mult+" /> ";
        
        
        String top="<html>\n" +
        "    <head>\n" +
        "        <title>Improved Calculator 1</title>\n" +
        "        <meta charset=\"UTF-8\">\n" +
        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "    </head>\n" +
        "    <body>\n" +
        "        <div>\n" +
        "            <form method=\"POST\" action=\"Calculator\">\n" +
        "                <div>" +
        "                    <input type=\"number\"  name=\"add1\" value="+add1+" />\n" +
        "                    <strong> + </strong>\n" +
        "                    <input type=\"number\"  name=\"add2\" value="+add2+" /> \n" +
        "                    <label> = </label>";

        
        String middle="  </div>\n" +
        "                <div style=\"margin-top: 5px\">\n" +
        "                    <input type=\"number\"  name=\"mul1\" value=" +mul1+" />  \n" +
        "                    <strong> * </strong>\n" +
        "                    <input type=\"number\"  name=\"mul2\" value=" +mul2+" /> \n" +
        "                    <label> = </label>";
        String bottom="</div >\n" +
        "                <input style=\"margin-top: 5px\" type=\"submit\" value=\"submit\"/>\n" +
        "            </form>\n" +
        "            \n" +
        "        </div>\n" +
        "    </body>\n" +
        "</html>";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(top+resultAdd+middle+resultmul+bottom);
        //response.sendRedirect(request.getHeader("referer"));
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
