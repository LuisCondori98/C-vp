<%@ include file="header.jsp" %>
	<main>
		<section id="contacto" class="container py-5 text-center">
		    <h2 class="text-center mb-4">Registrar</h2>
			<form action="${pageContext.request.contextPath}/UserServlet" method="POST"
				class="d-flex flex-column gap-3 w-50 m-auto"
				>
				<input type="number" class="form-control" placeholder="Dni" name="dni" required/>
				<input type="text" class="form-control" placeholder="Nombres" name="nombre" required/>
				<input type="text" class="form-control" placeholder="Apellido" name="apellido" required/>
				<input type="number" class="form-control" placeholder="Telefono" name="telefono" required/>
				<input type="text" class="form-control" placeholder="Direccion" name="direccion" required/>
				<input type="email" class="form-control" placeholder="Correo" name="correo" required/>
				<input type="password" class="form-control" placeholder="Contraseña" name="pass" required/>
				<input type="date" class="form-control" placeholder="Fecha Nacimiento" name="fechaNac" required/>
				<input type="hidden" class="form-control" name="Rol" value="paciente" />
				<input type="submit" name="type" value="Registrar" class="btn btn-warning" />
		    </form>
	    </section>
   	</main>
<%@ include file="footer.jsp" %>