/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.servlets;

import it.unitn.disi.filippo.commons.Config;
import it.unitn.disi.filippo.commons.Coppia;
import it.unitn.disi.filippo.commons.MappaDiCoppie;
import it.unitn.disi.filippo.commons.WaitingRoom;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Filippo
 */
public class setUser extends HttpServlet {

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

        String url = "/Settembre";
        String name = request.getParameter("name");
        if (name != null && !(name.equals(""))) {
            ServletContext ctx = getServletContext();
            HttpSession session = request.getSession(true);
            session.setAttribute("name", name);

            WaitingRoom room = (WaitingRoom) ctx.getAttribute("room");
            if (room.isEmpty()) {
                room.addCoppia(new Coppia(name));
                session.setAttribute("gameKey", room.getFirstUser());
                url += "/wait.jsp";
            } else {
                room.addOpponent(name);
                room.finalizeCoppia();
                MappaDiCoppie map = (MappaDiCoppie) ctx.getAttribute("map");
                session.setAttribute("gameKey", room.getFirstUser());
                map.put(room.getFirstUser(), room.getCoppiaAndClean());
                url += "/game.jsp";
            }
        }
        url = response.encodeURL(url);
        response.sendRedirect(url);
    }

    @Override
    public void init()
            throws ServletException {

        ServletContext ctx = getServletContext();
        Config.initialize(ctx);
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
