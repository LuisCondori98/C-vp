package entidades;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Cita {

	private int IdCita, DniUsuario, IdDoctor;
	private String Motivo, HoraCita;
	private LocalDate FechaCita;
}
