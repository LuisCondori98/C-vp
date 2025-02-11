package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.MySqlConnection;
import entidades.Cita;
import interfaces.CitaInterface;

public class CitaModelo implements CitaInterface {

	private MySqlConnection mySqlConnection;
	
	@Override
	public int createCita(Cita cita) {
		
		int value = 0;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = mySqlConnection.getConnection();
			
			String query = "INSERT INTO Cita VALUES(null, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, cita.getEspecialidad());
			ps.setDate(2, java.sql.Date.valueOf(cita.getFechaCita()));
			ps.setTime(2, java.sql.Time.valueOf(cita.getHoraCita()));
			ps.setInt(4, cita.getIdCita());
			
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
