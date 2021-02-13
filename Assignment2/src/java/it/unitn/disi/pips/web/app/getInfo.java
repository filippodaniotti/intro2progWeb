/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.pips.web.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Filippo
 */
@WebServlet(name = "getInfo", urlPatterns = {"/getInfo"})
public class getInfo extends HttpServlet {
    
    
    private String dbURL = "jdbc:derby://localhost:1527/LibraryDB";
    private String user = "pips";
    private String password = "puabadoa";
    public Connection conn = null;
    
    @Override
    public void init()
          throws ServletException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void destroy() {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private String retrieveObject() {
        return null;
    }

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
            throws ServletException, IOException, SQLException {
        response.setContentType("application/json;charset=UTF-8");
        
        String q = "'\"";
        String title = request.getParameter("title");
        StringBuffer json = new StringBuffer("{");
        
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM BOOKS WHERE TITLE='" + title + "';";
            ResultSet result = stmt.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                json.append(q).append(rsmd.getColumnClassName(i)).append("\":");
                json.append(q).append(result.getString(i)).append(q).append(",");
            }
            json.append("}");
        } catch (SQLException ex) {
            json.append("}");
        }
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println(json);
            
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
        processRequest(request, response);
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
