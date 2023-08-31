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


@WebServlet(name = "ProductControl", urlPatterns = {"/ProductControl"})
public class ProductControl extends HttpServlet {


        String url = "jdbc:mysql://localhost:3306/stockdatabase";
        String user = "root";
        String password = "Cliff123";
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       
         ResultSet rs = null ;
        response.setContentType("text/html");
        
        PrintWriter pw = response.getWriter(); 
        
        String pid = request.getParameter("id");

        
       try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,user,password);
       
       
       String sql = "delete from product where productId=?";
       
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,pid);
 
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
         pw.println("<h3>Deleted successfully! <a href=\"viewProduct.jsp\">Ok</a></h3>");
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
         pw.println("<h3>Failed to delete! <a href=\"viewProduct.jsp\">Ok</a></h3>");
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
      String btn = request.getParameter("btnAction");
      
     if(btn.equals("save"))
     {
         response.setContentType("text/HTML");
         PrintWriter pw = response.getWriter();
      
        String pname = request.getParameter("prodName");
        String qty = request.getParameter("qty");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
      
        
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");//driver class
       Connection con = DriverManager.getConnection(url,user,password);
       
       String sql = "INSERT into product(productName,qty,price,descriptions,category) VALUES(?,?,?,?,?)";
       
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,pname);
       ps.setString(2,qty);
       ps.setString(3,price);
       ps.setString(4,description);
       ps.setString(5,category);
     
       
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
         pw.println("<h3>Added successfully! <a href=\"addProduct.jsp\">Ok</a></h3>");
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
         pw.println("<h3>Failed to add! <a href=\"addProduct.jsp\">Ok</a></h3>");
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
        
        String pid = request.getParameter("prodId");
        String pname = request.getParameter("prodName");
        String qty = request.getParameter("qty");
        String price = request.getParameter("price");
        String desc = request.getParameter("description");
        String cat = request.getParameter("cat");
       
       
        
        
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,user,password);
       
       
       String sql = "update product set productName=?,qty=?,price=?,descriptions=?,category=? where productId=?";
       
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,pname);
       ps.setString(2,qty);
       ps.setString(3,price);
       ps.setString(4,desc);
       ps.setString(5,cat);
       ps.setString(6,pid);
       
       
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
         pw.println("<h3>Added successfully! <a href=\"viewProduct.jsp\">Ok</a></h3>");
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
         pw.println("<h3>Failed to update! <a href=\"viewProduct.jsp\">Ok</a></h3>");
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
