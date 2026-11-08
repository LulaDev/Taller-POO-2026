/*
 * Nombre de la clase: EstacionMeteorologica.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */
 
package meteorologia.domain.models;

import meteorologia.domain.enums.EstadoOperativo;
import meteorologia.domain.enums.TipoEstacion;
import meteorologia.domain.enums.TipoMantenimiento;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa una estación meteorológica encargada de supervisar sensores,
 * registrar mantenimientos y gestionar su personal técnico asignado.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class EstacionMeteorologica {

    // Atributos de instancia
    private int idEstacion;
    private String nombre;
    private double latitud;
    private double longitud;
    private double altitud;
    private EstadoOperativo estado;
    private TipoEstacion tipo;
    private ResponsableTecnico responsableTecnico;
    private List<Mantenimiento> mantenimientos;
    private List<Sensor> sensores;

    /**
     * Constructor con parámetros para inicializar una estación meteorológica.
     * 
     * @param idEstacion Identificador único de la estación.
     * @param nombre Nombre descriptivo de la estación.
     * @param latitud Coordenada de latitud georreferenciada.
     * @param longitud Coordenada de longitud georreferenciada.
     * @param altitud Altitud sobre el nivel del mar.
     * @param estado Estado operativo actual (Operativo, En Mantenimiento, Fuera de Servicio).
     * @param tipo Tipo de estación (Automática o Convencional).
     * @param responsableTecnico Responsable técnico supervisor a cargo.
     */
    public EstacionMeteorologica(int idEstacion, String nombre, double latitud, double longitud, double altitud, EstadoOperativo estado, TipoEstacion tipo, ResponsableTecnico responsableTecnico){
        this.idEstacion=idEstacion;
        this.nombre=nombre;
        this.latitud=latitud;
        this.longitud=longitud;
        this.altitud=altitud;
        this.estado=estado;
        this.tipo=tipo;
        this.responsableTecnico = responsableTecnico;
        this.mantenimientos = new ArrayList<Mantenimiento>();
        this.sensores = new ArrayList<Sensor>();
    }
    
    /**
     * Crea y agrega un nuevo registro de mantenimiento a la estación.
     * 
     * @param idMantenimiento Identificador del mantenimiento.
     * @param fecha Fecha en la que se realizó.
     * @param tipo Tipología de la intervención (Preventivo, Correctivo, Calibración).
     * @param descripcion Detalle de la tarea realizada.
     * @param sensor Sensor asociado al mantenimiento.
     * @param responsable Responsable técnico ejecutor.
     */
    public void agregarMantenimiento(int idMantenimiento, LocalDate fecha, TipoMantenimiento tipo, String descripcion, Sensor sensor, ResponsableTecnico responsable){
        this.mantenimientos.add(new Mantenimiento(idMantenimiento, fecha, tipo, descripcion, responsable));
    }

    /**
     * Instala un nuevo sensor pluviométrico en la estación.
     * 
     * @param s Sensor que se desea incorporar.
     */
    public void instalarSensor(Sensor s){
        if (s != null) {
            this.sensores.add(s);
        }
    }

    /**
     * Retira un sensor de la estación meteorológica.
     * 
     * @param s Sensor que se desea dar de baja o retirar.
     */
    public void retirarSensor(Sensor s){
        if (s != null) {
            this.sensores.remove(s);
        }
    }

    /**
     * Verifica si la estación se encuentra en estado operativo.
     * 
     * @return true si el estado es OPERATIVO, false en caso contrario.
     */
    public boolean estaOperativa(){
        return this.estado == EstadoOperativo.OPERATIVO;
    }


    // Getters y Setters
    public int getIdEstacion() {return idEstacion;}

    public void setIdEstacion(int idEstacion) {this.idEstacion = idEstacion;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public double getLatitud() {return latitud;}

    public void setLatitud(double latitud) {this.latitud = latitud;}

    public double getLongitud() {return longitud;}

    public void setLongitud(double longitud) {this.longitud = longitud;}

    public double getAltitud() {return altitud;}

    public void setAltitud(double altitud) {this.altitud = altitud;}

    public EstadoOperativo getEstado() {return estado;}

    public void setEstado(EstadoOperativo estado) {this.estado = estado;}

    public TipoEstacion getTipo() {return tipo;}

    public void setTipo(TipoEstacion tipo) {this.tipo = tipo;}

    public List<Sensor> getSensores() {return sensores;}

    public void setSensores(List<Sensor> sensores){this.sensores = sensores;}

    public ResponsableTecnico getResponsableTecnico() {return responsableTecnico;}

    public void setResponsableTecnico(ResponsableTecnico responsableTecnico) {this.responsableTecnico = responsableTecnico;}
}
