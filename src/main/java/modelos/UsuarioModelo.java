package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import DTO.LoginDto;
import db.MySqlConnection;
import entidades.Usuario;
import interfaces.UsuarioInterface;

public class UsuarioModelo implements UsuarioInterface {
	
	private MySqlConnection mySqlConnection;

	@Override
	public int createUsuario(Usuario usuario) {
		
		int value = 0;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = mySqlConnection.getConncetion();
			
			String query = "INSERT INTO Usuario VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, usuario.getNombreUsuario());
			ps.setString(2, usuario.getApellidoUsuario());
			ps.setString(3,	usuario.getDireccionUsuario());
			ps.setString(4, usuario.getCorreoUsuario());
			ps.setString(5, usuario.getPasswordUsuario());
			ps.setString(6, usuario.getRolUsuario());
			ps.setDate(7, java.sql.Date.valueOf(usuario.getFechaNac()));
			
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
	public List<Usuario> readUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUsuario(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Usuario getUsuarioById(Integer id) {
		
		Usuario usuario = null;
	
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = mySqlConnection.getConncetion();
			
			String query = "SELECT * FROM Usuario WHERE IdUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
				usuario.setDireccionUsuario(rs.getString("DireccionUsuario"));
				usuario.setCorreoUsuario(rs.getString("CorreoUsuario"));
				usuario.setPasswordUsuario(rs.getString("PasswordUsuario"));
				usuario.setRolUsuario(rs.getString("RolUsuario"));
				usuario.setFechaNac(rs.getDate("FechaNac").toLocalDate());
			}
			
			System.out.println(usuario);
			
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
		
		return usuario;
	}
	
	@Override
	public Usuario getUsuarioByEmail(String email) {
		
		Usuario usuario = null;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = mySqlConnection.getConncetion();
			
			String query = "SELECT * FROM Usuario WHERE CorreoUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
				usuario.setDireccionUsuario(rs.getString("DireccionUsuario"));
				usuario.setCorreoUsuario(rs.getString("CorreoUsuario"));
				usuario.setPasswordUsuario(rs.getString("PasswordUsuario"));
				usuario.setRolUsuario(rs.getString("RolUsuario"));
				usuario.setFechaNac(rs.getDate("FechaNac").toLocalDate());
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
		
		return usuario;
	}

	@Override
	public Usuario logUsuario(LoginDto lgdto) {
			
		Usuario usuario = new Usuario();
		
		try {
			
			usuario = getUsuarioByEmail(lgdto.getCorreo());
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return usuario;
	}
}
