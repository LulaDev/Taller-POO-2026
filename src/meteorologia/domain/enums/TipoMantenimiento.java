/*
 * Nombre de la clase: TipoMantenimiento.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.enums;

/**
 * Clasifica las diferentes intervenciones técnicas aplicadas sobre los equipos de la red.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public enum TipoMantenimiento {
    /** Mantenimiento preventivo para evitar fallas futuras. */
    PREVENTIVO,
    /** Mantenimiento correctivo para solucionar averías existentes. */
    CORRECTIVO,
    /** Tareas orientadas a la calibración de sensores. */
    CALIBRACION;
}
