<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>

	<main>
		<section>
			<h1>Formulario de Actualización de Medicamento</h1>

			    <form action="MedicamentoServlet?action=update" method="post">
			        <input type="hidden" name="id" value="${medicamento.id}">
			
			        <label for="nombre">Nombre:</label>
			        <input type="text" id="nombre" name="nombre" value="${medicamento.nombre}" required><br><br>
			
			        <label for="descripcion">Descripción:</label>
			        <input type="text" id="descripcion" name="descripcion" value="${medicamento.descripcion}" required><br><br>
			
			        <label for="laboratorio">Laboratorio:</label>
			        <input type="text" id="laboratorio" name="laboratorio" value="${medicamento.laboratorio}" required><br><br>
			
			        <label for="dosis">Dosis:</label>
			        <input type="text" id="dosis" name="dosis" value="${medicamento.dosis}" required><br><br>
			
			        <label for="formaFarmaceutica">Forma Farmacéutica:</label>
			        <input type="text" id="formaFarmaceutica" name="formaFarmaceutica" value="${medicamento.formaFarmaceutica}" required><br><br>
			
			        <label for="precio">Precio:</label>
			        <input type="text" id="precio" name="precio" value="${medicamento.precio}" required><br><br>
			
			        <label for="stock">Stock:</label>
			        <input type="number" id="stock" name="stock" value="${medicamento.stock}" required><br><br>
			
			        <label for="fechaVencimiento">Fecha de Vencimiento:</label>
			        <input type="date" id="fechaVencimiento" name="fechaVencimiento" value="${medicamento.fechaVencimiento}" required><br><br>
			
			        <button type="submit">Actualizar Medicamento</button>
			    </form>
			
			    <a href="MedicamentoServlet?action=list">Ver todos los medicamentos</a>
		</section>
	</main>

<%@ include file="footer.jsp" %>