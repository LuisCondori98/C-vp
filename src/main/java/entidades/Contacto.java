package entidades;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Contacto {

	private int IdContacto, Telefono;
	private String Email, Mensaje;
	private LocalDate FechaEnvio;
}
