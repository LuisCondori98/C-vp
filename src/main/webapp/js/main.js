console.log("main")

const userExist = JSON.parse(localStorage.getItem("user"))
const logeo = document.getElementById("logeo")
const containerlog = document.getElementById("container-log")
const logout = document.getElementById("logout")
const divlog = document.createElement("li")

if(userExist) {
	
	logeo.style.display = "none"
	
	divlog.innerHTML = `
		<button class="btn btn-primary m-2">${userExist.nombre}</button>
	`
	
	containerlog.append(divlog)
} else {
	
	logeo.style.display = "flex"
	divlog.style.display = "none"
}

logout.addEventListener("click", () => {
	
	localStorage.removeItem("user")
	
	window.location.href = "/ProyectoFinal/jsp/index.jsp";
})