/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreachdemo.servlet;

/**
 *
 * @author 984984
 */
import foreachdemo.bean.Student;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class TableServlet extends HttpServlet
{
    static final long serialVersionUID = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse
    response)
    throws IOException, ServletException
    {
        Student[] table = new Student[]
        {
        new Student("bob", 23),
        new Student("jill", 33),
        new Student("kim", 18)
        };
        request.setAttribute("students", table);
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("table.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse
    response)
    throws IOException, ServletException
    {
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("table.jsp");
        dispatcher.forward(request, response);
    }
}

