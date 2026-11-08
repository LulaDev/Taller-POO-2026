/*
 * Nombre de la clase: ValorHistorico.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */
 
package meteorologia.domain.models;

/**
 * Modela el acumulado medio histórico de precipitación (en milímetros) 
 * correspondiente a un mes específico del año para una zona geográfica determinada.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class ValorHistorico {

    // Atributos de instancia
    private int mes;
    private double acumuladoMedio;

    /**
     * Constructor con parámetros para inicializar el valor histórico mensual.
     * 
     * @param mes Número del mes del año (1 a 12).
     * @param acumuladoMedio Promedio histórico acumulado de precipitación en milímetros.
     */
    public ValorHistorico(int mes,double acumuladoMedio){
        this.mes=mes;
        this.acumuladoMedio=acumuladoMedio;
    }

    // Getters y Setters
    public int getMes() {return mes;}

    public void setMes(int mes) {this.mes = mes;}

    public double getAcumuladoMedio() {return acumuladoMedio;}

    public void setAcumuladoMedio(double acumuladoMedio) {this.acumuladoMedio = acumuladoMedio;}
}
