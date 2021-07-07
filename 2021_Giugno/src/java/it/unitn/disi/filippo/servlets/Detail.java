/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.servlets;

import it.unitn.disi.filippo.beans.ItemBean;
import it.unitn.disi.filippo.beans.ItemBeanList;
import it.unitn.disi.filippo.config.Config;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class Detail extends HttpServlet {

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
        
        String viewURL = "/WEB-INF/DetailView.jsp";
        ServletContext ctx = getServletContext();
        String id = request.getParameter("id");
        ItemBeanList items = (ItemBeanList) ctx.getAttribute(Config.itemBeanListKey);
        
        boolean bestOfferer = false;
        boolean auctionOn = false;
        
        ItemBean item = null;
        for (ItemBean it : items) {
            if (it.getID().equals(id)) {
                item = it;
            }
        }   
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        if (username.equals(item.getBestOfferer())) {
            bestOfferer = true;
        }
        if (item.getDeadline().getTime() > new Date().getTime()) {
            auctionOn = true;
        }
        
        request.setAttribute("isAuctionOn", auctionOn);
        request.setAttribute("isBestOfferer", bestOfferer);
        request.setAttribute("item", item);

        request.getRequestDispatcher(viewURL).forward(request, response);
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
