/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Clifford
 */
@WebServlet(name = "calculate", urlPatterns = {"/calculate"})
public class calculate extends HttpServlet {

   
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
       
       
        
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       response.setContentType("text/HTML");
        PrintWriter pw = response.getWriter();
       
        String qty = request.getParameter("qty");
        String price = request.getParameter("price");
        
        double result = 0;
        
        
             result = Integer.parseInt(qty) * Double.parseDouble(price);
     
        
        pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-success\" role=\"alert\">");
         pw.println("<h5 class=\"alert-heading\">TOTAL : "+" GHC "+result +"</h5>");
         pw.println("<p>");
         pw.println("</p>");
         pw.println("</hr>");
         pw.println("<p>");
        
         pw.println("</p>");
         pw.println("</div>");
         pw.println("<script src=\"js/bootstrap.bundle.js\">");        
         pw.println("</script>");
         pw.println("</body>");
         pw.println("</html>");   

    }
}
