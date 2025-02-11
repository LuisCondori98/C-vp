<%@ include file="header.jsp" %>
	<main>
		<section id="contacto" class="container py-5 text-center">
		    <h2 class="text-center mb-4">Login</h2>
			<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
		        <div class="mb-3">
		            <input type="email" name="correo" placeholder="Correo" required/>
		        </div>
		        <div class="mb-3">
		            <input type="password" name="password" placeholder="Contraseña" required/>
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