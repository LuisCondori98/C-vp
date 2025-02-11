let user = JSON.parse(localStorage.getItem("user"))
let ccitas = document.getElementById("citas")
const divUser = document.createElement("div")
const divNewUser = document.createElement("div")

if(user) {
	
	divUser.innerHTML = `
		<h2 class="text-center mb-4">Citas</h2>
        <form action="" method="POST">
            <div class="mb-3">
                <label for="correo" class="form-label">Correo</label>
                <input type="email" class="form-control" value="${user.correo}"  readonly>
            </div>
            <div class="mb-3">
	            <label for="nombre" class="form-label">Especialidad</label>
	            <select name="especialidad" class="form-select" aria-label="Default select example">
	            	<option readonly>-- Seleccione --</option>
	            	<option value="cardiologia">Cardiologia</option>
	            	<option value="odontologia">Odontologia</option>
	            	<option value="oftalmologia">Oftalmologia</option>
	            </select>
            </div>
            <div class="mb-3">
                <label for="mensaje" class="form-label">Fecha Cita</label>
                <input type="date" class="form-control" name="fechaCita" placeholder="Eliga fecha" style="width: 200px"/>
            </div>
            <div class="mb-3">
	            <label for="nombre" class="form-label">Hora Cita</label>
	            <select name="horaCita" class="form-select" aria-label="Default select example" style="width: 200px">
	            	<option readonly>-- Seleccione --</option>
	            	<option value="1">8:00 am</option>
	            	<option value="2">8:30 am</option>
	            	<option value="3">9:00 am</option>
	            	<option value="4">9:30 am</option>
	            	<option value="5">10:00 am</option>
	            	<option value="6">10:30 am</option>
	            	<option value="7">11:00 am</option>
	            	<option value="8">11:30 am</option>
	            	<option value="9">12:00 am</option>
	            	<option value="10">12:30 pm</option>
	            	<option value="11">1:00 pm</option>
	            	<option value="12">1:30 pm</option>
	            	<option value="13">2:00 pm</option>
	            	<option value="14">2:30 pm</option>
	            	<option value="15">3:00 pm</option>
	            	<option value="16">3:30 pm</option>
	            	<option value="17">4:00 pm</option>
	            	<option value="18">4:30 pm</option>
	            	<option value="19">5:00 pm</option>
	            </select>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
	`
	
	ccitas.append(divUser)
} else {
	
	divNewUser.innerHTML = `
		<h2 class="text-center mb-4">Citas</h2>
        <form>
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" required>
            </div>
            <div class="mb-3">
	            <label for="nombre" class="form-label">Especialidad</label>
	            <select name="especialidad" class="form-select" aria-label="Default select example">
	            	<option readonly>-- Seleccione --</option>
	            	<option value="cardiologia">Cardiologia</option>
	            	<option value="odontologia">Odontologia</option>
	            	<option value="oftalmologia">Oftalmologia</option>
	            </select>
            </div>
            <div class="mb-3">
                <label for="mensaje" class="form-label">Fecha Cita</label>
                <input type="date" class="form-control" name="fechaCita" placeholder="Eliga fecha" style="width: 200px" />
            </div>
            <div class="mb-3">
	            <label for="nombre" class="form-label">Hora Cita</label>
	            <select name="horaCita" class="form-select" aria-label="Default select example" style="width: 200px">
	            	<option readonly>-- Seleccione --</option>
	            	<option value="1">8:00 am</option>
	            	<option value="2">8:30 am</option>
	            	<option value="3">9:00 am</option>
	            	<option value="4">9:30 am</option>
	            	<option value="5">10:00 am</option>
	            	<option value="6">10:30 am</option>
	            	<option value="7">11:00 am</option>
	            	<option value="8">11:30 am</option>
	            	<option value="9">12:00 am</option>
	            	<option value="10">12:30 pm</option>
	            	<option value="11">1:00 pm</option>
	            	<option value="12">1:30 pm</option>
	            	<option value="13">2:00 pm</option>
	            	<option value="14">2:30 pm</option>
	            	<option value="15">3:00 pm</option>
	            	<option value="16">3:30 pm</option>
	            	<option value="17">4:00 pm</option>
	            	<option value="18">4:30 pm</option>
	            	<option value="19">5:00 pm</option>
	            </select>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
	`
	
	ccitas.append(divNewUser)
}