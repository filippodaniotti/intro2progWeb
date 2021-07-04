/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Filippo
 */
@WebServlet(name = "getValue", urlPatterns = {"/getValue"})
public class getValue extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");

        String xString = request.getParameter("x");
        String yString = request.getParameter("y");

        int x;
        int y;

        if (xString == null) {
            x = -1;
        } else {
            x = Integer.parseInt(xString);
        }
        if (yString == null) {
            y = -1;
        } else {
            y = Integer.parseInt(yString);
        }

        HttpSession session = request.getSession(false);
        GameMatrix board = null;

        try (PrintWriter out = response.getWriter()) {
            out.println("{");
            out.println("\"value\":");
            if (session != null) {
                board = (GameMatrix) session.getAttribute("board");
                if (board != null) {
                    if (board.onBound(x, y)) {
                        if (!board.getCell(x, y).isBomb()) {
                            Cell cell = board.getCell(x, y);
                            if (!cell.isClicked()) {
                                cell.click();
                            }
                            String value = Integer.toString(cell.getNeighbors());
                            out.println("\"" + value + "\"");
                        } else {
                            out.println("\"-1\"");
                        }
                    } else {
                        out.println("\"invalid coordinates\"");
                    }
                } else {
                    out.println("\"board not found\"");
                }
            } else {
                out.println("\"session not found\"");
            }
            out.println("}");
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
