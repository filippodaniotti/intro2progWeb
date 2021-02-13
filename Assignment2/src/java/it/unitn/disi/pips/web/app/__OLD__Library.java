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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pips
 */
@WebServlet(name = "Library", urlPatterns = {"/Library"})
public class __OLD__Library extends HttpServlet {

    // Prepare db connection information
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

        HttpSession session = ((HttpServletRequest)request).getSession(false);

        response.setContentType("text/html;charset=UTF-8");
//        StringBuffer dbOutput = new StringBuffer("");
        ArrayList<String> titles = new ArrayList<>();
        
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM BOOKS";
            ResultSet results = stmt.executeQuery(query);
            ResultSetMetaData md = results.getMetaData();
            while (results.next()) {
//                for (int i = 1; i <= md.getColumnCount(); ++i) {
//                    dbOutput.append(results.getString(i)).append("<br>");
//                }
//                dbOutput.append("<br>");
                titles.add(results.getString("TITLE"));
            }
        } catch (SQLException ex) {
//            dbOutput.append(" </h1>");
        }

        try (PrintWriter out = response.getWriter()) {
             request.getRequestDispatcher("page-1.html").include(request, response);
            out.println("<div class=\"sidebar\">");
            out.println("<ul class=\"list-group-flush\">");
            for (String title : titles) {
                out.println("<li class=\"list-group-item\">");
                out.println(title);
                out.println("</li>");
            }
            out.println("</div></ul>");
             request.getRequestDispatcher("page-2.html").include(request, response);
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
