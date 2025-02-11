<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>

	<main>
		<section>
			<h1>Formulario de Creaci�n de Medicamento</h1>

			    <form action="${pageContext.request.contextPath}/MedicamentoServlet?action=create" method="post">
			        <label for="nombre">Nombre:</label>
			        <input type="text" id="nombre" name="nombre" required><br><br>
			
			        <label for="descripcion">Descripci�n:</label>
			        <input type="text" id="descripcion" name="descripcion" required><br><br>
			
			        <label for="laboratorio">Laboratorio:</label>
			        <input type="text" id="laboratorio" name="laboratorio" required><br><br>
			
			        <label for="dosis">Dosis:</label>
			        <input type="text" id="dosis" name="dosis" required><br><br>
			
			        <label for="formaFarmaceutica">Forma Farmac�utica:</label>
			        <input type="text" id="formaFarmaceutica" name="formaFarmaceutica" required><br><br>
			
			        <label for="precio">Precio:</label>
			        <input type="text" id="precio" name="precio" required><br><br>
			
			        <label for="stock">Stock:</label>
			        <input type="number" id="stock" name="stock" required><br><br>
			
			        <label for="fechaVencimiento">Fecha de Vencimiento:</label>
			        <input type="date" id="fechaVencimiento" name="fechaVencimiento" required><br><br>
			
			        <button type="submit" class="btn btn-success">Crear Medicamento</button>
			    </form>
		</section>
	</main>

<%@ include file="footer.jsp" %>