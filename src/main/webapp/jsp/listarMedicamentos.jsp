<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>

	<main>
		<section>
			<h1 class="p-3 mb-2 bg-success text-white text-center">Listado de Medicamentos</h1>
			<div class="container-grilla">
				<c:forEach var="medicamento" items="${medicamentos}">
					<div class="item-grilla">
						<img alt="${medicamento.nombre}" href="" />
						<h6>Medicamento: ${medicamento.nombre}</h6>
						<h6>Descripcion: ${medicamento.descripcion}</h6>
						<h6>Tipo: ${medicamento.formaFarmaceutica}</h6>
						<h6>Precio: S/. ${medicamento.precio}</h6>
					</div>
				</c:forEach>
			</div>
		</section>
	</main>

<%@ include file="footer.jsp" %>