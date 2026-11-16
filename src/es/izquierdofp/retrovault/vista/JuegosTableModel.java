/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.izquierdofp.retrovault.vista;
import es.izquierdofp.retrovault.modelo.Juego;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author victo
 */
public class JuegosTableModel extends AbstractTableModel{
    private static final String[] COLS =
        { "#", "Título", "Consola", "Género", "Año", "Puntuación", "Estado" };

    private List<Juego> juegos;

    public JuegosTableModel(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
        fireTableDataChanged();
    }

    public Juego getJuego(int fila) {
        return juegos.get(fila);
    }

    @Override public int getRowCount()    { return juegos.size(); }
    @Override public int getColumnCount() { return COLS.length; }
    @Override public String getColumnName(int col) { return COLS[col]; }
    @Override public boolean isCellEditable(int r, int c) { return false; }

    @Override
    public Object getValueAt(int row, int col) {
        Juego j = juegos.get(row);
        return switch (col) {
            case 0 -> row + 1;
            case 1 -> j.getTitulo();
            case 2 -> j.getConsola();
            case 3 -> j.getGenero();
            case 4 -> j.getAnio();
            case 5 -> j.getPuntuacion() == 0
                    ? "–"
                    : "★".repeat(j.getPuntuacion()) + "  (" + j.getPuntuacion() + "/5)";
            case 6 -> j.getEstado();
            default -> "";
        };
    }
    
}
