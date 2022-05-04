
package servicios;

import entidades.Fabricante;
import java.util.Scanner;
import persistencia.FabricanteDAO;


public class FabricanteServicios {
    
    private FabricanteDAO fabricanteDAO = new FabricanteDAO();
    Scanner entrada = new Scanner(System.in);

public void CrearFabricante() throws Exception{
    
    Fabricante fabricante = new Fabricante();
    
    try {
        
        System.out.println("Ingrese el nombre del fabricante");
        String nombre = entrada.next();
        fabricante.setNombre(nombre);
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe contener un nombre");
        }
        
        fabricanteDAO.GuardarFabricante(fabricante);
    } catch (Exception e) {
        throw e;
    }
    
}
    
}
