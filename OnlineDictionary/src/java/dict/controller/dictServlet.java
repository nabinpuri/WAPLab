/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.controller;

import dict.model.DbConnection;
import dict.model.WordData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *simple.JSONArray;
import org.json.simple.JSONObject;

 * @author Nabin
 */
public class dictServlet extends HttpServlet {

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
            out.println("<title>Servlet dictServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dictServlet at " + request.getContextPath() + "</h1>");
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
        PrintWriter pw = response.getWriter(); 
        try{
            DbConnection db= new DbConnection();
            System.out.println("Connected to database...");
             response.setContentType("application/json;charset=utf-8");
             String word=request.getParameter("findby");
            List<String> list= db.getWordsMatch(word);
             JSONArray arr= new JSONArray();
            for(String d:list){
                JSONObject json = new JSONObject();
                json.put("word",d);
                arr.add(json);
            }
             pw.print(arr.toString());
             pw.close();
        }
         catch(Exception e){
             System.out.println("Error...");
            // json.put("word", "Error");
             //pw.print(json.toString());
         }
       // processRequest(request, response);
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
        
        //JSONObject json = new JSONObject();
        PrintWriter pw = response.getWriter(); 
        //processRequest(request, response);
        try{
            DbConnection db= new DbConnection();
            System.out.println("Connected to database...");
             response.setContentType("application/json;charset=utf-8");
             String word=request.getParameter("word");
            List<WordData> list= db.getSearchResult(word);
             JSONArray arr= new JSONArray();
            for(WordData d:list){
                JSONObject json = new JSONObject();
                json.put("define",d.getDefinition());
                json.put("type",d.getType());
                
                arr.add(json);
            }
             pw.print(arr.toString());
             pw.close();
        }
         catch(Exception e){
             System.out.println("Error...");
            // json.put("word", "Error");
             //pw.print(json.toString());
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
