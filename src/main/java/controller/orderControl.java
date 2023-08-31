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
@WebServlet(name = "orderControl", urlPatterns = {"/orderControl"})
public class orderControl extends HttpServlet {

 String url = "jdbc:mysql://localhost:3306/stockdatabase";
        String user = "root";
        String password = "Cliff123";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
      
       ResultSet rs = null ;
        response.setContentType("text/html");
        
        PrintWriter pw = response.getWriter(); 
        
        String ordid = request.getParameter("id");
        int quantity = Integer.parseInt(request.getParameter("qty"));
        String pid = request.getParameter("pid");
        
       try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,user,password);
       
       
       String sql = "delete from orderTB where orderId=?";
       
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,ordid);
 
        int count = ps.executeUpdate();
       
        String sql1 = "update product set qty=(qty+?) where productId=?";
          PreparedStatement ps1;
          ps1 = con.prepareStatement(sql1);
          ps1.setInt(1,quantity);
          ps1.setString(2,pid);
          
          int count1 = ps1.executeUpdate();
          
        if(count == 1 && count1 == 1)
       {
         pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-success\" role=\"alert\">");
         pw.println("<h3>Deleted successfully! <a href=\"viewOrders.jsp\">Ok</a></h3>");
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
         pw.println("<h3>Failed to delete! <a href=\"viewOrders.jsp\">Ok</a></h3>");
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
        //processRequest(request, response);
        
        
        String custId = request.getParameter("custid");
        String dt = request.getParameter("time");
        String prodId =  request.getParameter("prodid");
        int qty1 = Integer.parseInt(request.getParameter("qty"));
        double price = Double.parseDouble(request.getParameter("price"));
        double total = Double.parseDouble(request.getParameter("total"));
        response.setContentType("text/HTML");
        PrintWriter pw = response.getWriter();
      
       
      
        
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");//driver class
       Connection con = DriverManager.getConnection(url,user,password);
       
       String sql = "INSERT into orderTB(orderDate,prodId,custId,qty,price,total) VALUES(?,?,?,?,?,?)";
       
       PreparedStatement ps;
       ps = con.prepareStatement(sql);
       ps.setString(1,dt);
       ps.setString(2,prodId);
       ps.setString(3,custId);
       ps.setInt(4,qty1);
       ps.setDouble(5,price);
       ps.setDouble(6,total);
     
       
       int count = ps.executeUpdate();
       
        String sql1 = "update product set qty=(qty-?) where productId=?";
          PreparedStatement ps1;
          ps1 = con.prepareStatement(sql1);
          ps1.setInt(1,qty1);
          ps1.setString(2,prodId);
          
          int count1 = ps1.executeUpdate();
       
       if(count == 1 && count1 == 1)
       {
         pw.println("<!DOCTYPE html>");  
         pw.println("<html>");
         pw.println("<head>");
         pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
         pw.println("</head>");
         pw.println("<body>");
         pw.println("<div class=\"alert alert-success\" role=\"alert\">");
         pw.println("<h3>Ordered successfully! <a href=\"regCustomer.jsp\">Ok</a></h3>");
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
     
    
    }
    



