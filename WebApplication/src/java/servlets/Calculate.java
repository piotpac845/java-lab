package servlets;

import gcdlcm.exceptions.TooShortArrayException;
import gcdlcm.exceptions.ZeroNumberException;
import gcdlcm.models.CalculationArchive;
import gcdlcm.models.Converter;
import gcdlcm.models.ConvertingState;
import gcdlcm.models.GreatestCommonDivisor;
import gcdlcm.models.LeastCommonMultiple;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javafx.util.Pair;
import javax.servlet.http.Cookie;

/**
 * Manages input for calculations from user.
 * @author Piotr Paczuła
 * @version 1.0
 */
public class Calculate extends HttpServlet {

    final GreatestCommonDivisor divisor;
    final LeastCommonMultiple multiple;
    final Converter converter;
    final CalculationArchive archive;
    
    public Calculate() {
        divisor = new GreatestCommonDivisor();
        multiple = new LeastCommonMultiple();
        converter = new Converter();
        archive = new CalculationArchive();
    }

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
        String divisorsHistory = archive.getDivisorArchive();
        String multipleHistory = archive.getMultiplyArchive();
        request.setAttribute("divHistory", divisorsHistory);
        request.setAttribute("mulHistory", multipleHistory);
        getServletContext().getRequestDispatcher("/history").forward(request,response);
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
        boolean isStupid = false;
        boolean setStupidCookie = false;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            if(cookies[0].getValue().equals("1"))
                isStupid=true;
        }
        
        
        String params = request.getParameter("numbers");
        Pair<ConvertingState,List<Integer>> result = converter.getInput(params);
        String message="";
        switch(result.getKey())
        {
            case correct:
                divisor.setNumbers(result.getValue());
                multiple.setNumbers(result.getValue());
                try{
                    int divisorResult = divisor.calculate();
                    int multipleResult = multiple.calculate();
                    archive.addResultToArchive(divisorResult, multipleResult);
                    message = "<h1>Greatest Common divisor is equal to " + divisorResult 
                            + "</h1><h1>Least Common multiple is equal to " + multipleResult + 
                            "</h1>";
                }
                catch(TooShortArrayException exception){
                    message = "<h1>Error occured: Array was too short!</h1>";
                    setStupidCookie = true;
                }
                catch(ZeroNumberException exception){
                    message = "<h1>Error occured: Zero number is illegal!</h1>";
                    setStupidCookie = true;
                }
                catch (Exception ex) {
                    message = "<h1>Unknown error occured!</h1>";
                }
                
                break;
            case tooShort:
                message = "<h1>Error occured: Array was too short!</h1>";
                setStupidCookie = true;
               
                break;
            case wrongFormat:
                message = "<h1>Error occured: Wrong input format!</h1>";
                setStupidCookie = true;
            default:
                break;
        }
        
        
        if(setStupidCookie) {
            response.addCookie(new Cookie("stupid","1"));
        }
        else
        {
            response.addCookie(new Cookie("stupid","0"));
            isStupid=false;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(message);
            out.println("<form method=\"get\" action=\"/WebApplication\">");
            out.println("<button>GO BACK</button>");
            out.println("</form>");
            if(isStupid && setStupidCookie){
                out.println("<script>alert('Focus on inserting proper input...')</script>");
            }
            out.println("</body>");
            out.println("</html>");
        }        
       
    }
}
