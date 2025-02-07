<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>My Page</title>
</head>
<body>
	<header class="d-flex">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="index.jsp">Clinica vida plena</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
		    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavDropdown">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="contacto.jsp">Contacto</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="citas.jsp">Citas</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="nosotros.jsp">Nosotros</a>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="especialidades.jsp" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Especialidades
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="#">Action</a></li>
		            <li><a class="dropdown-item" href="#">Another action</a></li>
		            <li><a class="dropdown-item" href="#">Something else here</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
			<div class="d-flex" id="container-log">
				<a href="login.jsp" class="btn btn-success m-2" id="logeo">Login</a>
				<button class="btn btn-danger m-2" id="logout">Logout</button>
			</div>
	</header>