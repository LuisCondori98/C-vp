package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.LoginDto;
import entidades.Usuario;
import modelos.UsuarioModelo;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
    	
        super();
    }
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String btn = req.getParameter("type");
		
		switch(btn) {
		
			case "Ingresar" : login(req, res); break;
			case "Registrar" : register(req, res); break;
		}
	}
	
	private void register(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String direccion = req.getParameter("direccion");
		String correo = req.getParameter("correo");
		String pass = req.getParameter("pass");
		String rol = req.getParameter("Rol");
		LocalDate fechaNac = LocalDate.parse(req.getParameter("fechaNac"));
		
		Usuario user = new Usuario();
		user.setNombreUsuario(nombre);
		user.setApellidoUsuario(apellido);
		user.setDireccionUsuario(direccion);
		user.setCorreoUsuario(correo);
		user.setPasswordUsuario(pass);
		user.setRolUsuario(rol);
		user.setFechaNac(fechaNac);
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		usuarioModelo.createUsuario(user);
		
		usuarioModelo.getUsuarioById(2);
		
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
	}

	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String correo = req.getParameter("correo");
		String pass = req.getParameter("password");
		
		UsuarioModelo usuarioModel = new UsuarioModelo();
		
		LoginDto lgdto = new LoginDto();
		
		lgdto.setCorreo(correo);
		lgdto.setPassword(pass);
		
		Usuario user = usuarioModel.logUsuario(lgdto);
		
		HttpSession session = req.getSession();
		session.setAttribute("users", user);
		res.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
		//req.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
	}
}
