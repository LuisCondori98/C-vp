<%@ include file="header.jsp" %>
	<main class="p-2">
		<form action="${pageContext.request.contextPath}/UserServlet" method="GET"
				class="d-flex flex-column gap-3 w-50 m-auto"
				>
				<input type="hidden" name="id" value="${user.idUsuario}"/>
				<div>
					<label for="dni" class="form-label">Dni</label>
					<input type="number" name="dni" class="form-control" value="${user.dniUsuario}" required/>
				</div>
				<div>
					<label for="nombre" class="form-label">Nombre</label>
					<input type="text" value="${user.nombreUsuario}" name="nombre" class="form-control" required/>
				</div>
				<div>
					<label for="apellido" class="form-label">Apellido</label>
					<input type="text" value="${user.apellidoUsuario}" name="apellido" class="form-control" required/>
				</div>
				<div>
					<label for="telefono" class="form-label">Telefono</label>
					<input type="number" value="${user.telefonoUsuario}" name="telefono" class="form-control" required/>
				</div>
				<div>
					<label for="direccion" class="form-label">Direccion</label>
					<input type="text" value="${user.direccionUsuario}" name="direccion" class="form-control" required/>
				</div>
				<div>
					<label for="correo" class="form-label">Correo</label>
					<input type="email" value="${user.correoUsuario}" name="correo" class="form-control" required/>
				</div>
				<div>
					<label for="fechaNac" class="form-label">Fecha Nacimiento</label>
					<input type="date" value="${user.fechaNac}" name="fechaNac" class="form-control" required/>
				</div>
				<input type="submit" name="type" value="Modificar" class="btn btn-warning" />
		    </form>
   	</main>
<script src="${pageContext.request.contextPath}/js/citas.js">
</script>
<%@ include file="footer.jsp" %>