<%@ include file="header.jsp" %>
	<main>
		<section id="contacto" class="container py-5">
	        <h2 class="text-center mb-4">Citas</h2>
	        <form>
	            <div class="mb-3">
	                <label for="nombre" class="form-label">Nombre</label>
	                <input type="text" class="form-control" id="nombre" placeholder="Tu nombre" required>
	            </div>
	            <div class="mb-3">
	                <label for="email" class="form-label">Correo Electrónico</label>
	                <input type="email" class="form-control" id="email" placeholder="Tu correo electrónico" required>
	            </div>
	            <div class="mb-3">
	                <label for="mensaje" class="form-label">Mensaje</label>
	                <textarea class="form-control" id="mensaje" rows="4" placeholder="Escribe tu mensaje" required></textarea>
	            </div>
	            <button type="submit" class="btn btn-primary">Enviar</button>
	        </form>
	    </section>
   	</main>
<%@ include file="footer.jsp" %>