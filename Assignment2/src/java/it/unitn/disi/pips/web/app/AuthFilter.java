/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.pips.web.app;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pips
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/library.jsp"})
public class AuthFilter implements Filter {
     
    private String dbURL = "jdbc:derby://localhost:1527/LibraryDB";
    private String user = "pips";
    private String password = "puabadoa";
    public Connection conn = null;
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AuthFilter() {
    }    
    
    private boolean checkUser(String user, String pw) {
        boolean exists = false;
        if (user == null || pw == null) {
            return false;
        }
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT USERNAME, PASSWORD FROM USERS";
            ResultSet results = stmt.executeQuery(query);
            while (results.next()) {
                if (results.getString("USERNAME").equals(user) &&
                    results.getString("PASSWORD").equals(pw)) {
                    exists = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exists;
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        //  first check is session exists
        HttpSession session = ((HttpServletRequest)request).getSession(false);
        
            if (session == null) {
            String user = request.getParameter("username");
            String pw = request.getParameter("password");

            // if session does not exist, then create one
            session = ((HttpServletRequest)request).getSession();
            
            // check if parameters are valid
            if (!checkUser(user, pw)) {
                // if parameters are wrong redirect to login page
                request.getRequestDispatcher("login.html").include(request, response);
            } else {
                // parameters are valid set them to session
                session.setAttribute("username", user);
                session.setAttribute("password", pw);
                chain.doFilter(request, response);
            }
        } else {
            // session already exists
            String user = (String)session.getAttribute("username");
            String pw = (String)session.getAttribute("password");
            
            if (checkUser(user, pw)) {
                chain.doFilter(request, response);
            } else {
                user = request.getParameter("username");
                pw = request.getParameter("password");
                if (checkUser(user, pw)) {
                    session.setAttribute("username", user);
                    session.setAttribute("password", pw);
                    chain.doFilter(request, response);
                } else {
                    request.setAttribute("failed", true);
                    request.getRequestDispatcher("login.html").include(request, response);
                }
            }
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {   
                try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
                try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
