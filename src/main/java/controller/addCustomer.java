/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Clifford
 */
@WebServlet(name = "addCustomer", urlPatterns = {"/addCustomer"})
public class addCustomer extends HttpServlet {
   
   

   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       
       
        String url = "jdbc:mysql://localhost:3306/stockdatabase";
        String user = "root";
        String password = "Cliff123";
        
    
         ResultSet rs = null ;
        response.setContentType("text/HTML");
         PrintWriter pw = response.getWriter();
        
        String cid = request.getParameter("id");

        
       try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,user,password);
       
       
       String sql = "delete from customer where customerId=?";
       
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,cid);
 
        int count = ps.executeUpdate();
       
        if(count == 1)
       {
         pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-success\" role=\"alert\">");
         pw.println("<h3>Deleted successfully! <a href=\"viewCustomer.jsp\">Ok</a></h3>");
         pw.println("</div>");
         pw.println("<script src=\"js/bootstrap.bundle.js\">");        
         pw.println("</script>");
         pw.println("</body>");
         pw.println("</html>");   
       }
       else
       {
         pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-danger\" role=\"alert\">");
         pw.println("<h3>Deleted successfully! <a href=\"viewCustomer.jsp\">Ok</a></h3>");
         pw.println("</div>");
         pw.println("<script src=\"js/bootstrap.bundle.js\">");        
         pw.println("</script>");
         pw.println("</body>");
         pw.println("</html>");     
      }
      }
    catch(Exception e){
         System.out.println("An error occured"+e.getMessage());
      }
    }
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
       
       String btn = request.getParameter("bntAction");
       String url = "jdbc:mysql://localhost:3306/stockdatabase";
        String user = "root";
        String password = "Cliff123";
        
     if(btn.equals("add"))
     {
         response.setContentType("text/HTML");
         PrintWriter pw = response.getWriter();
      
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
      
        
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");//driver class
       Connection con = DriverManager.getConnection(url,user,password);
       
       String sql = "INSERT into customer(Firstname,LastName,phone) VALUES(?,?,?)";
       
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,fname);
       ps.setString(2,lname);
       ps.setString(3,phone);
     
       
       int count = ps.executeUpdate();
       
       if(count == 1)
       {
         pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-success\" role=\"alert\">");
         pw.println("<h3>Added successfully! <a href=\"regCustomer.jsp\">Ok</a></h3>");
         pw.println("</div>");
         pw.println("<script src=\"js/bootstrap.bundle.js\">");        
         pw.println("</script>");
         pw.println("</body>");
         pw.println("</html>");        
       }
       else
       {
         pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-danger\" role=\"alert\">");
         pw.println("<h3>Failed to add! <a href=\"regCustomer.jsp\">Ok</a></h3>");
         pw.println("</div>");
         pw.println("<script src=\"js/bootstrap.bundle.js\">");        
         pw.println("</script>");
         pw.println("</body>");
         pw.println("</html>"); 
      }
    }
    catch(ClassNotFoundException | SQLException e){
         System.out.println("An error occured"+e.getMessage());
      }
    }
     
     else if(btn.equals("update"))
     {
          ResultSet rs = null ;
        response.setContentType("text/html");
        
        PrintWriter pw = response.getWriter(); 
        
        String cid = request.getParameter("id");
        String fn = request.getParameter("firstname");
        String ln = request.getParameter("lastname");
        String phone = request.getParameter("phone");
       
        
        
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,user,password);
       
       
       String sql = "update customer set Firstname=?,LastName=?,phone=? where customerId=?";
       
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,fn);
       ps.setString(2,ln);
       ps.setString(3,phone);
       ps.setString(4,cid);
       
       
        int count = ps.executeUpdate();
       
        if(count == 1)
       {
         pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-success\" role=\"alert\">");
         pw.println("<h3>updated successfully! <a href=\"viewCustomer.jsp\">Ok</a></h3>");
         pw.println("</div>");
         pw.println("<script src=\"js/bootstrap.bundle.js\">");        
         pw.println("</script>");
         pw.println("</body>");
         pw.println("</html>"); 
       }
       else
       {
         pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-danger\" role=\"alert\">");
         pw.println("<h3>Failed to update! <a href=\"viewCustomer.jsp\">Ok</a></h3>");
         pw.println("</div>");
         pw.println("<script src=\"js/bootstrap.bundle.js\">");        
         pw.println("</script>");
         pw.println("</body>");
         pw.println("</html>"); 
      }
      }
    catch(ClassNotFoundException | SQLException e){
         System.out.println("An error occured"+e.getMessage());
      }
     }
    }
}

    


