/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.pips.web.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
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
public class SetUser extends HttpServlet {
    
    public static int counter = 0;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        context.setAttribute("wRoom", new WaitingRoom());
        context.setAttribute("map", new MappaDiCoppie());
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
        response.setContentType("text/html;charset=UTF-8");
        
        String currentUser = request.getParameter("user");
        
        if (currentUser != null && !currentUser.isEmpty()) {
            
            ServletContext context = getServletContext();
            HttpSession session = request.getSession(true);
            session.setAttribute("user", currentUser);
            
            WaitingRoom room = (WaitingRoom) context.getAttribute("wRoom");
            Coppia c;
            
            Random rnd = new Random();
            int pic = rnd.nextInt(5);
            
            if (room.isEmpty()) {
                c = new Coppia(currentUser);
                room.addCoppia(c);
                session.setAttribute("key", ++counter);
                response.sendRedirect("wait.jsp?pic=" + pic);
            } else {
                MappaDiCoppie map = (MappaDiCoppie) context.getAttribute("map");
                
                room.getCoppia().addOpponent(currentUser);
                map.put(room.getCoppia().getFirst(), room.getCoppia());
                session.setAttribute("key", room.getCoppia().getFirst());
                response.sendRedirect("game.jsp?pic=" + pic);
            }
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
