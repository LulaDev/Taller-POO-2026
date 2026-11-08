/*
 * Nombre de la clase: EstadoOperativo.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.enums;

/**
 * Define los estados operativos posibles en los que puede encontrarse 
 * una estación meteorológica o un sensor de la red.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public enum EstadoOperativo {
    /** Indica que el componente se encuentra funcionando con normalidad. */
    OPERATIVO,
    /** Indica que el componente está temporalmente bajo tareas de revisión o mantenimiento. */
    EN_MANTENIMIENTO,
    /** Indica que el componente se encuentra inactivo o fuera de servicio. */
    FUERA_DE_SERVICIO;
}
