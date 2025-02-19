package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import entidades.Medicamento;
import interfaces.MedicamentoInterface;

public class MedicamentoModel implements MedicamentoInterface {

    @Override
    public int createMedicamento(Medicamento medicamento) {
    	
        int value = 0;
        
        Connection cn = null;
        
        PreparedStatement psm = null;

        try {
        	
            cn = MySqlConnection.getConnection();
            
            String query = "INSERT INTO Medicamento (Nombre, Descripcion, Laboratorio, Dosis, FormaFarmaceutica, Precio, Stock, FechaVencimientp, urlImagen) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            psm = cn.prepareStatement(query);

            psm.setString(1, medicamento.getNombre());
            psm.setString(2, medicamento.getDescripcion());
            psm.setString(3, medicamento.getLaboratorio());
            psm.setString(4, medicamento.getDosis());
            psm.setString(5, medicamento.getFormaFarmaceutica());
            psm.setDouble(6, medicamento.getPrecio());
            psm.setInt(7, medicamento.getStock());
            psm.setDate(8, java.sql.Date.valueOf(medicamento.getFechaVencimiento()));
            psm.setString(9, medicamento.getUrlImagen());

            value = psm.executeUpdate();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
        } finally {
        	
            try {
            	
                if (psm != null) psm.close();
                
                if (cn != null) cn.close();
            } catch (Exception e) {
            	
                e.printStackTrace();
            }
        }
        
        return value;
    }

    @Override
    public List<Medicamento> readMedicamentos() {
        
    	List<Medicamento> medicamentos = new ArrayList<>();
        Connection cn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;

        try {
            cn = MySqlConnection.getConnection();
            String query = "SELECT * FROM Medicamento";
            psm = cn.prepareStatement(query);
            rs = psm.executeQuery();

            while (rs.next()) {
            	
                Medicamento medicamento = new Medicamento();
                
                medicamento.setId(rs.getInt("id"));
                medicamento.setNombre(rs.getString("Nombre"));
                medicamento.setDescripcion(rs.getString("Descripcion"));
                medicamento.setLaboratorio(rs.getString("Laboratorio"));
                medicamento.setDosis(rs.getString("Dosis"));
                medicamento.setFormaFarmaceutica(rs.getString("FormaFarmaceutica"));
                medicamento.setPrecio(rs.getDouble("Precio"));
                medicamento.setStock(rs.getInt("Stock"));
                medicamento.setFechaVencimiento(rs.getString("FechaVencimientp"));
                medicamento.setUrlImagen(rs.getString("urlImagen"));
                
                medicamentos.add(medicamento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (psm != null) psm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return medicamentos;
    }

    @Override
    public boolean updateMedicamento(Medicamento medicamento) {
        boolean updated = false;
        Connection cn = null;
        PreparedStatement psm = null;

        try {
            cn = MySqlConnection.getConnection();
            String query = "UPDATE Medicamento SET Nombre = ?, Descripcion = ?, Laboratorio = ?, Dosis = ?, FormaFarmaceutica = ?, Precio = ?, Stock = ?, FechaVencimientp = ?, urlImagen = ? WHERE id = ?";
            psm = cn.prepareStatement(query);

            psm.setString(1, medicamento.getNombre());
            psm.setString(2, medicamento.getDescripcion());
            psm.setString(3, medicamento.getLaboratorio());
            psm.setString(3, medicamento.getDosis());
            psm.setString(4, medicamento.getFormaFarmaceutica());
            psm.setDouble(5, medicamento.getPrecio());
            psm.setInt(7, medicamento.getStock());
            psm.setDate(8, java.sql.Date.valueOf(medicamento.getFechaVencimiento()));
            psm.setString(9, medicamento.getUrlImagen());
            psm.setInt(10, medicamento.getId());

            int rowsAffected = psm.executeUpdate();
            updated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (psm != null) psm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return updated;
    }

    @Override
    public boolean deleteMedicamento(Integer id) {
        boolean deleted = false;
        Connection cn = null;
        PreparedStatement psm = null;

        try {
            cn = MySqlConnection.getConnection();
            String query = "DELETE FROM Medicamento WHERE id = ?";
            psm = cn.prepareStatement(query);
            psm.setInt(1, id);

            int rowsAffected = psm.executeUpdate();
            deleted = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (psm != null) psm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return deleted;
    }
    
    @Override
	public Medicamento getMedicamentoById(int id) {
		// TODO Auto-generated method stub
		 Medicamento medicamento = null;
	        Connection cn = null;
	        PreparedStatement psm = null;
	        ResultSet rs = null;

	        try {
	            cn = MySqlConnection.getConnection();
	            String query = "SELECT * FROM Medicamento WHERE id = ?";
	            psm = cn.prepareStatement(query);
	            psm.setInt(1, id);
	            rs = psm.executeQuery();

	            if (rs.next()) {
	                medicamento = new Medicamento();
	                medicamento.setId(rs.getInt("id"));
	                medicamento.setNombre(rs.getString("Nombre"));
	                medicamento.setDescripcion(rs.getString("Descripcion"));
	                medicamento.setLaboratorio(rs.getString("Laboratorio"));
	                medicamento.setDosis(rs.getString("Dosis"));
	                medicamento.setFormaFarmaceutica(rs.getString("FormaFarmaceutica"));
	                medicamento.setPrecio(rs.getDouble("Precio"));
	                medicamento.setStock(rs.getInt("Stock"));
	                medicamento.setFechaVencimiento(rs.getString("FechaVencimientp"));
	                medicamento.setUrlImagen(rs.getString("urlImagen"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (psm != null) psm.close();
	                if (cn != null) cn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return medicamento;
	}
}