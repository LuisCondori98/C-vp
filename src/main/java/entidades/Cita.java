package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Cita {

	private int IdCita, IdUsuario;
	private String Especialidad;
	private LocalDate FechaCita;
	private LocalTime HoraCita;
}
