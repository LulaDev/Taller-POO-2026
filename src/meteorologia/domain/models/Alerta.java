/*
 * Nombre de la clase: Alerta.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.models;

import meteorologia.domain.enums.NivelAlerta;
import meteorologia.domain.enums.TipoEventoClimatico;

import java.time.LocalDateTime;

/**
 * Representa una alerta meteorológica emitida ante situaciones de riesgo o eventos climáticos severos,
 * la cual gestiona su nivel de severidad y la asignación opcional u obligatoria de un equipo de respuesta.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class Alerta {

    // Atributos de instancia
    private int idAlerta;
    private LocalDateTime fechaHoraEmision;
    private NivelAlerta nivel;
    private TipoEventoClimatico evento;
    private String descripcion;
    private boolean atendida;
    private EquipoRespuesta equipoRespuesta;
    private ZonaGeografica zona;

    /**
     * Constructor con parámetros para inicializar una alerta incluyendo su equipo de respuesta asignado.
     * 
     * @param idAlerta Identificador único de la alerta.
     * @param fechaHoraEmision Fecha y hora de emisión de la alerta.
     * @param nivel Nivel de severidad (Verde, Amarilla, Naranja, Roja).
     * @param evento Tipo de evento climático asociado.
     * @param descripcion Descripción detallada de la alerta.
     * @param atendida Estado de atención de la alerta.
     * @param equipoRespuesta Equipo de respuesta técnica asignado.
     * @param zona Zona geográfica afectada.
     */
    public Alerta(int idAlerta, LocalDateTime fechaHoraEmision, NivelAlerta nivel, TipoEventoClimatico evento, String descripcion, boolean atendida, EquipoRespuesta equipoRespuesta, ZonaGeografica zona){
        this.idAlerta = idAlerta;
        this.fechaHoraEmision = fechaHoraEmision;
        this.nivel = nivel;
        this.evento = evento;
        this.descripcion = descripcion;
        this.atendida = atendida;
        this.equipoRespuesta = equipoRespuesta;
        this.zona = zona;
    }

    /**
     * Constructor alternativo sin equipo de respuesta asignado inicialmente.
     * 
     * @param idAlerta Identificador único de la alerta.
     * @param fechaHoraEmision Fecha y hora de emisión.
     * @param nivel Nivel de severidad.
     * @param evento Tipo de evento climático.
     * @param descripcion Descripción de la alerta.
     * @param atendida Estado de atención.
     * @param zona Zona geográfica afectada.
     */
    public Alerta(int idAlerta, LocalDateTime fechaHoraEmision, NivelAlerta nivel, TipoEventoClimatico evento, String descripcion, boolean atendida, ZonaGeografica zona){
        this.idAlerta = idAlerta;
        this.fechaHoraEmision = fechaHoraEmision;
        this.nivel = nivel;
        this.evento = evento;
        this.descripcion = descripcion;
        this.atendida = atendida;
        this.zona = zona;
    }

    /**
     * Asigna un equipo de respuesta técnica a la alerta y marca la alerta como atendida.
     * 
     * @param e Equipo de respuesta a enlazar.
     */
    public void asignarEquipo(EquipoRespuesta e){
        if (e != null) {
            this.equipoRespuesta = e;
            this.atendida = true;
        }
    }

    /**
     * Evalúa si el nivel de la alerta requiere obligatoriamente un equipo de respuesta (Naranja o Roja)[cite: 4, 6].
     * 
     * @return true si requiere equipo, false en caso contrario.
     */
    public boolean requiereEquipo(){
        return this.nivel == NivelAlerta.NARANJA || this.nivel == NivelAlerta.ROJA;
    }
    
    // Getters y Setters
    public int getIdAlerta() {return idAlerta;}

    public void setIdAlerta(int idAlerta) {this.idAlerta = idAlerta;}

    public LocalDateTime getFechaHoraEmision() {return fechaHoraEmision;}

    public void setFechaHoraEmision(LocalDateTime fechaHoraEmision) {this.fechaHoraEmision = fechaHoraEmision;}

    public NivelAlerta getNivel() {return nivel;}

    public void setNivel(NivelAlerta nivel) {this.nivel = nivel;}

    public TipoEventoClimatico getEvento() {return evento;}

    public void setEvento(TipoEventoClimatico evento) {this.evento = evento;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public boolean isAtendida() {return atendida;}

    public void setAtendida(boolean atendida) {this.atendida = atendida;}

    public EquipoRespuesta getEquipoRespuesta() {return equipoRespuesta;}

    public void setEquipoRespuesta(EquipoRespuesta equipoRespuesta) {this.equipoRespuesta = equipoRespuesta;}

    public ZonaGeografica getZona() {return zona;}

    public void setZona(ZonaGeografica zona) {this.zona = zona;}
}
