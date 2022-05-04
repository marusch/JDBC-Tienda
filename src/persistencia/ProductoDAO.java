package persistencia;

import entidades.Producto;
import entidades.Fabricante;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO extends DAO {

    public void GuardarProducto(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("El producto no puede ser nulo");
            }
            String template = "INSERT INTO producto VALUES(NULL, &s, %s, %s)";
            String sql = String.format(template, producto.getNombre(), producto.getPrecio(),
                    producto.getFabricante().getCodigo());

            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar producto");
        }

    }

    public void ModificarProducto(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("El producto no puede ser nulo");
            }
            String template = "UPDATE producto SET nombre='%s', precio='%s' WHERE codigo='%s';";
            String sql = String.format(template, producto.getNombre(), producto.getPrecio(),
                    producto.getCodigo());

            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al modificar producto");
        }
    }

    public void BorrarProducto(Integer productoId) throws Exception {

        try {
            String sql = "DELETE FROM producto WHERE codigo = " + productoId;
            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al borrar producto.");
        }

    }

    public List<Producto> ObtenerProducto() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON fabricante.codigo = producto.codigo_fabricante;";

            QueryBD(sql);

            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;

            while (resultset.next()) {
                producto = new Producto();
                fabricante = new Fabricante();
                producto.setCodigo(resultset.getInt(1));
                producto.setNombre(resultset.getString(2));
                producto.setPrecio(resultset.getDouble(3));
                fabricante.setCodigo(resultset.getInt(1));
                fabricante.setNombre(resultset.getString(2));
                producto.setFabricante(fabricante);
                productos.add(producto);
            }

            return productos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener producto");
        } finally {
            DesconectarBD();
        }
    }

    public List<Producto> ObtenerProductosPreciosEntre120y202() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante "
                    + "ON fabricante.codigo = producto.codigo_fabricante WHERE precio >= 120 AND precio <=120;";

            QueryBD(sql);

            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;

            while (resultset.next()) {
                producto = new Producto();
                fabricante = new Fabricante();
                producto.setCodigo(resultset.getInt(1));
                producto.setNombre(resultset.getString(2));
                producto.setPrecio(resultset.getDouble(3));
                fabricante.setCodigo(resultset.getInt(1));
                fabricante.setNombre(resultset.getString(2));
                producto.setFabricante(fabricante);
                productos.add(producto);
            }

            return productos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener productos");
        } finally {
            DesconectarBD();
        }
    }

    public List<Producto> ObtenerPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante "
                    + "ON fabricante.codigo = producto.codigo_fabricante WHERE producto.nombre LIKE 'Portátil%'";

            QueryBD(sql);

            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;

            while (resultset.next()) {
                producto = new Producto();
                fabricante = new Fabricante();
                producto.setCodigo(resultset.getInt(1));
                producto.setNombre(resultset.getString(2));
                producto.setPrecio(resultset.getDouble(3));
                fabricante.setCodigo(resultset.getInt(1));
                fabricante.setNombre(resultset.getString(2));
                producto.setFabricante(fabricante);
                productos.add(producto);
            }

            return productos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener portatiles");
        } finally {
            DesconectarBD();
        }
    }

    public List<Producto> ObtenerProductoDeMenorPrecio() throws Exception {
        try {
            String sql = "SELECT producto.nombre, MIN(producto.precio) FROM producto INNER JOIN fabricante "
                    + "ON fabricante.codigo = producto.codigo_fabricante";

            QueryBD(sql);

            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;

            while (resultset.next()) {
                producto = new Producto();
                fabricante = new Fabricante();

                producto.setNombre(resultset.getString(1));
                producto.setPrecio(resultset.getDouble(2));

                producto.setFabricante(fabricante);
                productos.add(producto);
            }

            return productos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener el producto de menor precio");
        } finally {
            DesconectarBD();
        }
    }

    public List<Producto> ObtenerProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante "
                    + "ON fabricante.codigo = producto.codigo_fabricante WHERE producto.codigo = " + codigo + ";";

            QueryBD(sql);

            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;

            while (resultset.next()) {
                producto = new Producto();
                fabricante = new Fabricante();
                producto.setCodigo(resultset.getInt(1));
                producto.setNombre(resultset.getString(2));
                producto.setPrecio(resultset.getDouble(3));
                fabricante.setCodigo(resultset.getInt(1));
                fabricante.setNombre(resultset.getString(2));
                producto.setFabricante(fabricante);
                productos.add(producto);
            }

            return productos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener producto por codigo");
        } finally {
            DesconectarBD();
        }
    }

}
