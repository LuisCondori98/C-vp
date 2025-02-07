package DTO;

import lombok.Data;

@Data
public class LoginDto {

	private int IdUsuario;
	private String correo;
	private String password;
}
