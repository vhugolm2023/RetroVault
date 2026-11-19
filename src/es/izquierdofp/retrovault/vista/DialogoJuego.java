/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.izquierdofp.retrovault.vista;
import es.izquierdofp.retrovault.modelo.Juego;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author victo
 */
public class DialogoJuego extends JDialog {
    private JTextField txtTitulo;
    private JComboBox<String> cmbConsolaDlg;
    private JComboBox<String> cmbGeneroDlg;
    private JSpinner spnAnio;
    private JComboBox<String> cmbPuntuacionDlg;
    private JComboBox<String> cmbEstadoDlg;
    private JButton btnGuardar;
    private JButton btnCancelar;

    private Juego juego;
    private boolean guardado = false;

    public DialogoJuego(Frame parent, Juego juegoAEditar) {
        super(parent, true);
        initUI();
        setLocationRelativeTo(parent);

        if (juegoAEditar != null) {
            this.juego = juegoAEditar;
            setTitle("Editar juego");
            rellenarCampos();
        } else {
            this.juego = new Juego();
            setTitle("Añadir juego");
        }
    }

    private void initUI() {
        JPanel pCampos = new JPanel(new GridLayout(6, 2, 8, 8));
        pCampos.setBorder(BorderFactory.createEmptyBorder(14, 16, 8, 16));

        txtTitulo = new JTextField(25);
        pCampos.add(new JLabel("Título:"));
        pCampos.add(txtTitulo);

        cmbConsolaDlg = new JComboBox<>(new String[]{
            "NES", "SNES", "Mega Drive", "Game Boy",
            "PlayStation", "Nintendo 64", "Game Gear", "Arcade"});
        pCampos.add(new JLabel("Consola:"));
        pCampos.add(cmbConsolaDlg);

        cmbGeneroDlg = new JComboBox<>(new String[]{
            "Acción", "Aventura", "RPG", "Plataformas", "Puzzle",
            "Deportes", "Lucha", "Disparos", "Estrategia", "Simulación"});
        pCampos.add(new JLabel("Género:"));
        pCampos.add(cmbGeneroDlg);

        spnAnio = new JSpinner(new SpinnerNumberModel(1990, 1970, 2010, 1));
        pCampos.add(new JLabel("Año:"));
        pCampos.add(spnAnio);

        cmbPuntuacionDlg = new JComboBox<>(new String[]{
            "Sin puntuar", "★", "★★", "★★★", "★★★★", "★★★★★"});
        pCampos.add(new JLabel("Puntuación:"));
        pCampos.add(cmbPuntuacionDlg);

        cmbEstadoDlg = new JComboBox<>(new String[]{
            "Pendiente", "Jugando", "Completado", "Abandonado"});
        pCampos.add(new JLabel("Estado:"));
        pCampos.add(cmbEstadoDlg);

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pBotones.add(btnCancelar);
        pBotones.add(btnGuardar);

        btnGuardar.addActionListener(e -> guardar());
        btnCancelar.addActionListener(e -> dispose());

        add(pCampos, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);
        pack();
    }

    private void guardar() {
        String titulo = txtTitulo.getText().trim();
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "El título no puede estar vacío.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        juego.setTitulo(titulo);
        juego.setConsola((String) cmbConsolaDlg.getSelectedItem());
        juego.setGenero((String) cmbGeneroDlg.getSelectedItem());
        juego.setAnio((Integer) spnAnio.getValue());
        juego.setPuntuacion(cmbPuntuacionDlg.getSelectedIndex());
        juego.setEstado((String) cmbEstadoDlg.getSelectedItem());
        guardado = true;
        dispose();
    }

    private void rellenarCampos() {
        txtTitulo.setText(juego.getTitulo());
        cmbConsolaDlg.setSelectedItem(juego.getConsola());
        cmbGeneroDlg.setSelectedItem(juego.getGenero());
        spnAnio.setValue(juego.getAnio());
        cmbPuntuacionDlg.setSelectedIndex(juego.getPuntuacion());
        cmbEstadoDlg.setSelectedItem(juego.getEstado());
    }

    public boolean isGuardado() { return guardado; }
    public Juego getJuego() { return juego; }
    
}
