<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.jpg" type="image/x-icon">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
	<link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>Clinica Vida Plena</title>
</head>
<body>
	<header class="d-flex justify-content-between">
		<nav class="navbar navbar-expand-lg">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="${pageContext.request.contextPath}/jsp/index.jsp">Clinica vida plena</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
		    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavDropdown">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/jsp/index.jsp">Inicio</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="${pageContext.request.contextPath}/jsp/contacto.jsp">Contacto</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="${pageContext.request.contextPath}/jsp/citas.jsp">Citas</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="${pageContext.request.contextPath}/jsp/nosotros.jsp">Nosotros</a>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/jsp/especialidades.jsp" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Farmacia
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/MedicamentoServlet?action=list">Medicamentos</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<div class="d-flex" id="container-log" >
			<j:choose>
		        <j:when test="${not empty sessionScope.userss}">
		            <a href="profile.jsp" class="btn btn-primary"><j:out value="${sessionScope.userss.nombreUsuario}"/>!</a>
		            <a href="${pageContext.request.contextPath}/LoginServlet?type=Logout" class="btn btn-danger">Cerrar sesión</a>
		        </j:when>
		        <j:otherwise>
		            <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/login.jsp">Login</a>
		            <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/register.jsp">Register</a>
		        </j:otherwise>
	    	</j:choose>
		</div>
	</header>