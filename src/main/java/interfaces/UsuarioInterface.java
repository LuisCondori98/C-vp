package interfaces;

import java.util.List;

import DTO.LoginDto;
import entidades.Usuario;

public interface UsuarioInterface {

	public int createUsuario(Usuario usuario);
	public List<Usuario> readUsuarios();
	public boolean updateUsuario(Usuario usuario);
	public boolean deleteUsuario(Integer id);
	public Usuario getUsuarioById(Integer id);
	public Usuario getUsuarioByEmail(String email);
	public Usuario logUsuario(LoginDto lgdto);
}
