<%@ include file="header.jsp" %>
	<main>
		<section id="container-profile" class="d-flex justify-content-center text-center m-3">
		</section>
		<h4><j:out value="${sessionScope.userss.rolUsuario.toUpperCase()}"/></h4>
		<img src="https://firebasestorage.googleapis.com/v0/b/my-web-6e66e.appspot.com/o/img%2Fuser-icon-512x512-x23sj495.png?alt=media&token=5d2251b0-aa92-4123-81c1-fd7f30a61695" style="height: 120px; width: 120px" class="card-img-top" alt="perfil">
		<h4>Nombre: <j:out value="${sessionScope.userss.nombreUsuario}"/></h4>
		<h4>Apellidos: <j:out value="${sessionScope.userss.apellidoUsuario}"/></h4>
		<h4>Direccion: <j:out value="${sessionScope.userss.direccionUsuario}"/></h4>
		<j:choose>
        <j:when test="${sessionScope.userss.rolUsuario == 'admin'}">
        	<a href="/ProyectoFinal/AdminServlet?types=doctors" class="btn btn-success">Doctores</a>
			<a href="/ProyectoFinal/AdminServlet?types=pacientes" class="btn btn-success">Pacientes</a>
			<a href="/ProyectoFinal/jsp/crearMedicamento.jsp" class="btn btn-success">Agregar Medicamento</a>
        </j:when>
        
        <j:when test="${sessionScope.userss.rolUsuario == 'doctor'}">
            <a href="/ProyectoFinal/jsp/citas-pacientes.jsp" class="btn btn-success">Pacientes</a>
        </j:when>

        <j:when test="${sessionScope.userss.rolUsuario == 'paciente'}">
            <a href="/ProyectoFinal/CitaServlet?type=Buscar&dni=${user.dni}" class="btn btn-success">Citas</a>
        </j:when>

        <j:otherwise>
            <p>No tienes un rol válido.</p>
        </j:otherwise>
    </j:choose>
	</main>
<script src="${pageContext.request.contextPath}/js/profile.js">
</script>
<%@ include file="footer.jsp" %>