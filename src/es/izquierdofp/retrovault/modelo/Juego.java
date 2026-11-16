/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.izquierdofp.retrovault.modelo;

/**
 *
 * @author victo
 */
public class Juego {
     private int    id;
    private String titulo;
    private String consola;
    private String genero;
    private int    anio;
    private int    puntuacion;
    private String estado;

    public Juego() {}

    public Juego(String titulo, String consola, String genero,
                 int anio, int puntuacion, String estado) {
        this.titulo     = titulo;
        this.consola    = consola;
        this.genero     = genero;
        this.anio       = anio;
        this.puntuacion = puntuacion;
        this.estado     = estado;
    }

    public int    getId()               { return id; }
    public void   setId(int id)         { this.id = id; }
    public String getTitulo()           { return titulo; }
    public void   setTitulo(String v)   { this.titulo = v; }
    public String getConsola()          { return consola; }
    public void   setConsola(String v)  { this.consola = v; }
    public String getGenero()           { return genero; }
    public void   setGenero(String v)   { this.genero = v; }
    public int    getAnio()             { return anio; }
    public void   setAnio(int v)        { this.anio = v; }
    public int    getPuntuacion()       { return puntuacion; }
    public void   setPuntuacion(int v)  { this.puntuacion = v; }
    public String getEstado()           { return estado; }
    public void   setEstado(String v)   { this.estado = v; }

    @Override
    public String toString() { return titulo + " (" + consola + ")"; }
    
}
