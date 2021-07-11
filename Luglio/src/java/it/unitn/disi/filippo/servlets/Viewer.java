/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.servlets;

import it.unitn.disi.filippo.beans.MessageQueue;
import it.unitn.disi.filippo.util.Config;
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
public class Viewer extends HttpServlet {

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
        String view = "WEB-INF/Viewer.jsp";

        HttpSession session = request.getSession(false);
        ServletContext ctx = getServletContext();
        MessageQueue all = (MessageQueue) ctx.getAttribute(Config.queue);
        if (all == null) {
            request.setAttribute("none", "true");
            session = request.getSession(true);
            session.setAttribute("read", "0");
            String rate = (String) request.getParameter("rate");
            if (rate != null) {
                request.setAttribute("rate", rate);
            } else {
                request.setAttribute("rate", Config.defaultRefreshRate);
            }
        } else {
            request.setAttribute("none", "false");
            if (session == null) {
                session = request.getSession(true);

                MessageQueue msgs = all.getMessagesFrom(0);
                session.setAttribute("read", Integer.toString(msgs.size()));
                request.setAttribute("messages", msgs);
                request.setAttribute("rate", Config.defaultRefreshRate);
            } else {
                String viewAll = (String) request.getParameter("index");
                int index = 0;
                if (viewAll != null) {
                    index = Integer.parseInt(viewAll);
                    request.setAttribute("rate", Config.defaultRefreshRate);
                } else {
                    String sIndex = (String) session.getAttribute("read");
                    index = Integer.parseInt(sIndex);
                    String rate = (String) request.getParameter("rate");
                    if (rate != null) {
                        request.setAttribute("rate", rate);
                    } else {
                        request.setAttribute("rate", Config.defaultRefreshRate);
                    }
                }

                MessageQueue msgs = all.getMessagesFrom(index);
                int newRead = index + msgs.size();
                session.setAttribute("read", Integer.toString(newRead));
                request.setAttribute("messages", msgs);
            }
        }

        request.getRequestDispatcher(view).forward(request, response);
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
