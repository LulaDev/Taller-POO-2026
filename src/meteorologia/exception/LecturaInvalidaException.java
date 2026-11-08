/*
 * Nombre de la clase: LecturaInvalidaException.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.exception;

/**
 * Excepción personalizada de tipo RuntimeException que se lanza cuando se intenta 
 * registrar una lectura de precipitación fuera del rango físico admitido (0 a 500 mm).
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class LecturaInvalidaException extends RuntimeException {

    /**
     * Constructor por defecto sin mensaje descriptivo.
     */
    public LecturaInvalidaException() {
        super();
    }

    /**
     * Constructor que recibe un mensaje detallado sobre el error de lectura.
     * 
     * @param mensaje Detalle explicativo de la excepción.
     */
    public LecturaInvalidaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor que recibe un mensaje descriptivo y la causa raíz del error.
     * 
     * @param mensaje Detalle explicativo de la excepción.
     * @param causa Excepción original que provocó este error.
     */
    public LecturaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    /**
     * Constructor que recibe únicamente la causa raíz del error.
     * 
     * @param causa Excepción original que provocó este error.
     */
    public LecturaInvalidaException(Throwable causa) {
        super(causa);
    }
}
