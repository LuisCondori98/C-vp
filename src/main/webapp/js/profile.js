const user = JSON.parse(localStorage.getItem("user"))
let container = document.getElementById("container-profile")
let containerAdmin = document.getElementById("admin")

let yearArr = user.fechaNac.split("-")
let year = yearArr[0]

let birthDate = new Date().getFullYear() - parseInt(year)

console.log(user)

document.addEventListener('DOMContentLoaded',() => {
		
	const div = document.createElement("div")
	div.innerHTML = `
		<div class="card p-3" style="width: 24rem;">
		<h2>${(user.rol).toUpperCase()}</h2>
		  <img src="https://firebasestorage.googleapis.com/v0/b/my-web-6e66e.appspot.com/o/img%2Fuser-icon-512x512-x23sj495.png?alt=media&token=5d2251b0-aa92-4123-81c1-fd7f30a61695" class="card-img-top" alt="perfil">
		  <div class="card-body">
		    <h4 class="card-title text-center">${user.nombre} ${user.apellido}</h4>
		    <p class="card-text"><strong>Edad:</strong> ${birthDate}</p>
		    <p class="card-text"><strong>Direccion:</strong> ${user.direccion}</p>
		    <p class="card-text"><strong>Telefono:</strong> ${user.telefono}</p>
		    <p class="card-text"><strong>Correo:</strong> ${user.correo}</p>
		    <a href="/ProyectoFinal/UserServlet?type=Buscar&id=${user.id}" class="btn btn-primary">Editar</a>
		    <div id="admin">
		    </div>
		  </div>
		</div>
	`
	container.append(div)
})

switch(user.rol) {
	
	case "admin":{
		const btnsAdmin = document.createElement("div")
		
		btnsAdmin.innerHTML = `
			<a href="/ProyectoFinal/AdminServlet?types=doctors" class="btn btn-success">Doctores</a>
			<a href="/ProyectoFinal/AdminServlet?types=pacientes" class="btn btn-success">Pacientes</a>
			<a href="/ProyectoFinal/jsp/crearMedicamento.jsp" class="btn btn-success">Agregar Medicamento</a>
		`
		
		containerAdmin.append(btnsAdmin)
	}break;
	
	case "doctor":{
		const btnDoctor = document.createElement("div")
		
		btnDoctor.innerHTML = `
			<a href="/ProyectoFinal/jsp/citas-pacientes.jsp" class="btn btn-success">Pacientes</a>
		`
		containerAdmin.append(btnDoctor)
	}break;
	
	case "paciente":{
		const btnPaciente = document.createElement("div")
		
		btnPaciente.innerHTML = `
			<a href="/ProyectoFinal/jsp/citas-programadas.jsp" class="btn btn-success">Citas</a>
		`
		containerAdmin.append(btnPaciente)
	}break;
}