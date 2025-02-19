package interfaces;

import java.util.List;

import DTO.CitaPaciente;
import entidades.Cita;

public interface CitaInterface {

	public int createCita(Cita cita);
	public List<Cita> readCitas();
	public CitaPaciente citaByDni(Integer dni);
	public List<CitaPaciente> citasPacientes(Integer id);
}
