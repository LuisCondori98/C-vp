const userExist = JSON.parse(localStorage.getItem("user"))
const logeo = document.getElementById("logeo")
const btnLogin = document.getElementById("login")
const containerlog = document.getElementById("container-log")
const logout = document.getElementById("logout")
const register = document.getElementById("register")
const divlog = document.createElement("li")

if(userExist) {
	
	logeo.style.display = "none"
	register.style.display = "none"
	
	divlog.innerHTML = `
		<a href="/ProyectoFinal/jsp/profile.jsp" class="btn btn-primary m-2">${userExist.nombre}</a>
	`
	
	containerlog.append(divlog)
} else {
	
	logout.style.display = "none"
	logeo.style.display = "flex"
	divlog.style.display = "none"
}

logout.addEventListener("click", () => {
	
	localStorage.removeItem("user")
	
	window.location.href = "/ProyectoFinal/jsp/index.jsp";
})

btnLogin.addEventListener("click", () => {
	
	window.location.href()
})