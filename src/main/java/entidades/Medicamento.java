package entidades;

import lombok.Data;

@Data
public class Medicamento {
	private int id;
    private String nombre;
    private String descripcion;
    private String laboratorio;
    private String dosis;
    private String formaFarmaceutica;
    private double precio;
    private int stock;
    private String fechaVencimiento;
    private String urlImagen;
}
