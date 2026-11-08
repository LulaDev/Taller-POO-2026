/*
 * Nombre de la clase: ResponsableTecnico.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.models;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa a un responsable técnico encargado de la supervisión de estaciones meteorológicas,
 * así como del mantenimiento y la calibración de sus sensores.
 * Extiende de la clase abstracta Persona.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class ResponsableTecnico extends Persona{

    // Atributos de instancia
    private String especialidad;
    private String numeroLicencia;
    private List<EstacionMeteorologica> estacionesACargo;
    private List<Mantenimiento> mantenimientosRealizados;

    /**
     * Constructor con parámetros para instanciar un responsable técnico.
     * 
     * @param dni DNI de la persona.
     * @param nombre Nombre.
     * @param apellido Apellido.
     * @param correoElectronico Correo electrónico.
     * @param celular Teléfono celular.
     * @param especialidad Especialidad técnica (ej. Hidrología).
     * @param numeroLicencia Número de licencia profesional.
     */
    public ResponsableTecnico(int dni, String nombre, String apellido, String correoElectronico, String celular, String especialidad, String numeroLicencia){
        super(dni, nombre, apellido, correoElectronico, celular);
        this.especialidad=especialidad;
        this.numeroLicencia=numeroLicencia;
        this.estacionesACargo = new ArrayList<EstacionMeteorologica>();
        this.mantenimientosRealizados = new ArrayList<Mantenimiento>();
    }
    
    /**
     * Agrega una estación meteorológica bajo la supervisión y cargo del técnico.
     * 
     * @param em Estación meteorológica a incorporar.
     */
    public void agregarEstacionMeteorologica(EstacionMeteorologica em){
        this.estacionesACargo.add(em);
    }

    /**
     * Registra un nuevo mantenimiento ejecutado por el responsable técnico[cite: 6].
     * 
     * @param ma Mantenimiento realizado.
     */
    public void agregarMantenimiento(Mantenimiento ma){
        this.mantenimientosRealizados.add(ma);
    }
    
    // Getters y Setters
    public String getEspecialidad() {return especialidad;}

    public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}

    public String getNumeroLicencia() {return numeroLicencia;}

    public void setNumeroLicencia(String numeroLicencia) {this.numeroLicencia = numeroLicencia;}

    public List<EstacionMeteorologica> getEstacionesACargo(){return estacionesACargo;}

    public void setEstacionesACargo(List<EstacionMeteorologica> estacionesACargo){this.estacionesACargo = estacionesACargo;}

    public List<Mantenimiento> getMantenimientosRealizados(){return mantenimientosRealizados;}

    public void setMantenimientosRealizados(List<Mantenimiento> mantenimientosRealizados){this.mantenimientosRealizados = mantenimientosRealizados;}
}
