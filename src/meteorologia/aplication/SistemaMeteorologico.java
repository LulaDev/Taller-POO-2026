/*
 * Nombre de la clase: SistemaMeteorologico.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.aplication;

import meteorologia.domain.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase gestora principal del sistema. Administra el almacenamiento en memoria 
 * y las altas de las zonas geográficas, estaciones meteorológicas, 
 * personal técnico y equipos de respuesta especializados.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class SistemaMeteorologico {

    // Atributos de instancia (Colecciones del sistema)
    private List<ZonaGeografica> zonas;
    private List<EstacionMeteorologica> estaciones;
    private List<ResponsableTecnico> responsables;
    private List<EquipoRespuesta> equipos;

    /**
     * Constructor por defecto. Inicializa las listas vacías para el almacenamiento en memoria.
     */
    public SistemaMeteorologico() {
        this.zonas = new ArrayList<ZonaGeografica>();
        this.estaciones = new ArrayList<EstacionMeteorologica>();
        this.responsables = new ArrayList<ResponsableTecnico>();
        this.equipos = new ArrayList<EquipoRespuesta>();
    }

    /**
     * Incorpora una nueva zona geográfica o cuenca hidrográfica al sistema.
     * 
     * @param z Objeto ZonaGeografica a registrar.
     */
    public void agregarZona(ZonaGeografica z) {
        if (z != null) {
            this.zonas.add(z);
        }
    }

    /**
     * Registra una nueva estación meteorológica en el sistema.
     * 
     * @param e Objeto EstacionMeteorologica a registrar.
     */
    public void agregarEstacion(EstacionMeteorologica e) {
        if (e != null) {
            this.estaciones.add(e);
        }
    }

    /**
     * Da de alta a un responsable técnico encargado de la supervisión y mantenimiento.
     * 
     * @param r Objeto ResponsableTecnico a registrar.
     */
    public void agregarResponsable(ResponsableTecnico r) {
        if (r != null) {
            this.responsables.add(r);
        }
    }

    /**
     * Registra un equipo de respuesta técnica para emergencias y alertas críticas.
     * 
     * @param eq Objeto EquipoRespuesta a registrar.
     */
    public void agregarEquipo(EquipoRespuesta eq) {
        if (eq != null) {
            this.equipos.add(eq);
        }
    }

    // Getters y Setters
    public List<ZonaGeografica> getZonas() {return zonas;}

    public void setZonas(List<ZonaGeografica> zonas) {this.zonas = zonas;}

    public List<EstacionMeteorologica> getEstaciones() {return estaciones;}

    public void setEstaciones(List<EstacionMeteorologica> estaciones) {this.estaciones = estaciones;}

    public List<ResponsableTecnico> getResponsables() {return responsables;}

    public void setResponsables(List<ResponsableTecnico> responsables) {this.responsables = responsables;}

    public List<EquipoRespuesta> getEquipos() {return equipos;}

    public void setEquipos(List<EquipoRespuesta> equipos) {this.equipos = equipos;}
}
