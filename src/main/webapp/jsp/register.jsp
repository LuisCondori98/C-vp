<%@ include file="header.jsp" %>
	<main>
		<section id="contacto" class="container py-5 text-center">
		    <h2 class="text-center mb-4">Registrar</h2>
			<form action="${pageContext.request.contextPath}/LoginServlet" mehtod="POST"
				class="d-flex flex-column gap-3 w-50 m-auto"
				>
				<input type="text" placeholder="Nombres" name="nombre" required/>
				<input type="text" placeholder="Apellido" name="apellido" required/>
				<input type="text" placeholder="Direccion" name="direccion" required/>
				<!-- <select name="Rol">
					<option value="null" disabled selected>--- Seleccione Rol ---</option>
					<option value="admin">Administrador</option>
					<option value="doctor">Doctor</option>
					<option value="paciente">Paciente</option>
				</select>  -->
				<input type="email" placeholder="Correo" name="correo" required/>
				<input type="password" placeholder="Contraseña" name="pass" required/>
				<input type="date" placeholder="Fecha Nacimiento" name="fechaNac" required/>
				<input type="submit" name="type" value="Registrar" class="btn btn-warning" />
		    </form>
	    </section>
   	</main>
<%@ include file="footer.jsp" %>