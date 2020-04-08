<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Gestione Utenti DB</title>
  </head>
  <body>
  <%@page import="model.Cliente"%>

<%
	Cliente c = (Cliente) request.getAttribute("cliente");	
%>
<div class="container">
	<h1>Register Page</h1>
	<form method="get">
	<div class="form-group">
	  <div class="form-group">
	  
	    <label for="exampleInputEmail1">Mail</label>
	    <input type="email" name="mail" class="form-control" id="exampleInputEmail1">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Invia</button>
	</form>
	</div>

</body>
</html>
