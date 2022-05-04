package servicios;

import entidades.Fabricante;
import entidades.Producto;
import java.util.List;
import java.util.Scanner;
import persistencia.ProductoDAO;

public class ProductoServicios {

    private ProductoDAO productoDAO = new ProductoDAO();
    Scanner entrada = new Scanner(System.in);

    public void mostrarProductos() throws Exception {

        try {
            List<Producto> productos = productoDAO.ObtenerProducto();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene productos");

            } else {

                System.out.println("Lista de productos");
                System.out.printf("%-15s%-40s\n", "ID", "Nombre");
                for (Producto producto : productos) {
                    System.out.printf("%-15s%-40s\n", producto.getCodigo(), producto.getNombre());

                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void MostrarPorNombreyPrecio() throws Exception {
        try {
            List<Producto> productos = productoDAO.ObtenerProducto();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene productos");

            } else {

                System.out.println("Lista de productos");
                System.out.printf("%-15s%-40s%-40s\n", "ID", "Nombre", "Precio");
                for (Producto producto : productos) {
                    System.out.printf("%-15s%-40s%-40s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio());

                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void MostrarProductoPrecio120y202() throws Exception {
        try {
            List<Producto> productos = productoDAO.ObtenerProductosPreciosEntre120y202();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene productos");

            } else {

                System.out.println("Lista de productos");
                System.out.printf("%-15s%-40s%-40s\n", "ID", "Nombre", "Precio");
                for (Producto producto : productos) {
                    System.out.printf("%-15s%-40s%-40s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio());

                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void MostrarProductoPortatiles() throws Exception {
        try {
            List<Producto> productos = productoDAO.ObtenerPortatiles();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene productos");

            } else {

                System.out.println("Lista de productos");
                System.out.printf("%-15s%-40s%-40s%-20s\n", "ID", "Nombre", "Precio", "Código Fabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-15s%-40s%-40s%-20s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCodigo());

                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void MostrarProductoMenorPrecio() throws Exception {
        try {
            List<Producto> productos = productoDAO.ObtenerProductoDeMenorPrecio();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene productos");

            } else {

                System.out.println("Lista de productos");
                System.out.printf("%-40s%-40s\n", "Nombre", "Precio");
                for (Producto producto : productos) {
                    System.out.printf("%-40s%-40s\n", producto.getNombre(), producto.getPrecio());

                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void CrearProducto() throws Exception {

        Producto producto = new Producto();
        Fabricante fabricante = new Fabricante();

        try {
            System.out.println("Ingrese el nombre del producto");
            String nombre = entrada.next();
            producto.setNombre(nombre);

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe contener un nombre");

            }
            

            System.out.println("Ingrese el precio del producto");
            Double precio = entrada.nextDouble();
            producto.setPrecio(precio);

            System.out.println("Ingrese el codigo del fabricante del producto");
            int codigoFabricante = entrada.nextInt();
            fabricante.setCodigo(codigoFabricante);
            producto.setFabricante(fabricante);

            productoDAO.GuardarProducto(producto);
        } catch (Exception e) {
        }

    }

    public void ModificarProducto() throws Exception {

        try {
            System.out.println("Seleccione el codigo del producto que desea modificar");
            int codigo = entrada.nextInt();

            System.out.println("El producto seleccionado es: ");

            List<Producto> productos = productoDAO.ObtenerProductoPorCodigo(codigo);
            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene productos");

            } else {
                System.out.printf("%-15s%-40s%-45s%-40s%-40s\n", "ID", "Nombre", "Precio", "Código Fabricante", "Nombre Fabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-15s%-40s%-45s%-40s%-40s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getFabricante().getCodigo()
                            + producto.getFabricante().getNombre());

                }

            }

            System.out.println("Que desea mmodificar del producto");
            System.out.println("a- Nombre");
            System.out.println("b- Precio");

            String opc = "";
            boolean bandera = true;

            do {

                System.out.println("Opcion elegida: ");
                opc = entrada.next();

                switch (opc.toLowerCase()) {
                    case "a":
                        System.out.println("Ingrese el nuevo nombre");
                        String nuevoNombre = entrada.next();

                        productos.get(0).setNombre(nuevoNombre);

                        productoDAO.ModificarProducto(productos.get(0));

                        System.out.println("Nombre cambiado");

                        bandera = false;

                        break;

                    case "b":
                        System.out.println("Ingrese el nuevo precio");
                        Double nuevoPrecio = entrada.nextDouble();

                        productos.get(0).setPrecio(nuevoPrecio);

                        productoDAO.ModificarProducto(productos.get(0));

                        System.out.println("Precio cambiado");

                        bandera = false;

                        break;

                }

            } while (bandera);

        } catch (Exception e) {
        }

    }

}
