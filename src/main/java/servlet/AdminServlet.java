package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;
import modelos.UsuarioModelo;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
    	
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String type = req.getParameter("types");
		
		switch(type) {
		
			case "doctors": listarDoctores(req, res); break;
			case "pacientes": listarPacientes(req, res); break;
		}
	}

	private void listarPacientes(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		List<Usuario> pacients = usuarioModelo.getUsuariosByRol("paciente");
		
		req.setAttribute("pacientes", pacients);
		req.getRequestDispatcher("/jsp/pacientes.jsp").forward(req, res);
	}

	private void listarDoctores(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		List<Usuario> doctores = usuarioModelo.getUsuariosByRol("doctor");
		
		req.setAttribute("doctors", doctores);
		req.getRequestDispatcher("/jsp/doctores.jsp").forward(req, res);
	}

}
