/*
 * Nombre de la clase: TipoEventoClimatico.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.enums;

/**
 * Clasifica los diferentes tipos de eventos meteorológicos severos 
 * que pueden motivar el disparo o registro de una alerta.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public enum TipoEventoClimatico {
    /** Evento asociado a precipitaciones intensas o copiosas. */
    LLUVIA_COPIOSA,
    /** Evento asociado al desborde o crecida de ríos. */
    CRECIDA_RIO,
    /** Evento asociado a tormentas de gran severidad. */
    TORMENTA_SEVERA;
}
