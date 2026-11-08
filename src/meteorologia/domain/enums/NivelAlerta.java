/*
 * Nombre de la clase: NivelAlerta.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.enums;

/**
 * Define los niveles de severidad y riesgo meteorológico vigentes para una zona geográfica.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public enum NivelAlerta {
    /** Nivel de riesgo bajo o normal, por debajo de los umbrales críticos de precipitación. */
    VERDE,
    /** Nivel de precaución inicial al superarse el primer umbral de acumulación de lluvia. */
    AMARILLA,    
    /** Nivel de riesgo alto que requiere la asignación obligatoria de un equipo de respuesta técnica. */
    NARANJA,
    /** Nivel de riesgo crítico o máximo que exige la intervención inmediata de recursos de emergencia. */
    ROJA;
}
