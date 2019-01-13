package servlets;

import data.DbRepository;
import data.CalculationArchive;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet used for managing calculation history.
 * @author Piotr Paczuła
 * @version 1.1
 */
public class History extends HttpServlet {
    
    private DbRepository repo;
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
         // Servlet configuration - through initialization
        ServletConfig config = getServletConfig();
        // Servlet context
        ServletContext context = config.getServletContext();
        String path = context.getInitParameter("path");
        String user = context.getInitParameter("user");
        String password = context.getInitParameter("password");
        try {
            repo = new DbRepository(path,user,password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Calculate.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            try{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet history</title>");            
                out.println("</head>");
                out.println("<body>");
                ArrayList<CalculationArchive> archives = repo.getLastRecords();
                out.println("<h1>Last 10 results:</h1>");
                out.println("<table>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Greates Common Divisor</th>");
                out.println("<th>Least Common Multiple</th>");
                out.println("<th>Date</th>");
                out.println("<tr/>");
                out.println("</thead>");
                out.println("<tbody>");
                for(CalculationArchive archive : archives ){
                    out.println("<tr>");
                    out.println("<td>"+archive.gcm+"</td>");
                    out.println("<td>"+archive.lcm+"</td>");
                    out.println("<td>"+archive.date+"</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
            }
            catch(Exception ex) {
                out.println("<h1>Unknown error</h1><p>"+ex.getMessage()+"</p>");
            }
            finally{
                out.println("<form method=\"get\" action=\"/WebApplication\">");
                out.println("<button>GO BACK</button>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
