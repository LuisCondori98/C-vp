package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entidades.Medicamento;
import modelos.MedicamentoModel;

@WebServlet("/MedicamentoServlet")
public class MedicamentoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MedicamentoServlet() {
    	
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch(action) {
            case "create": createMedicamento(req, res); break;
            case "update": updateMedicamento(req, res); break;
            case "delete": deleteMedicamento(req, res); break;
            case "list": listMedicamentos(req, res); break;
            case "get": getMedicamento(req, res); break;
            default: res.sendRedirect("error.jsp"); break;
        }
    }

    private void getMedicamento(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	try {
            int id = Integer.parseInt(req.getParameter("id"));
            MedicamentoModel medicamentoModel = new MedicamentoModel();
            Medicamento medicamento = medicamentoModel.getMedicamentoById(id);

            if (medicamento != null) {
                req.setAttribute("medicamento", medicamento);
                req.getRequestDispatcher("/jsp/actualizarMedicamento.jsp").forward(req, res);
            } else {
                res.sendRedirect("MedicamentoServlet?action=list"); 
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            res.sendRedirect("error.jsp"); 
        }
	}

	private void createMedicamento(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
		String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String laboratorio = req.getParameter("laboratorio");
        String dosis = req.getParameter("dosis");
        String formaFarmaceutica = req.getParameter("formaFarmaceutica");
        double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String fechaVencimiento = req.getParameter("fechaVencimiento");
        
        Part imagenPart = req.getPart("imagen");  
        String imagenPath = null;

        System.out.println(nombre + precio + stock + fechaVencimiento + imagenPart + imagenPath);
        
        /*if (imagenPart != null) {
        
            String fileName = imagenPart.getSubmittedFileName();

            String rutaDestino = getServletContext().getRealPath("/img/saved/medicamentos/");
            File file = new File(rutaDestino + fileName);
            imagenPart.write(file.getAbsolutePath());
            
            imagenPath = fileName;
        }

        Medicamento medicamento = new Medicamento();
        
        medicamento.setNombre(nombre);
        medicamento.setDescripcion(descripcion);
        medicamento.setLaboratorio(laboratorio);
        medicamento.setDosis(dosis);
        medicamento.setFormaFarmaceutica(formaFarmaceutica);
        medicamento.setPrecio(precio);
        medicamento.setStock(stock);
        medicamento.setFechaVencimiento(fechaVencimiento);
        medicamento.setUrlImagen(imagenPath);
        
        MedicamentoModel medicamentoModel = new MedicamentoModel();
        int result = medicamentoModel.createMedicamento(medicamento);

        if (result > 0) {
            res.sendRedirect(req.getContextPath() + "/MedicamentoServlet?action=list");
        } else {
            res.getWriter().write("Error al crear medicamento.");
        }*/
    }

    private void updateMedicamento(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
    	try {
            int id = Integer.parseInt(req.getParameter("id"));
            String nombre = req.getParameter("nombre");
            String descripcion = req.getParameter("descripcion");
            String laboratorio = req.getParameter("laboratorio");
            String dosis = req.getParameter("dosis");
            String formaFarmaceutica = req.getParameter("formaFarmaceutica");

            double precio = Double.parseDouble(req.getParameter("precio"));
            int stock = Integer.parseInt(req.getParameter("stock"));
            String fechaVencimiento = req.getParameter("fechaVencimiento");

            MedicamentoModel medicamentoModel = new MedicamentoModel();
            Medicamento medicamento = medicamentoModel.getMedicamentoById(id);
            if (medicamento == null) {
                res.getWriter().write("Medicamento no encontrado.");
                return;
            }

            // Procesar la nueva imagen si se ha subido
            Part imagenPart = req.getPart("imagen"); 
            String imagenPath = medicamento.getUrlImagen(); 

            if (imagenPart != null && imagenPart.getSize() > 0) {
                String fileName = imagenPart.getSubmittedFileName();
                String rutaDestino = getServletContext().getRealPath("/img/saved/medicamentos/");
                File file = new File(rutaDestino + fileName);
                imagenPart.write(file.getAbsolutePath());
                imagenPath = fileName; 
            }

            // Actualizar datos
            medicamento.setNombre(nombre);
            medicamento.setDescripcion(descripcion);
            medicamento.setLaboratorio(laboratorio);
            medicamento.setDosis(dosis);
            medicamento.setFormaFarmaceutica(formaFarmaceutica);
            medicamento.setPrecio(precio);
            medicamento.setStock(stock);
            medicamento.setFechaVencimiento(fechaVencimiento);
            medicamento.setUrlImagen(imagenPath);

            boolean result = medicamentoModel.updateMedicamento(medicamento);

            if (result) {
                res.sendRedirect(req.getContextPath() + "/MedicamentoServlet?action=list");
            } else {
                res.getWriter().write("Error al actualizar medicamento.");
            }
        } catch (NumberFormatException e) {
            res.getWriter().write("Error en los datos numéricos: " + e.getMessage());
        } catch (Exception e) {
            res.getWriter().write("Error al actualizar medicamento: " + e.getMessage());
        }
    }

    private void deleteMedicamento(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	int id = Integer.parseInt(req.getParameter("id"));

        MedicamentoModel medicamentoModel = new MedicamentoModel();
        boolean result = medicamentoModel.deleteMedicamento(id);

        if(result) {
            res.sendRedirect(req.getContextPath() + "/MedicamentoServlet?action=list");
        } else {
            res.getWriter().write("Error al eliminar medicamento.");
        }
    }

    private void listMedicamentos(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MedicamentoModel medicamentoModel = new MedicamentoModel();
        List<Medicamento> medicamentos = medicamentoModel.readMedicamentos();

        req.setAttribute("medicamentos", medicamentos);
        req.getRequestDispatcher("/jsp/listarMedicamentos.jsp").forward(req, res);
    }
}