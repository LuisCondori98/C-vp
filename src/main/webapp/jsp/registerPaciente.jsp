<%@ page import="java.util.List"%>
<%@ include file="header.jsp" %>
	<main>
		<section id="paciente" class="container py-5">
	        <h2 class="text-center mb-4">Registrar Paciente</h2>
	        <form action="<%= request.getContextPath() %>/PacienteServlet" class="w-25 m-auto">
	            <div class="mb-3">
	                <input type="text" class="form-control" name="nombre" placeholder="Nombres" required>
	            </div>
	            <div class="mb-3">
	                <input type="text" class="form-control" name="apellido" placeholder="Apellidos" required>
	            </div>
	            <div class="mb-3">
	                <input type="email" class="form-control" name="email" placeholder="Correo" required>
	            </div>
	            <div class="mb-3">
	                <input type="date" class="form-control" name="fechaNac" required>
	            </div>
	            <div class="mb-3">
	                <input type="text" class="form-control" name="direccion" placeholder="Direccion" required>
	            </div>
	            <!--<div class="mb-3">
	                <textarea class="form-control" id="mensaje" rows="4" placeholder="Escribe tu mensaje" required></textarea>
	            </div>--->
	            <input type="submit" name="submit" value="Registrar" class="btn btn-primary" />
	        </form>
	        <form action="<%= request.getContextPath() %>/PacienteServlet">
	        	<input type="submit" name="submit" value="Listar" class="btn btn-success" />
	        </form>
	    </section>
	    <section>
	    	<table class="table table-striped">
			  <thead>
			    <tr class="table-dark">
			      <th scope="col">Id</th>
			      <th scope="col">Nombres</th>
			      <th scope="col">Apellidos</th>
			      <th scope="col">Correo</th>
			      <th scope="col">Fecha Nacimiento</th>
			      <th scope="col">Direccion</th>
			      <th scope="col">Accion</th>
			    </tr>
			  </thead>
			  <!-- <tbody>
			    <%
			    	//List<Paciente> listaPaciente = (List<Paciente>) request.getAttribute("data");
			    	//if (listaPaciente != null) {
			    		//for(Paciente pac : listaPaciente){
			    %>
			    <tr>
			      <th><%= pac.getIdPaciente() %></th>
			      <td><%= pac.getNombrePaciente() %></td>
			      <td><%= pac.getApellidoPaciente() %></td>
			      <td><%= pac.getCorreoPaciente() %></td>
			      <td><%= pac.getFechaNacPaciente() %></td>
			      <td><%= pac.getDireccionPaciente() %></td>
			      <td>
			      	<a href="" class="btn btn-info">Editar</a>
			      	<a href="" class="btn btn-danger">Eliminar</a>
			      </td>
			    </tr>
			    <%
			    		}
			    	}
			    %>
			  </tbody>-->
			</table>
	    </section>
   	</main>
<%@ include file="footer.jsp" %>