package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.CitaPaciente;
import entidades.Cita;
import modelos.CitaModelo;

@WebServlet("/CitaServlet")
public class CitaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	CitaModelo citaModelo = new CitaModelo();
	
    public CitaServlet() {
    	
        super();
    }
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		switch(type) {
		
			case "Registrar": registrarCita(req, res); break;
			case "citas": verCitas(req, res); break;
			case "Buscar": buscarCita(req, res); break;
 		}
	}

	private void buscarCita(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int dni = Integer.parseInt(req.getParameter("dni"));
		
		CitaPaciente citaPac = citaModelo.citaByDni(dni);
		System.out.println(citaPac);
		req.setAttribute("citas", citaPac);
		req.getRequestDispatcher("/jsp/citas-pacientes.jsp").forward(req, res);
	}

	private void verCitas(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println(citaModelo.readCitas());
	}

	private void registrarCita(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("registrando cita......");
		
		int dniUsuario = Integer.parseInt(req.getParameter("dni"));
		String motivo = req.getParameter("motivo");
		LocalDate fechaCita = LocalDate.parse(req.getParameter("fechaCita"));
		String horaCita = req.getParameter("horaCita");
		int idDoctor = Integer.parseInt(req.getParameter("idDoctor"));
		
		//UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		//Usuario usuario = new Usuario();
		
		//usuario = usuarioModelo.getUsuarioByEmail(correo);
		
		//if(usuario.getCorreoUsuario() == correo) {
			
			Cita cita = new Cita();
			
			cita.setDniUsuario(dniUsuario);
			cita.setMotivo(motivo);
			cita.setFechaCita(fechaCita);
			cita.setHoraCita(horaCita);
			cita.setIdDoctor(idDoctor);
			
			System.out.println(cita);
			
			citaModelo.createCita(cita);
		//}
	}

}
