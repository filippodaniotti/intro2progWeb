/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.servlets;

import it.unitn.disi.filippo.beans.RentsList;
import it.unitn.disi.filippo.util.Config;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Filippo
 */
public class C extends HttpServlet {

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
        String kind = request.getParameter("kind");
        if (kind == null || kind.equals("")) {
            view += "B";
        } else {
            view += "WEB-INF/C.jsp";
            request.setAttribute("kind", kind);
            int tipo = Config.getKind(kind);
            RentsList rents = new RentsList();
            
            try {
                Statement stmt = conn.createStatement();
                String query = "select * from ALLOGGI where TIPO="+tipo;
                ResultSet results = stmt.executeQuery(query);
                ResultSetMetaData md = results.getMetaData();
                
                List<String> beanData = new ArrayList<>();
                while (results.next()) {
                    for (int i = 1; i <= md.getColumnCount(); ++i) {
                        beanData.add(results.getString(i));
                    }
                    rents.addBean(beanData.toArray());
                    beanData.clear();
                }
                request.setAttribute("rents", rents);
            } catch (SQLException ex) {
            }

        }

        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    public void init()
            throws ServletException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver"); // Get the driver
            conn = DriverManager.getConnection(Config.dbURL, Config.user, Config.password); // Open connection
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
