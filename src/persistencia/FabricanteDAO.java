package persistencia;

import entidades.Fabricante;
import java.util.ArrayList;
import java.util.List;

public class FabricanteDAO extends DAO {

    public void GuardarFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                throw new Exception("El fabricante no puede ser nulo");
            }
            
            String template = "INSERT INTO fabricante VALUES (NULL, '&s')";
            String sql = String.format(template, fabricante.getNombre());
            
            InsertarModificarEliminar(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar fabricante");
        }
    }

    public void ModificarFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                throw new Exception("El fabricante no puede ser nulo");
            }
            
            String template = "INSERT INTO fabricante VALUES (NULL, '%S')";
            String sql = String.format(template, fabricante.getNombre());
            
            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar fabricante");
        }
    }
    
    public void BorrarFabricante(Integer fabricanteId) throws Exception {
        try {
            String sql = "DELETE FROM fabricante WHERE codigo = " + fabricanteId + ";";
            
            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar fabricante");
        }
    }
    
    public List<Fabricante> ObtenerFabricante() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante";
            
            QueryBD(sql);
            
            List<Fabricante> fabricantes = new ArrayList<>();
            Fabricante fabricante;
            
            while (resultset.next()){
                fabricante = new Fabricante();
                fabricante.setCodigo(resultset.getInt(1));
                fabricante.setNombre(resultset.getString(2));
                
                fabricantes.add(fabricante);
            }
           
            return fabricantes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener fabricante");
        } finally {
            DesconectarBD();
        }
    }
}
