<%@ include file="header.jsp" %>
	<main>
		<h1 class="p-3 mb-2 bg-success text-white text-center">Doctores</h1>
		<div class="container-grilla">
			<j:if test="${not empty doctors}">
				<j:forEach var="doctor" items="${doctors}" varStatus="">
				<div class="item-grilla text-center">
					<img src="img/doctor-profile.webp" alt="doctor" style="height: 120px"/>
					<h6><strong>Doctor:</strong> ${doctor.nombreUsuario} ${doctor.apellidoUsuario}</h6>
					<h6><strong>Telefono:</strong> ${doctor.telefonoUsuario}</h6>
					<h6><strong>Direccion:</strong> ${doctor.direccionUsuario}</h6>
					<h6><strong>Correo:</strong> ${doctor.correoUsuario}</h6>
					<h6><strong>Fecha Nac:</strong> ${doctor.fechaNac}</h6>
				</div>
				</j:forEach>
			</j:if>
		</div>
   	</main>
<script src="${pageContext.request.contextPath}/js/doctores.js">
</script>
<%@ include file="footer.jsp" %>