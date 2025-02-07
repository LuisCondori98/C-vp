<%@ include file="header.jsp" %>
	<main>
		<section class="hero">
	        <h1>Bienvenido a la Clínica Vida Plena</h1>
	        <p>Comprometidos con tu salud y bienestar.</p>
	        <a href="#contacto" class="btn btn-light">Solicita tu consulta</a>
	    </section>
	    <section id="servicios" class="container py-5">
	        <h2 class="text-center mb-4">Nuestros Servicios</h2>
	        <div class="row">
	            <div class="col-md-4">
	                <div class="card service-card">
	                    <img src="https://firebasestorage.googleapis.com/v0/b/my-web-6e66e.appspot.com/o/img%2Fconsultas.jpg?alt=media&token=97250d88-dd96-47fd-a1de-14d343295828" height="270px" class="card-img-top" alt="Consulta médica">
	                    <div class="card-body">
	                        <h5 class="card-title">Consultas Médicas</h5>
	                        <p class="card-text">Atención personalizada por médicos especializados en diversas áreas.</p>
	                    </div>
	                </div>
	            </div>
	            <div class="col-md-4">
	                <div class="card service-card">
	                    <img src="https://firebasestorage.googleapis.com/v0/b/my-web-6e66e.appspot.com/o/img%2Fpsico.avif?alt=media&token=59789ef4-4ef6-4b5c-806d-dfdd53bb6064" height="270px" class="card-img-top" alt="Psicoterapia">
	                    <div class="card-body">
	                        <h5 class="card-title">Psicoterapia</h5>
	                        <p class="card-text">Apoyo emocional y terapias para el bienestar mental y emocional.</p>
	                    </div>
	                </div>
	            </div>
	            <div class="col-md-4">
	                <div class="card service-card">
	                    <img src="https://firebasestorage.googleapis.com/v0/b/my-web-6e66e.appspot.com/o/img%2Ffisio.png?alt=media&token=668b8278-6ab7-4b45-af2c-9f714d305196" height="270px" class="card-img-top" alt="Fisioterapia">
	                    <div class="card-body">
	                        <h5 class="card-title">Fisioterapia</h5>
	                        <p class="card-text">Tratamientos físicos para recuperación y mejora de movilidad.</p>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </section>
	    <section id="contacto" class="container py-5">
	        <h2 class="text-center mb-4">Contáctanos</h2>
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