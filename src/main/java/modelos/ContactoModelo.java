package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.MySqlConnection;
import entidades.Contacto;
import interfaces.ContactoInterface;

public class ContactoModelo implements ContactoInterface {

	@Override
	public int createConsulta(Contacto contacto) {
		
int value = 0;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "INSERT INTO CONTACTO(Email, Telefono, Mensaje) VALUES(?, ?, ?)";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, contacto.getEmail());
			ps.setInt(2, contacto.getTelefono());
			ps.setString(3, contacto.getMensaje());
			
			value = ps.executeUpdate();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (ps != null)
					
					ps.close();
				if (con != null)
					
					con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return value;
	}

}
