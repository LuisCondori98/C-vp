<%@ include file="header.jsp" %>
<main>
	<section class="p-1 w-50 m-auto">
		<form action="${pageContext.request.contextPath}/UserServlet" method="POST">
			<div class="mb-1">
	            <label for="dni" class="form-label">Dni</label>
	            <input type="number" class="form-control" name="dni" required>
	        </div>
	        <div class="mb-1">
	            <label for="nombre" class="form-label">Nombre</label>
	            <input type="text" class="form-control" name="nombre" required>
	        </div>
	        <div class="mb-1">
	            <label for="apellido" class="form-label">Apellido</label>
	            <input type="text" class="form-control" name="apellido" required>
	        </div>
	        <div class="mb-1">
	            <label for="telefono" class="form-label">Telefono</label>
	            <input type="number" class="form-control" name="telefono" required>
	        </div>
	        <div class="mb-1">
	            <label for="direccion" class="form-label">Direccion</label>
	            <input type="text" class="form-control" name="direccion" required>
	        </div>
	        <div class="mb-1">
	            <label for="correo" class="form-label">Correo</label>
	            <input type="email" class="form-control" name="correo" required>
	        </div>
	        <div class="mb-1">
	            <label for="pass" class="form-label">Contraseña</label>
	            <input type="password" class="form-control" name="pass" required>
	        </div>
	        <div class="mb-1">
	        	<label for="Rol" class="form-label">Rol</label>
	        	<select name="Rol" class="form-control">
	        		<option disabled selected>-- Seleccione --</option>
	        		<option value="paciente">Paciente</option>
	        		<option value="doctor">Doctor</option>
	        		<option value="admin">Administrador</option>
	        	</select>
	        </div>
	        <div class="mb-1">
	            <label for="fechaNac" class="form-label">Fecha</label>
	            <input type="date" class="form-control" name="fechaNac" required>
	        </div>
	        <input type="submit" name="type" value="Registrar" class="btn btn-primary" />
		</form>
	</section>
</main>
<%@ include file="footer.jsp" %>