package servicios;

import java.util.Scanner;

public class MenuServicios {

    ProductoServicios productoServicios = new ProductoServicios();
    FabricanteServicios fabricanteServicios = new FabricanteServicios();

    Scanner entrada = new Scanner(System.in);

    public void Menu() throws Exception {
        try {
            System.out.println("-----Menu-----\n"
                    + "a) Lista el nombre de todos los productos que hay en la tabla producto.\n"
                    + "b) Lista los nombres y los precios de todos los productos de la tabla producto.\n"
                    + "c) Listar aquellos productos que su precio esté entre 120 y 202.\n"
                    + "d) Buscar y listar todos los Portátiles de la tabla producto.\n"
                    + "e) Listar el nombre y el precio del producto más barato.\n"
                    + "f) Ingresar un producto a la base de datos.\n"
                    + "g) Ingresar un fabricante a la base de datos\n"
                    + "h) Editar un producto con datos a elección\n"
                    + "i) Salir.");
            
            System.out.println("Seleccione una opción: ");
            String respuesta = entrada.next();
            OpcionSeleccionada(respuesta);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Debes ingresar una opcion valida");
        }

    }

    public void OpcionSeleccionada(String respuesta) throws Exception {
        try {
            switch (respuesta.toLowerCase()) {
                case "a":
                    productoServicios.mostrarProductos();
                    Menu();
                    break;
                case "b":
                    productoServicios.MostrarPorNombreyPrecio();
                    Menu();
                    break;
                case "c":
                    productoServicios.MostrarProductoPrecio120y202();
                    Menu();
                    break;
                case "d":
                    productoServicios.MostrarProductoPortatiles();
                    Menu();
                    break;
                case "e":
                    productoServicios.MostrarProductoMenorPrecio();
                    Menu();
                    break;
                case "f":
                    productoServicios.CrearProducto();
                    Menu();
                    break;
                case "g":
                    fabricanteServicios.CrearFabricante();
                    Menu();
                    break;
                case "h":
                    productoServicios.ModificarProducto();
                    Menu();
                    break;
                case "i":
                    System.out.println("Consulta finalizada.");
                    break;
                default:

                    System.out.println("Ingrese una opcion valida");
                    Menu();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("No se pudo consultar las opciones");
        }
    }

}
