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
    private MySqlConnection mySqlConnection;

    @Override
    public int createMedicamento(Medicamento medicamento) {
        int value = 0;
        Connection cn = null;
        PreparedStatement psm = null;

        try {
            cn = mySqlConnection.getConnection();
            String query = "INSERT INTO Medicamento (Nombre, Descripcion, Laboratorio, via_suministro, presentacion, concentracion, stock, fecha_vencimiento) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            psm = cn.prepareStatement(query);

            psm.setString(1, medicamento.getNombre());
            psm.setString(2, medicamento.getDescripcion());
            psm.setString(3, medicamento.getLaboratorio());
            psm.setString(3, medicamento.getDosis());
            psm.setString(4, medicamento.getFormaFarmaceutica());
            psm.setDouble(5, medicamento.getPrecio());
            psm.setInt(7, medicamento.getStock());
            psm.setDate(8, java.sql.Date.valueOf(medicamento.getFechaVencimiento()));

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
            cn = mySqlConnection.getConnection();
            String query = "SELECT * FROM Medicamento";
            psm = cn.prepareStatement(query);
            rs = psm.executeQuery();

            while (rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(rs.getInt("IdMedicamento"));
                medicamento.setNombre(rs.getString("Nombre"));
                medicamento.setDescripcion(rs.getString("Descripcion"));
                medicamento.setLaboratorio(rs.getString("Laboratorio"));
                medicamento.setDosis(rs.getString("Dosis"));
                medicamento.setFormaFarmaceutica(rs.getString("FormaFarmaceutica"));
                medicamento.setPrecio(rs.getDouble("Precio"));
                medicamento.setStock(rs.getInt("Stock"));
                medicamento.setFechaVencimiento(rs.getDate("FechaVencimientp").toLocalDate());
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
            cn = mySqlConnection.getConnection();
            String query = "UPDATE Medicamento SET nombre = ?, descripcion = ?, laboratorio = ?, via_suministro = ?, presentacion = ?, concentracion = ?, stock = ?, fecha_vencimiento = ? WHERE id = ?";
            psm = cn.prepareStatement(query);

            psm.setString(1, medicamento.getNombre());
            psm.setString(2, medicamento.getDescripcion());
            psm.setString(3, medicamento.getLaboratorio());
            psm.setString(3, medicamento.getDosis());
            psm.setString(4, medicamento.getFormaFarmaceutica());
            psm.setDouble(5, medicamento.getPrecio());
            psm.setInt(7, medicamento.getStock());
            psm.setDate(8, java.sql.Date.valueOf(medicamento.getFechaVencimiento()));
            psm.setInt(9, medicamento.getId());

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
            cn = mySqlConnection.getConnection();
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
}