package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
			case "Logout" : logout(req, res); break;
		}
	}

	private void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.removeAttribute("userss");
		
		res.sendRedirect("/ProyectoFinal/jsp/index.jsp");
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
		session.setAttribute("userss", user);
		
		if(user != null) {
			
			res.sendRedirect("/ProyectoFinal/jsp/profile.jsp");
		} else {
			
			req.setAttribute("mensaje", "Error, usuario o contraseña erronea");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
		}
	}
}
