package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Contacto;
import modelos.ContactoModelo;

@WebServlet("/ContactoServlet")
public class ContactoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ContactoModelo contactoModelo = new ContactoModelo();
	
    public ContactoServlet() {
    	
        super();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");
		
		switch(type) {
			
			case "crear": crearConsulta(req, res); break;
		}
	}

	private void crearConsulta(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String correo = req.getParameter("email");
		int telefono = Integer.parseInt(req.getParameter("telefono"));
		String mensaje = req.getParameter("mensaje");
		
		Contacto contacto = new Contacto();
		
		contacto.setEmail(correo);
		contacto.setTelefono(telefono);
		contacto.setMensaje(mensaje);
		
		contactoModelo.createConsulta(contacto);
		
		req.setAttribute("msgg", "Formulario enviado");
		req.getRequestDispatcher("/jsp/contacto.jsp").forward(req, res);
	}

}
