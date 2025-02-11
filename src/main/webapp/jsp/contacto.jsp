<%@ include file="header.jsp" %>
<main>
	<section id="contacto" class="container py-5">
	    <h2 class="text-center mb-4">Contactanos</h2>
	    <form>
	        <div class="mb-3">
	            <label for="email" class="form-label">Correo Electronico</label>
	            <input type="email" class="form-control" id="email" placeholder="Tu correo electronico" required>
	        </div>
	        <div class="mb-3">
	            <label for="mensaje" class="form-label">Mensaje</label>
	            <textarea class="form-control" id="mensaje" rows="4" placeholder="Escribe tu mensaje" required></textarea>
	        </div>
	        <button type="submit" class="btn btn-primary">Enviar</button>
	    </form>
	</section>
	<iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d1950.879942130325!2d-77.04139816199368!3d-12.060035176580044!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses-419!2spe!4v1739306685561!5m2!1ses-419!2spe" style="height: 450px; width: 100%; padding: 10px" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</main>
<%@ include file="footer.jsp" %>