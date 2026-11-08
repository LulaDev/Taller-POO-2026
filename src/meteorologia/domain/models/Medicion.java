/*
 * Nombre de la clase: Medicion.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.models;

import java.time.LocalDateTime;

/**
 * Representa una lectura puntual de precipitación (en milímetros) capturada por un sensor
 * en un momento determinado, registrando si la lectura posee características anómalas.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class Medicion {

    // Atributos de instancia
    private int idMedicion;
    private LocalDateTime fechaHora;
    private double milimetros;
    private boolean anomala;


    /**
     * Constructor completo con ID para la medición.
     * 
     * @param idMedicion Identificador único de la medición.
     * @param fechaHora Marca temporal exacta de la lectura (LocalDateTime).
     * @param milimetros Cantidad de milímetros de precipitación registrados.
     * @param anomala Indicador booleano de si la lectura es considerada anómala (>100mm de variación).
     */
    public Medicion(int idMedicion,LocalDateTime fechaHora,double milimetros,boolean anomala){
        this.idMedicion=idMedicion;
        this.fechaHora=fechaHora;
        this.milimetros=milimetros;
        this.anomala=anomala;
    }

    /**
     * Constructor sobrecargado sin ID explícito (ideal para altas automáticas).
     * 
     * @param milimetros Milímetros de precipitación registrados.
     * @param fechaHora Marca temporal exacta de la lectura.
     * @param anomala Indicador booleano de lectura anómala.
     */
    public Medicion(double milimetros,LocalDateTime fechaHora, boolean anomala){
        this.milimetros=milimetros;
        this.fechaHora=fechaHora;
        this.anomala=anomala;
    }

    // Getters y Setters
    public int getIdMedicion() {return idMedicion;}

    public void setIdMedicion(int idMedicion) {this.idMedicion = idMedicion;}

    public LocalDateTime getFechaHora() {return fechaHora;}

    public void setFechaHora(LocalDateTime fechaHora) {this.fechaHora = fechaHora;}

    public double getMilimetros() {return milimetros;}

    public void setMilimetros(double milimetros) {this.milimetros = milimetros;}

    public boolean isAnomala() {return anomala;}

    public void setAnomala(boolean anomala) {this.anomala = anomala;}
}
