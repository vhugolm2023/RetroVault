/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.izquierdofp.retrovault.datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author victo
 */
public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:retrovault.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void inicializar() {
        String sql = """
            CREATE TABLE IF NOT EXISTS juegos (
                id         INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo     TEXT    NOT NULL,
                consola    TEXT    NOT NULL,
                genero     TEXT    NOT NULL,
                anio       INTEGER NOT NULL,
                puntuacion INTEGER NOT NULL DEFAULT 0,
                estado     TEXT    NOT NULL DEFAULT 'Pendiente'
            )
            """;
        try (Connection conn = getConnection();
             Statement  stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error al inicializar BD: " + e.getMessage());
        }
    }
    
}
