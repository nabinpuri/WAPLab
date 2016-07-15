/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nabin
 */
public class DbConnection {
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/entries";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   Connection conn;
   Statement stmt;
   
    public  DbConnection(){
        try{
      //STEP 2: Register JDBC driver
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("Connecting to database...");
          conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch (SQLException se){
            System.out.println("Error..."+se.getMessage());
        }
        catch(Exception e){
        }
    } 
    
    public List<WordData> getSearchResult(String word) throws SQLException{
        List<WordData> list= new ArrayList<WordData>();
        String query="select * from entries where word='"+word+"'";
        Statement st=conn.createStatement();
        ResultSet rs= st.executeQuery(query);
        WordData wordDef;
        while (rs.next()) {
            String type=rs.getString("wordtype");
            String definition=rs.getString("definition");
            wordDef= new WordData(definition,type);
            list.add(wordDef);

        }
        return list;
    }
    
    public List<String> getWordsMatch(String word) throws SQLException{
        List<String> words= new ArrayList<String>();
         String query="select word from entries where word like '"+ word+"%' group by word";
        Statement st=conn.createStatement();
        ResultSet rs= st.executeQuery(query);
        WordData wordDef;
        while (rs.next()) {
            String eachWord=rs.getString("word");
            words.add(eachWord);

        }
        return words;
    }
}
