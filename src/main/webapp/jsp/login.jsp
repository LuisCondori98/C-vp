<%@ include file="header.jsp" %>
	<main>
		<h3 class="bg-danger text-white text-center">${mensaje}</h3>
		<section id="contacto" class="container py-5 text-center w-25">
		    <h2 class="text-center mb-4">Login</h2>
			<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
		        <div class="mb-3">
		        	<label for="correo" class="form-label">Correo</label>
		            <input type="email" class="form-control" name="correo" placeholder="Correo" required/>
		        </div>
		        <div class="mb-3">
		        	<label for="password" class="form-label">Contraseña</label>
		            <input type="password" class="form-control" name="password" placeholder="Contraseña" required/>
		        </div>
		        <input type="submit" name="type" value="Ingresar" id="login" class="btn btn-primary" />
		    </form>
		    <a href="${pageContext.request.contextPath}/jsp/register.jsp">Registrarse</a>
	    </section>
	    <section>
	    	<j:if test="${not empty users}">
		    	<script>
		    		const user = {
		    				id: "${users.idUsuario}",
		    				dni: "${users.dniUsuario}",
		    				nombre: "${users.nombreUsuario}",
		    				apellido: "${users.apellidoUsuario}",
		    				direccion: "${users.direccionUsuario}",
		    				telefono: "${users.telefonoUsuario}",
		    				correo: "${users.correoUsuario}",
		    				rol: "${users.rolUsuario}",
		    				fechaNac: "${users.fechaNac}"
		    		}
		    		localStorage.setItem("user", JSON.stringify(user));
		    	</script>
	    	</j:if>
	    </section>
   	</main>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
<%@ include file="footer.jsp" %>