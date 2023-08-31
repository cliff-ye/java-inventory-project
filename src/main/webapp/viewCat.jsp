<%-- 
    Document   : viewCat
    Created on : 29 Dec 2022, 13:19:22
    Author     : Clifford
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String url = "jdbc:mysql://localhost:3306/stockdatabase";
        String user = "root";
        String password = "Cliff123";
        ResultSet rs ;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>All categories</title>
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
            <li><a class="dropdown-item" href="viewOrders.jsp">Order product</a></li>
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
    <h5 class="card-title">All categories</h5>
    <br>
    <form action="" method="POST" class="new added-form">
    <div class="row">
     
   
    </div>
    </form>
    <br>
    <table class="table">
  <thead>
    <tr>
      <th>Category ID</th>
      <th>Category Name</th>  
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
             
             String sql = "Select * from category";
             Statement stmt = con.createStatement();
      
             rs = stmt.executeQuery(sql);
             while(rs.next())
             {
                 %>
                 
                <tr>
               <td><%=rs.getInt("catId")%></td>
               <td><%=rs.getString("categoryName")%></td>
               <td><a class="btn btn-primary" href="editCat.jsp?id=<%=rs.getInt("catId")%>" role="button">Edit</a></td>
               <td><a class="btn btn-primary" href="categoryServ?id=<%=rs.getString("catId")%>" name="btnDel" value="deleteCustomer" role="button">Delete</a></td>
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
