/*
 * Nombre de la clase: Mantenimiento.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */
 
package meteorologia.domain.models;

import meteorologia.domain.enums.TipoMantenimiento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Modela una intervención de mantenimiento realizada sobre los componentes o sensores 
 * de la red de estaciones meteorológicas[cite: 4, 6].
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class Mantenimiento {

    // Atributos de instancia
    private int idMantenimiento;
    private LocalDate fecha;
    private TipoMantenimiento tipo;
    private String descripcion;
    private ResponsableTecnico responsable;
    private Sensor sensor;

    /**
     * Constructor con parámetros incluyendo el sensor intervenido.
     * 
     * @param idMantenimiento Identificador único del mantenimiento.
     * @param fecha Fecha en que se llevó a cabo la tarea.
     * @param tipo Tipo de mantenimiento (Preventivo, Correctivo, Calibración)[cite: 4].
     * @param descripcion Descripción de la tarea ejecutada.
     * @param responsable Responsable técnico a cargo del trabajo.
     * @param sensor Sensor específico objeto del mantenimiento.
     */
    public Mantenimiento(int idMantenimiento,LocalDate fecha,TipoMantenimiento tipo,String descripcion,ResponsableTecnico responsable, Sensor sensor){
        this.idMantenimiento=idMantenimiento;
        this.fecha=fecha;
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.responsable=responsable;
        this.sensor = sensor;
    }

    /**
     * Constructor alternativo sin sensor directo asociado.
     * 
     * @param idMantenimiento Identificador único del mantenimiento.
     * @param fecha Fecha del mantenimiento.
     * @param tipo Tipo de mantenimiento[cite: 4].
     * @param descripcion Descripción de la tarea.
     * @param responsable Responsable técnico a cargo.
     */
    public Mantenimiento(int idMantenimiento,LocalDate fecha,TipoMantenimiento tipo,String descripcion,ResponsableTecnico responsable){
        this.idMantenimiento=idMantenimiento;
        this.fecha=fecha;
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.responsable=responsable;
    }

    // Getters y Setters
    public int getIdMantenimiento() {return idMantenimiento;}

    public void setIdMantenimiento(int idMantenimiento) {this.idMantenimiento = idMantenimiento;}

    public LocalDate getFecha() {return fecha;}

    public void setFecha(LocalDate fecha) {this.fecha = fecha;}

    public TipoMantenimiento getTipo() {return tipo;}

    public void setTipo(TipoMantenimiento tipo) {this.tipo = tipo;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public ResponsableTecnico getResponsable() {return responsable;}

    public void setResponsable(ResponsableTecnico responsable) {this.responsable = responsable;}

    public Sensor getSensor() {return sensor;}

    public void setSensor(Sensor sensor) {this.sensor = sensor;}
}
