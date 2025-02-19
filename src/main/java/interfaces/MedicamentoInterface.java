package interfaces;

import java.util.List;

import entidades.Medicamento;

public interface MedicamentoInterface {
	
    public int createMedicamento(Medicamento medicamento);
    public List<Medicamento> readMedicamentos();
    public boolean updateMedicamento(Medicamento medicamento);
    public boolean deleteMedicamento(Integer id);
    public Medicamento getMedicamentoById(int id);
}
