package DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitaPaciente {

	private LocalDate FechaCita;
	private String HoraCita, Motivo, NombreDoctor, ApellidoDoctor;
}
