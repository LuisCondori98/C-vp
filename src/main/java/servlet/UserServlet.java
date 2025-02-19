package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;
import modelos.UsuarioModelo;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public UserServlet() {
    	
        super();
    }
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String btn = req.getParameter("type");
		
		switch(btn) {
		
			case "Registrar" : crearUsuario(req, res); break;
			case "Listar" : listarUsuarios(req, res); break;
			case "Modificar" : modificarUsuario(req, res); break;
			case "Eliminar" : eliminarUsuario(req, res); break;
			case "Buscar" : buscarUsuario(req, res); break;
		}
	}

	private void crearUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Integer dni = Integer.parseInt(req.getParameter("dni"));
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		Integer telefono = Integer.parseInt(req.getParameter("telefono"));
		String direccion = req.getParameter("direccion");
		String correo = req.getParameter("correo");
		String pass = req.getParameter("pass");
		String rol = req.getParameter("Rol");
		LocalDate fechaNac = LocalDate.parse(req.getParameter("fechaNac"));
		
		Usuario user = new Usuario();
		
		user.setDniUsuario(dni);
		user.setNombreUsuario(nombre);
		user.setApellidoUsuario(apellido);
		user.setTelefonoUsuario(telefono);
		user.setDireccionUsuario(direccion);
		user.setCorreoUsuario(correo);
		user.setPasswordUsuario(pass);
		user.setRolUsuario(rol);
		user.setFechaNac(fechaNac);
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		usuarioModelo.createUsuario(user);
		
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
	}

	private void listarUsuarios(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<Usuario> users;
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		users = usuarioModelo.readUsuarios();
		
		req.setAttribute("usuarios", users);
		//req.getRequestDispatcher("/jsp/doctores.jsp").forward(req, res);
	}
	
	private void modificarUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		int dni = Integer.parseInt(req.getParameter("dni"));
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		int telefono = Integer.parseInt(req.getParameter("telefono"));
		String direccion = req.getParameter("direccion");
		String correo = req.getParameter("correo");
		LocalDate fechaNac = LocalDate.parse(req.getParameter("fechaNac"));
		
		Usuario usuario = new Usuario();
		
		usuario.setIdUsuario(id);
		usuario.setDniUsuario(dni);
		usuario.setNombreUsuario(nombre);
		usuario.setApellidoUsuario(apellido);
		usuario.setTelefonoUsuario(telefono);
		usuario.setDireccionUsuario(direccion);
		usuario.setCorreoUsuario(correo);
		usuario.setFechaNac(fechaNac);
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		usuarioModelo.updateUsuario(usuario);
		
		req.getRequestDispatcher("/jsp/profile.jsp").forward(req, res);
	}

	private void eliminarUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		usuarioModelo.deleteUsuario(id);
		
		req.getRequestDispatcher("/AdminServlet?types=pacientes").forward(req, res);
	}

	private void buscarUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		Usuario usuario = usuarioModelo.getUsuarioById(id);
		
		req.setAttribute("user", usuario);
		req.getRequestDispatcher("/jsp/editaruser.jsp").forward(req, res);
	}
}
