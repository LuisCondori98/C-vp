<%@ include file="header.jsp" %>
	<main>
		<j:choose>
	        <j:when test="${not empty sessionScope.userss}">
	            <h2 class="text-center mb-4">Citas</h2>
        <form action="/ProyectoFinal/CitaServlet" method="POST">
            <div class="mb-3">
                <label for="dni" class="form-label">Dni</label>
                <input type="number" class="form-control" name="dni" value="${sessionScope.userss.dniUsuario}"  readonly>
            </div>
            <div class="mb-3">
	            <label for="motivo" class="form-label">Especialidad</label>
	            <select name="motivo" class="form-select" aria-label="Default select example" required>
	            	<option readonly>-- Seleccione --</option>
	            	<option value="cardiologia">Cardiologia</option>
	            	<option value="odontologia">Odontologia</option>
	            	<option value="oftalmologia">Oftalmologia</option>
	            </select>
            </div>
            <div class="mb-3">
                <label for="fechaCita" class="form-label">Fecha Cita</label>
                <input type="date" class="form-control" name="fechaCita" placeholder="Eliga fecha" style="width: 200px"/>
            </div>
            <div class="mb-3">
	            <label for="horaCita" class="form-label">Hora Cita</label>
	            <select name="horaCita" class="form-select" aria-label="Default select example" style="width: 200px">
	            	<option readonly>-- Seleccione --</option>
	            	<option value="8:00 am">8:00 am</option>
	            	<option value="8:30 am">8:30 am</option>
	            	<option value="9:00 am">9:00 am</option>
	            	<option value="9:30 am">9:30 am</option>
	            	<option value="10:00 am">10:00 am</option>
	            	<option value="10:30 am">10:30 am</option>
	            	<option value="11:00 am">11:00 am</option>
	            	<option value="11:30 am">11:30 am</option>
	            	<option value="12:00 am">12:00 am</option>
	            	<option value="12:30 pm">12:30 pm</option>
	            	<option value="1:00 pm">1:00 pm</option>
	            	<option value="1:30 pm">1:30 pm</option>
	            	<option value="2:00 pm">2:00 pm</option>
	            	<option value="2:30 pm">2:30 pm</option>
	            	<option value="3:00 pm">3:00 pm</option>
	            	<option value="3:30 pm">3:30 pm</option>
	            	<option value="4:00 pm">4:00 pm</option>
	            	<option value="4:30 pm">4:30 pm</option>
	            	<option value="5:00 pm">5:00 pm</option>
	            </select>
            </div>
            <h2>${usuarios}s</h2>
            <div class="mb-3">
            	<label for="idDoctor" class="form-label">Doctor</label>
	            <select name="idDoctor" class="form-select">
	            	<option value="">-- Seleccione --</option>
	            	<option value="77">Dahana Condori</option>
	            	<option value="80">Gabriel Lopez</option>
	            </select>
        	</div>
            <button type="submit" name="type" value="Registrar" class="btn btn-primary">Enviar</button>
        </form>
	        </j:when>
	        <j:otherwise>
	            <h2 class="text-center">Registrese o inicie sesion</h2>
	        </j:otherwise>
    	</j:choose>
   	</main>
<script src="${pageContext.request.contextPath}/js/citas.js">
</script>
<%@ include file="footer.jsp" %>