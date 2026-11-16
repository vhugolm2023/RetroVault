/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.izquierdofp.retrovault.vista;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author victo
 */
public class ConsolaColorRenderer extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(
                            table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            Object val = table.getModel().getValueAt(row, 2);
            String consola = val != null ? val.toString() : "";

            Color bg = switch (consola) {
                case "NES"         -> new Color(70, 20, 20);
                case "SNES"        -> new Color(45, 20, 65);
                case "Mega Drive"  -> new Color(20, 30, 75);
                case "Game Boy"    -> new Color(20, 55, 30);
                case "PlayStation" -> new Color(15, 40, 70);
                case "Nintendo 64" -> new Color(55, 20, 55);
                case "Game Gear"   -> new Color(65, 35, 10);
                case "Arcade"      -> new Color(60, 50, 10);
                default            -> new Color(35, 35, 35);
            };
            label.setBackground(bg);
            label.setForeground(Color.WHITE);
        }
        return label;
    }
    
}
