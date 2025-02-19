<%@ include file="header.jsp" %>
	<main>
			<h5><strong>Fecha Cita:</strong>  ${citas.fechaCita}</h5>
			<h5><strong>Hora Cita:</strong>  ${citas.horaCita}</h5>
			<h5><strong>Motivo de cita:</strong> ${citas.motivo}</h5>
			<h5><strong>Doctor:</strong> ${citas.nombreDoctor} ${citas.apellidoDoctor}</h5>
	</main>
<%@ include file="footer.jsp" %>