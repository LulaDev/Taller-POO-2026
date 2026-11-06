/*
 * Nombre de la clase: Sensor.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.models;

import meteorologia.exception.LecturaInvalidaException;
import meteorologia.domain.enums.EstadoOperativo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * Modela un sensor pluviométrico instalado en una estación meteorológica para capturar mediciones.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class Sensor {

    // Atributos de instancia
    private int idSensor;
    private String marca;
    private String modelo;
    private double precision;
    private EstadoOperativo estado;
    private LocalDate ultimaCalibracion;
    private List<Medicion> mediciones;
    private List<Mantenimiento> mantenimientos;

    /**
     * Constructor de la clase Sensor.
     * 
     * @param idSensor Identificador único del sensor.
     * @param marca Marca fabricante.
     * @param modelo Modelo del equipo.
     * @param precision Margen de precisión.
     * @param estado Estado operativo.
     * @param ultimaCalibracion Fecha de la última calibración realizada.
     */
    public Sensor(int idSensor, String marca, String modelo, double precision, EstadoOperativo estado, LocalDate ultimaCalibracion) {
        this.idSensor = idSensor;
        this.marca = marca;
        this.modelo = modelo;
        this.precision = precision;
        this.estado = estado;
        this.ultimaCalibracion = ultimaCalibracion;
        this.mediciones = new ArrayList<Medicion>();
        this.mantenimientos =new ArrayList<Mantenimiento>();
    }

    /**
     * Agrega una medición directamente al sensor.
     * 
     * @param idMedicion Identificador de la medición.
     * @param fechaHora Fecha y hora del registro.
     * @param milimetros Milímetros de precipitación.
     * @param anomala Indicador de lectura anómala.
     */
    public void agregarMedicion(int idMedicion, LocalDateTime fechaHora, double milimetros, boolean anomala){
        this.mediciones.add(new Medicion(idMedicion, fechaHora, milimetros, anomala));
    }

    /**
     * Registra un mantenimiento asociado al sensor.
     * 
     * @param m Instancia de Mantenimiento a registrar.
     */
    public void agregarMantenimiento(Mantenimiento m){
        this.mantenimientos.add(m);
    }

    /**
     * Valida que el valor de precipitación se encuentre dentro del rango permitido (0 a 500 mm).
     * 
     * @param mm Milímetros a validar.
     * @throws LecturaInvalidaException Si el valor está fuera de rango.
     */
    public void validar(double mm){
        if(mm < 0 || mm > 500 ){
            throw new LecturaInvalidaException("Error: la lectura de " + mm + "mm esta fuera de rango permitido (0 - 500 mm)");
        }
    }

    /**
     * Comprueba si el sensor requiere calibración (si pasaron más de 12 meses desde la última).
     * 
     * @return true si requiere calibración, false en caso contrario.
     */
    public boolean requiereCalibracion(){
        if(this.ultimaCalibracion == null){
            return true;
        }
        LocalDate fechaLimite = this.ultimaCalibracion.plusMonths(12);
        return LocalDate.now().isAfter(fechaLimite);
    }

    /**
     * Registra una nueva medición de lluvia validando el estado del sensor y detectando anomalías (>100 mm de diferencia).
     * 
     * @param mm Milímetros caídos.
     * @param fh Fecha y hora del registro.
     * @throws IllegalStateException Si el sensor no está operativo.
     * @throws LecturaInvalidaException Si la lectura es inválida.
     */
    public void registrar(double mm, LocalDateTime fh){
        if (this.estado != EstadoOperativo.OPERATIVO) {
            throw new IllegalStateException("No se pueden registrar mediciones en un sensor que no está operativo.");
        }
        validar(mm);
        boolean anomala = false;
        if(this.mediciones != null && !this.mediciones.isEmpty()){
            Medicion ultimaMedicion = this.mediciones.get(this.mediciones.size()-1);
            double diferencia = Math.abs(mm - ultimaMedicion.getMilimetros());
            if (diferencia > 100.0){
                anomala= true;
            }
        }
        Medicion nuevaMedicion = new Medicion(mm, fh ,anomala);
        this.mediciones.add(nuevaMedicion);
    }

    // Getters y Setters
    public int getIdSensor() {return idSensor;}

    public void setIdSensor(int idSensor) {this.idSensor = idSensor;}
    
    public String getMarca() {return marca;}

    public void setMarca(String marca) {this.marca = marca;}
    
    public String getModelo() {return modelo;}
    
    public void setModelo(String modelo) {this.modelo = modelo;}

    public double getPrecision() {return precision;}
    
    public void setPrecision(double precision) {this.precision = precision;}

    public EstadoOperativo getEstado() {return estado;}
    
    public void setEstado(EstadoOperativo estado) {this.estado = estado;}

    public LocalDate getUltimaCalibracion() {return ultimaCalibracion;}

    public void setUltimaCalibracion(LocalDate ultimaCalibracion) {this.ultimaCalibracion = ultimaCalibracion;}

    public List<Medicion> getMediciones() {return mediciones;}

    public void setMediciones(List<Medicion> mediciones) {this.mediciones = mediciones;}

    public List<Mantenimiento> getMantenimientos() {return mantenimientos;}

    public void setMantenimientos(List<Mantenimiento> mantenimientos) {this.mantenimientos = mantenimientos;}
}
