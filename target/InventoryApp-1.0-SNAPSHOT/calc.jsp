<%-- 
    Document   : calc
    Created on : 3 Jan 2023, 18:51:18
    Author     : Clifford
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%ResultSet rs ;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>total</title>
         <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/style.css" />
    </head>
    
    <body>
        <div class="card" style="width: 70rem; margin:100px auto; background-color:white; border:none;">
  <div class="card-body">
      <br>
    <h5 class="card-title"> </h5>
  
    <form action="orderControl" method="POST" class="new added-form" >
    <%
        String custId = request.getParameter("custId");
        String custName = request.getParameter("custName");
        String prodId =  request.getParameter("prodId");
        String prodName = request.getParameter("prodName");
       
        
         String qty = request.getParameter("qty");
         String price = request.getParameter("price");
        
        double result = 0;
        
        
             result = Integer.parseInt(qty) * Double.parseDouble(price);
             
    %>
   
    <center>
        
        <h5><label>Server time   :</label>
         <input type="text" name="time" value="<%=new java.util.Date()%>" style="text-align:center;border: none"></h5>
     <br>
     <h2>ORDER DETAILS </h2>
     <br>
      
     <h5><label>Customer ID   :</label>
         <input type="text" name="custid" value="<%=custId%>" style="text-align:center;border: none"></h5>
     <h5><label>Customer Name :</label>
         <input type="text" name="custname" value="<%=custName%>" style="text-align:center;border: none"></h5>
      <h5><label>Product ID :</label>
         <input type="text" name="prodid" value="<%=prodId%>" style="text-align:center;border: none"></h5>
      <h5><label>Product Name :</label>
         <input type="text" name="prodname" value="<%=prodName%>" style="text-align:center;border: none"></h5>
      <h5><label>Quantity :</label>
         <input type="text" name="qty" value="<%=qty%>" style="text-align:center;border: none"></h5>
      <h5><label>Price :</label>
         <input type="text" name="price" value="<%=price%>" style="text-align:center;border: none"></h5>
      <h3><label>TOTAL :</label>
         <input type="text" name="total" value="<%=result%>" style="text-align:center;border: none"></h3>
    
                
    <div class="row">
        
    <div class="d-grid gap-2 d-md-block">
     <br><br>
     
     <!--<a class="btn btn-primary" href="orderControl?cid=<%=custId%>&dt=<%=new java.util.Date()%>&pid=<%=prodId%>&qty=<%=qty%>&pr=<%=price%>&tot=<%=result%>" role="button" >submit</a></td>-->
    <button class="btn btn-primary btn-lg" name="bntAction" value="add" type="submit" style="background-color:rgb(255,204,0);border:none;width:100px">Save</button>
    </div>
     </div> 
                 
     <center>
        </form> 
     
         
  </div>
</div>
        <script src="js/bootstrap.bundle.js"></script>
    </body>
</html>
