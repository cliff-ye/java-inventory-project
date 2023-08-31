<%-- 
    Document   : regCustomer
    Created on : 23 Dec 2022, 07:00:20
    Author     : Clifford
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register customer</title>
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
            <li><a class="dropdown-item" href="regCustomer.jsp">Add customer</a></li>
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


<!-- card -->
<div class="card" style="width: 80rem; margin:100px auto; background-color:white; border:none;">
  <div class="card-body">
    <h5 class="card-title">Add customer</h5>
    <br><br>
    <form action="addCustomer" method="POST" class="new added-form">
    <div class="row">
     <div class="col-xl-6 col-lg-6 col-12 form-group">
     <label>First name</label>
     <input type="text" class="form-control" name="firstname">
     </div>
     <div class="col-xl-6 col-lg-6 col-12 form-group">
     <label>Last name</label>
     <input type="text" class="form-control" name="lastname">
     </div>
    
     <div class="col-xl-6 col-lg-6 col-12 form-group">
     <br>
     <label>Phone name</label>
     <input type="text" class="form-control" name="phone">
     </div>
   </div>
     
    <div class="row">
    <div class="d-grid gap-2 d-md-block">
     <br>
    <button class="btn btn-primary btn-lg" name="bntAction" value="add" type="submit" style="background-color:rgb(255,204,0);border:none;width:100px">Save</button>
    <button class="btn btn-primary btn-lg" type="reset" style="width:100px"> Reset </button>
    </div>
     
     </div> 
    </form>
  </div>
</div>
      <script src="js/bootstrap.bundle.js"></script>
    </body>
</html>
