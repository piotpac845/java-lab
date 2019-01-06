package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet used for managing calculation history.
 * @author Piotr Paczuła
 * @version 1.0
 */
public class History extends HttpServlet {

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
        String divHistory = (String)request.getAttribute("divHistory");
        String mulHistory = (String)request.getAttribute("mulHistory");
                 response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet history</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Last 10 results:</h1>");
            out.println("<h2>Greatest Common Divisors: " + divHistory+ "</h2>");
            out.println("<h2>Least Common Multiple:" + mulHistory+ "</h2>");
            out.println("<form method=\"get\" action=\"/WebApplication\">");
            out.println("<button>GO BACK</button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
