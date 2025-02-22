<%@ include file="header.jsp" %>
	<main>
		<h1 class="p-3 mb-2 bg-success text-white text-center">Pacientes</h1>
		<div class="container-grilla">
			<j:if test="${not empty pacientes}">
				<j:forEach var="paciente" items="${pacientes}" varStatus="">
				<div class="item-grilla text-center">
					<img src="img/patient.png" alt="paciente" style="height: 120px"/>
					<h6><strong>Paciente:</strong> ${paciente.nombreUsuario} ${paciente.apellidoUsuario}</h6>
					<h6><strong>Telefono:</strong> ${paciente.telefonoUsuario}</h6>
					<h6><strong>Direccion:</strong> ${paciente.direccionUsuario}</h6>
					<h6><strong>Correo:</strong> ${paciente.correoUsuario}</h6>
					<h6><strong>Fecha Nac:</strong> ${paciente.fechaNac} (a�o-mes-dia)</h6>
					<a href="${pageContext.request.contextPath}/UserServlet?type=Buscar&id=${paciente.idUsuario}" class="btn btn-success">Editar</a>
					<a href="${pageContext.request.contextPath}/UserServlet?type=Eliminar&id=${paciente.idUsuario}" class="btn btn-danger">Eliminar</a>
				</div>
				</j:forEach>
			</j:if>
		</div>
   	</main>
   	<a href="${pageContext.request.contextPath}/jsp/crearuser.jsp" class="btn btn-primary">Registrar Paciente</a>
<script src="${pageContext.request.contextPath}/js/doctores.js">
</script>
<%@ include file="footer.jsp" %>