package persistencia;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class DAO {

    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultset;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/tienda?useSSL=false";

    protected void ConectarBD() throws Exception {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Error al conectarse");
        }
    }

    protected void DesconectarBD() throws Exception {

        try {
            if (statement != null) {
                statement.close();
            }
            if (resultset != null) {
                resultset.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new Exception("Error al desconectarse");
        }
    }

    protected void InsertarModificarEliminar(String sql) throws Exception {
        try {
            ConectarBD();
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            try {
                connection.rollback();

            } catch (SQLException ex) {
                throw new Exception("ERROR al hacer rollback");
            }
            throw new Exception("ERROR al ejecutar sentencia");
        } finally {
            DesconectarBD();
        }

    }

    protected void QueryBD(String sql) throws Exception {
        try {
            ConectarBD();
            statement = connection.createStatement();
            resultset = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new Exception("Error al consultar");
        }
    }

}
