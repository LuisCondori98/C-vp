package entidades;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Usuario {

	private int IdUsuario, DniUsuario, TelefonoUsuario;
	private String NombreUsuario, ApellidoUsuario, CorreoUsuario, PasswordUsuario, DireccionUsuario;
	private String RolUsuario;
	private LocalDate FechaNac;
}