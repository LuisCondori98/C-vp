package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.CitaPaciente;
import db.MySqlConnection;
import entidades.Cita;
import interfaces.CitaInterface;

public class CitaModelo implements CitaInterface {
	
	@Override
	public int createCita(Cita cita) {
		
		int value = 0;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "INSERT INTO Cita VALUES(null, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, cita.getDniUsuario());
			ps.setString(2, cita.getMotivo());
			ps.setDate(3, java.sql.Date.valueOf(cita.getFechaCita()));
			ps.setString(4, cita.getHoraCita());
			ps.setInt(5, cita.getIdDoctor());
			
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

	@Override
	public List<Cita> readCitas() {
		
		List<Cita> citas = new ArrayList<>();
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "SELECT * FROM Cita";
			
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Cita cita = new Cita();
				
				cita.setIdCita(rs.getInt("IdCita"));
				cita.setMotivo(rs.getString("Especialidad"));
				cita.setFechaCita(rs.getDate("FechaCita").toLocalDate());
				cita.setHoraCita(rs.getString("HoraCita"));
				cita.setIdDoctor(rs.getInt("IdDoctor"));
				
				citas.add(cita);
			}
			
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
		
		return citas;
	}

	@Override
	public CitaPaciente citaByDni(Integer dni) {
		
		CitaPaciente citaPac = null;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "SELECT * FROM vista_paciente_cita WHERE DniUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, dni);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				citaPac = new CitaPaciente();
				
				citaPac.setMotivo(rs.getString("Motivo"));
				citaPac.setFechaCita(rs.getDate("FechaCita").toLocalDate());
				citaPac.setHoraCita(rs.getString("HoraCita"));
				citaPac.setNombreDoctor(rs.getString("NombreDoctor"));
				citaPac.setApellidoDoctor(rs.getString("ApellidoDoctor"));
			}
			
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
		
		return citaPac;
	}

	@Override
	public List<CitaPaciente> citasPacientes(Integer id) {
		
		return null;
	}

}
