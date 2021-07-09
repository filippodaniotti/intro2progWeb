/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.servlets;

import it.unitn.disi.filippo.commons.Coppia;
import it.unitn.disi.filippo.commons.MappaDiCoppie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Filippo
 */
public class AddWord extends HttpServlet {

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

        boolean found = false;
        ServletContext ctx = getServletContext();
        MappaDiCoppie map = (MappaDiCoppie) ctx.getAttribute("map");
        
        String msg = "";

        String key = request.getParameter("key");
        String word = request.getParameter("word");
        String user = request.getParameter("user");

        if (key != null && !(key.equals(""))) {
            Coppia c = map.get(key);
            if (c != null) {
                if (key.equals(user)) {
                    c.getList1().add(word);
                    found = c.getList2().contains(word);
                    msg += "Hai vinto, la parola magica è ";
                } else {
                    c.getList2().add(word);
                    found = c.getList1().contains(word);
                    msg += "Hai vinto, la parola magica è ";
                }
                if (found) {
                    c.win();
                }
            } else {
                found = true;
                msg += "Hai perso, la parola magica era ";
            }

        }

        try (PrintWriter out = response.getWriter()) {
            out.println("{\"endGame\":" + found + ", \"msg\":\""+msg+"\"}");
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
