/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.servlets;

import it.unitn.disi.filippo.util.Config;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Filippo
 */
public class Game extends HttpServlet {

    Connection conn = null;

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
        String view = "/";
        String id = request.getParameter("id");
        if (id == null) {
            view += "Home";
            response.sendRedirect(view);
        } else {
            view += "WEB-INF/Game.jsp";
            try {
                Statement st = conn.createStatement();
                String query = "select FIXEDCELLS, SOLUTION from DATA where ID=" + id;
                ResultSet rs = st.executeQuery(query);
                String[] result = null;
                String[] solution = null;
                HashMap<String, String> fixedCellMap = new HashMap<>();

                // retrieve fixed cells
                while (rs.next()) {
                    result = rs.getString("FIXEDCELLS").split("\\s");
                    solution = rs.getString("SOLUTION").split("\\s");
                }
                
                ArrayList<String> cells = new ArrayList<>();
                for (int i = 0; i < result.length; ++i) {
                    cells.add(result[i]);
                }
                
                // Get solution for fixed cells
                int x = 0;
                int y = 0;
                String current = null;
                for (String cell : cells) {
                    x = Character.getNumericValue(cell.charAt(0)) - 1;
                    y = Character.getNumericValue(cell.charAt(1)) - 1;
                    current = solution[x*9 + y];
                    fixedCellMap.put(cell, current);
                }
                
                request.setAttribute(Config.fixedCells, cells);
                request.setAttribute(Config.fixedCellsMap, fixedCellMap);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            request.getRequestDispatcher(view).forward(request, response);
        }

    }

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(Config.dbURL, Config.user, Config.pw);
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
