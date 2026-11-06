/*
 * Nombre de la clase: EquipoRespuesta.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.models;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa un equipo de respuesta técnica especializado para atender emergencias 
 * y desastres climáticos, integrado por uno o más responsables técnicos.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class EquipoRespuesta {

    // Atributos de instancia
    private int idEquipo;
    private String nombreEquipo;
    private boolean disponible;
    private List<ResponsableTecnico> integrantes;
    private List<Alerta> alertas;

    /**
     * Constructor con parámetros para instanciar un equipo de respuesta.
     * 
     * @param idEquipo Identificador único del equipo.
     * @param nombreEquipo Nombre descriptivo del equipo.
     * @param disponible Estado de disponibilidad actual.
     */
    public EquipoRespuesta(int idEquipo,String nombreEquipo,boolean disponible){
        this.idEquipo=idEquipo;
        this.nombreEquipo=nombreEquipo;
        this.disponible=disponible;
        this.integrantes = new ArrayList<ResponsableTecnico>();
        this.alertas = new ArrayList<Alerta>();
    }

    /**
     * Agrega un nuevo responsable técnico como integrante del equipo de respuesta.
     * 
     * @param r Responsable técnico a incorporar.
     */
    public void agregarIntegrante(ResponsableTecnico r){
        this.integrantes.add(r);
    }

    /**
     * Asocia una alerta al historial de atenciones del equipo.
     * 
     * @param a Alerta asignada al equipo.
     */
    public void agregarAlerta(Alerta a){
        this.alertas.add(a);
    }
    
    // Getters y Setters
    public int getIdEquipo() {return idEquipo;}

    public void setIdEquipo(int idEquipo) {this.idEquipo = idEquipo;}

    public String getNombreEquipo() {return nombreEquipo;}

    public void setNombreEquipo(String nombreEquipo) {this.nombreEquipo = nombreEquipo;}

    public boolean isDisponible() {return disponible;}

    public void setDisponible(boolean disponible) {this.disponible = disponible;}

    public List<ResponsableTecnico> getIntegrantes() {return integrantes;}

    public void setIntegrantes(List<ResponsableTecnico> integrantes) {this.integrantes = integrantes;}

    public List<Alerta> getAlertas() {return alertas;}

    public void setAlertas(List<Alerta> alertas) {this.alertas = alertas;}
}
