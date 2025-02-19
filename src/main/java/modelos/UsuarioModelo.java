package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.LoginDto;
import db.MySqlConnection;
import entidades.Usuario;
import interfaces.UsuarioInterface;

public class UsuarioModelo implements UsuarioInterface {

	@Override
	public int createUsuario(Usuario usuario) {
		
		int value = 0;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "INSERT INTO Usuario VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, usuario.getDniUsuario());
			ps.setString(2, usuario.getNombreUsuario());
			ps.setString(3, usuario.getApellidoUsuario());
			ps.setInt(4, usuario.getTelefonoUsuario());
			ps.setString(5,	usuario.getDireccionUsuario());
			ps.setString(6, usuario.getCorreoUsuario());
			ps.setString(7, usuario.getPasswordUsuario());
			ps.setString(8, usuario.getRolUsuario());
			ps.setDate(9, java.sql.Date.valueOf(usuario.getFechaNac()));
			
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
		
		List<Usuario> usuarios = new ArrayList<>();
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "SELECT * FROM Usuario";
			
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setDniUsuario(rs.getInt("DniUsuario"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
				usuario.setTelefonoUsuario(rs.getInt("TelefonoUsuario"));
				usuario.setDireccionUsuario(rs.getString("DireccionUsuario"));
				usuario.setCorreoUsuario(rs.getString("CorreoUsuario"));
				usuario.setRolUsuario(rs.getString("RolUsuario"));
				usuario.setFechaNac(rs.getDate("FechaNac").toLocalDate());
				
				usuarios.add(usuario);
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
		
		return usuarios;
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		
		boolean success = false;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "UPDATE Usuario SET DniUsuario = ?, NombreUsuario = ?, ApellidoUsuario = ?, TelefonoUsuario = ?, DireccionUsuario = ?, CorreoUsuario = ?, FechaNac = ? WHERE IdUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, usuario.getDniUsuario());
			ps.setString(2, usuario.getNombreUsuario());
			ps.setString(3, usuario.getApellidoUsuario());
			ps.setInt(4, usuario.getTelefonoUsuario());
			ps.setString(5, usuario.getDireccionUsuario());
			ps.setString(6, usuario.getCorreoUsuario());
			ps.setDate(7, java.sql.Date.valueOf(usuario.getFechaNac()));
			ps.setInt(8, usuario.getIdUsuario());
			
			success = ps.executeUpdate() > 0;
			
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
		
		return success;
	}

	@Override
	public boolean deleteUsuario(Integer id) {
		
		boolean success = false;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "DELETE FROM Usuario WHERE IdUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			success = ps.executeUpdate() > 0;
			
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
		
		return success;
	}
	
	@Override
	public Usuario getUsuarioById(Integer id) {
		
		Usuario usuario = null;
	
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "SELECT * FROM Usuario WHERE IdUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setDniUsuario(rs.getInt("DniUsuario"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
				usuario.setTelefonoUsuario(rs.getInt("TelefonoUsuario"));
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
	public List<Usuario> getUsuariosByRol(String rol) {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "SELECT * FROM Usuario WHERE RolUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, rol);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setDniUsuario(rs.getInt("DniUsuario"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
				usuario.setTelefonoUsuario(rs.getInt("TelefonoUsuario"));
				usuario.setDireccionUsuario(rs.getString("DireccionUsuario"));
				usuario.setCorreoUsuario(rs.getString("CorreoUsuario"));
				usuario.setRolUsuario(rs.getString("RolUsuario"));
				usuario.setFechaNac(rs.getDate("FechaNac").toLocalDate());
				
				usuarios.add(usuario);
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
		
		return usuarios;
	}
	
	@Override
	public Usuario getUsuarioByEmailAndPass(String email, String pass) {
		
		Usuario usuario = null;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "SELECT * FROM Usuario WHERE CorreoUsuario = ? AND PasswordUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setDniUsuario(rs.getInt("DniUsuario"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
				usuario.setTelefonoUsuario(rs.getInt("TelefonoUsuario"));
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
			
			usuario = getUsuarioByEmailAndPass(lgdto.getCorreo(), lgdto.getPassword());
			lgdto.setIdUsuario(usuario.getIdUsuario());
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return usuario;
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		
		Usuario usuario = new Usuario();
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "SELECT * FROM Usuario WHERE CorreoUsuario = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setDniUsuario(rs.getInt("DniUsuario"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setApellidoUsuario(rs.getString("ApellidoUsuario"));
				usuario.setTelefonoUsuario(rs.getInt("TelefonoUsuario"));
				usuario.setDireccionUsuario(rs.getString("DireccionUsuario"));
				usuario.setCorreoUsuario(rs.getString("CorreoUsuario"));
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
		System.out.println(usuario);
		return usuario;
	}
}
