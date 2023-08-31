<%-- 
    Document   : viewOrders
    Created on : 17 Jan 2023, 22:38:46
    Author     : Clifford
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String url = "jdbc:mysql://localhost:3306/stockdatabase";
        String user = "root";
        String password = "Cliff123";
        ResultSet rs ;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<!-- navbar -->
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

<div class="card" style="width: 80rem; margin:50px auto; background-color:white; border:none;">
  <div class="card-body">
    <h5 class="card-title">All Orders</h5>
    <br>
    <form action="" method="POST" class="new added-form">
    <div class="row">
    
   
    </div>
    </form>
    <br>
    <table class="table">
  <thead>
    <tr>
      <th>Order ID</th>
      <th>Order Date</th>
      <th>Product ID</th>
      <th>Customer ID</th>
      <th>Quantity</th>
      <th>Price</th>
      <th>TOTAL</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
     <% 
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,user,password); 
             
             String sql = "Select * from orderTB";
             Statement stmt = con.createStatement();
      
             rs = stmt.executeQuery(sql);
             while(rs.next())
             {
                 %>
                 
                <tr>
               <td><%=rs.getInt("orderId")%></td>
               <td><%=rs.getString("orderDate")%></td>
                <td><%=rs.getInt("prodId")%></td>
                <td><%=rs.getString("custId")%></td>
                <td><%=rs.getString("qty")%></td>
                <td><%=rs.getString("Price")%></td>
                <td><%=rs.getString("total")%></td>
                <td><a class="btn btn-primary" href="orderControl?id=<%=rs.getInt("orderId")%>&qty=<%=rs.getInt("qty")%>&pid=<%=rs.getInt("prodId")%>" role="button">Delete</a></td>
               

                </tr>
               
                  
               <%
                   }  
          }
        catch(Exception e)
        {
             System.out.println("An error occured"+e.getMessage());
        }
        %>
  </tbody>
</table>
  </div>
</div>



<script src="js/bootstrap.bundle.js"></script>
    </body>
</html>
