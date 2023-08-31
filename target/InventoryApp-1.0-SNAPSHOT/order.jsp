<%-- 
    Document   : order
    Created on : 3 Jan 2023, 11:08:45
    Author     : Clifford
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String url = "jdbc:mysql://localhost:3306/stockdatabase";
        String user = "root";
        String password = "Cliff123";
        ResultSet rs,rs1 ;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Add products</title>
       <link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand mb-0 h1" href="#" id="lblnv">Inventory</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link " aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Customer</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="addCustomer.jsp">Add customer</a></li>
            <li><a class="dropdown-item" href="viewCustomer.jsp">View all customers</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Category</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="addCategory.jsp">Add category</a></li>
            <li><a class="dropdown-item" href="viewCat.jsp">View all categories</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Product</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="addProduct.jsp">Add product</a></li>
            <li><a class="dropdown-item" href="viewProduct.jsp">View all products</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Order</a>
          <ul class="dropdown-menu">
            
            <li><a class="dropdown-item" href="viewOrders.jsp">View all orders</a></li>
          </ul>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>


<!-- card -->
<div class="card" style="width: 80rem; margin:100px auto; background-color:white; border:none;">
  <div class="card-body">
    <h5 class="card-title">Order</h5>
    <br><br>
    <form action="calc.jsp" method="POST" class="new added-form">
    <div class="row">
        <% 
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,user,password); 
             
             String cid = request.getParameter("cid");
            
             
             String sql = "Select * from customer where customerId=?";
            
               PreparedStatement ps = con.prepareStatement(sql);
              ps.setString(1,cid);
              
              
             
              rs = ps.executeQuery();
             
            
             while(rs.next() )
             {
                 %>
                    <div class="col-xl-6 col-lg-6 col-12 form-group">
                    <label>Customer ID</label>
                    <input type="text" name="custId" class="form-control" value="<%=rs.getInt("customerId")%>">
                    </div>
                       <div class="col-xl-6 col-lg-6 col-12 form-group">
                    <label>Customer Name</label>
                    <input type="text" name="custName" class="form-control" value="<%=rs.getString("Firstname")+" "+rs.getString("LastName")%>" >
                    </div>
                    
      <%
                   }  
          }
        catch(Exception e)
        {
             System.out.println("An error occured"+e.getMessage());
        }
        %>
        
         <% 
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,user,password); 
             
            
             String pid= request.getParameter("Pid");
             
             
             String sql1 = "select * from product where productId=?";
               PreparedStatement ps = con.prepareStatement(sql1);
              ps.setString(1,pid);
          
              rs1=ps.executeQuery();
            
             while(rs1.next())
             {
                 %>
                   
                    <div class="col-xl-6 col-lg-6 col-12 form-group">
                        <br>
                    <label>Product ID</label>
                    <input type="text" name="prodId" class="form-control" value="<%=rs1.getString("productId")%> ">
                    </div>
                    <div class="col-xl-6 col-lg-6 col-12 form-group">
                        <br>
                    <label>Product Name</label>
                    <input type="text" name="prodName" class="form-control" value="<%=rs1.getString("productName")%> ">
                    </div>
                    <div class="col-xl-6 col-lg-6 col-12 form-group">
                        <br>
                    <label>Quantity</label>
                    <input type="number" name="qty" class="form-control" id="num1" min="1" max="<%=rs1.getInt("qty")%>" >
                    </div>

                    <div class="col-xl-6 col-lg-6 col-12 form-group">
                    <br>
                    <label>Price</label>
                    <input type="text" name="price" class="form-control" id="num2" value="<%=rs1.getString("price")%>" readonly>
                    </div>
                   
                    
                    <%         
                   }  
           
          }
        catch(Exception e)
        {
             System.out.println("An error occured"+e.getMessage());
        }
        %>
           
        
   </div>
     
    <div class="row">
        
    <div class="d-grid gap-2 d-md-block">
     <br>
      
    <button class="btn btn-primary btn-lg" name="btnAction" value="save" type="submit" style="background-color:rgb(255,204,0);border:none;width:120px">Proceed</button>
    <button class="btn btn-primary btn-lg" type="reset" style="width:120px"> Reset </button>
    </div>
     </div> 
    </form>
        
  </div>
</div>


        <script src="js/bootstrap.bundle.js">
            
           
        </script>
    </body>
</html>
