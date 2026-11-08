/*
 * Nombre de la clase: ReporteService.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.aplication;

import meteorologia.domain.enums.EstadoOperativo;
import meteorologia.domain.enums.NivelAlerta;
import meteorologia.domain.models.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase gestora de servicios encargada de procesar información estadística, 
 * generar informes operativos, rankings de precipitación, controles de fallas, 
 * requerimientos de calibración y análisis de anomalías climáticas.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class ReporteService {

    /**
     * Constructor por defecto para el servicio de reportes.
     */
    public ReporteService() {
    }

    /**
     * Muestra por consola el ranking ordenado de mayor a menor de las estaciones 
     * según los milímetros totales de precipitación acumulados.
     * 
     * @param estaciones Lista completa de estaciones meteorológicas a evaluar.
     */
    public void mostrarRankingEstaciones(List<EstacionMeteorologica> estaciones) {
        System.out.println("=== RANKING DE ESTACIONES POR VOLUMETRÍA ===");
        if (estaciones == null || estaciones.isEmpty()) {
            System.out.println("No hay estaciones registradas para procesar el ranking.");
            return;
        }

        // Procesamiento y ordenamiento de volumetría por estación
        estaciones.sort((e1, e2) -> Double.compare(calcularTotalEstacion(e2), calcularTotalEstacion(e1)));

        int puesto = 1;
        for (EstacionMeteorologica est : estaciones) {
            double total = calcularTotalEstacion(est);
            System.out.println(puesto + ". Estación: " + est.getNombre() + " | Acumulado Total: " + total + " mm");
            puesto++;
        }
    }

    /**
     * Calcula de forma auxiliar el volumen total de precipitación registrado por una estación.
     * 
     * @param estacion Estación meteorológica analizada.
     * @return Suma total de milímetros de todos sus sensores activos.
     */
    private double calcularTotalEstacion(EstacionMeteorologica estacion) {
        double total = 0.0;
        if (estacion.getSensores() != null) {
            for (Sensor s : estacion.getSensores()) {
                if (s.getMediciones() != null) {
                    for (Medicion m : s.getMediciones()) {
                        total += m.getMilimetros();
                    }
                }
            }
        }
        return total;
    }

    /**
     * Emite un informe detallado sobre sensores fuera de servicio, en mantenimiento, 
     * lecturas anómalas detectadas y sensores que superaron los 12 meses sin calibrarse.
     * 
     * @param estaciones Lista de estaciones meteorológicas de la red.
     */
    public void mostrarInformeFallasYCalibracion(List<EstacionMeteorologica> estaciones) {
        System.out.println("\n=== INFORME DE FALLAS, ANOMALÍAS Y CALIBRACIÓN ===");
        if (estaciones == null || estaciones.isEmpty()) {
            System.out.println("No hay infraestructura registrada para auditar.");
            return;
        }

        for (EstacionMeteorologica est : estaciones) {
            System.out.println("Estación: " + est.getNombre() + " [Estado: " + est.getEstado() + "]");
            if (est.getSensores() != null) {
                for (Sensor s : est.getSensores()) {
                    if (s.getEstado() != EstadoOperativo.OPERATIVO) {
                        System.out.println("  -> ALERTA Sensor ID " + s.getIdSensor() + " inactivo o en mantenimiento (" + s.getEstado() + ").");
                    }
                    if (s.requiereCalibracion()) {
                        System.out.println("  -> REQUISITO: El sensor ID " + s.getIdSensor() + " requiere calibración por antigüedad (> 12 meses).");
                    }
                    if (s.getMediciones() != null) {
                        for (Medicion m : s.getMediciones()) {
                            if (m.isAnomala()) {
                                System.out.println("  -> ANOMALÍA: Lectura anómala detectada en sensor ID " + s.getIdSensor() + " con " + m.getMilimetros() + " mm el " + m.getFechaHora() + ".");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Calcula la estadística de anomalía climática comparando el acumulado mensual actual 
     * frente al valor medio histórico registrado para dicho mes en la zona.
     * 
     * @param zona Zona geográfica evaluada.
     * @param mes Mes del año analizado (1 a 12).
     * @param acumuladoActual Total de precipitación acumulada en el mes actual.
     * @return Porcentaje de desviación respecto al histórico (positivo si supera la media, negativo si está por debajo).
     */
    public double calcularDesviacionHistorica(ZonaGeografica zona, int mes, double acumuladoActual) {
        if (zona == null || zona.getValoresHistoricos() == null) {
            return 0.0;
        }

        double mediaHistorica = 0.0;
        for (ValorHistorico vh : zona.getValoresHistoricos()) {
            if (vh.getMes() == mes) {
                mediaHistorica = vh.getAcumuladoMedio();
                break;
            }
        }

        if (mediaHistorica == 0.0) {
            return 0.0; // Evita división por cero si no hay registro histórico cargado
        }

        // Cálculo del porcentaje de desviación respecto al valor medio histórico
        return ((acumuladoActual - mediaHistorica) / mediaHistorica) * 100.0;
    }

    /**
     * Genera una ficha técnica operativa consolidada con el estado actual de los sensores 
     * y el responsable técnico asignado a la estación.
     * 
     * @param estacion Estación meteorológica objeto de la ficha técnica.
     */
    public void mostrarFichaTecnicaOperativa(EstacionMeteorologica estacion) {
        System.out.println("\n=== FICHA TÉCNICA OPERATIVA ===");
        if (estacion == null) {
            System.out.println("Estación no especificada.");
            return;
        }

        System.out.println("Nombre: " + estacion.getNombre() + " (ID: " + estacion.getIdEstacion() + ")");
        System.out.println("Tipo: " + estacion.getTipo() + " | Estado: " + estacion.getEstado());
        System.out.println("Ubicación - Lat: " + estacion.getLatitud() + ", Lon: " + estacion.getLongitud() + ", Alt: " + estacion.getAltitud() + " msnm");
        
        if (estacion.getResponsableTecnico() != null) {
            ResponsableTecnico rt = estacion.getResponsableTecnico();
            System.out.println("Responsable Técnico: " + rt.getNombreCompleto() + " [Licencia: " + rt.getNumeroLicencia() + "]");
        } else {
            System.out.println("Responsable Técnico: Sin asignar.");
        }

        System.out.println("Sensores instalados: " + (estacion.getSensores() != null ? estacion.getSensores().size() : 0));
        if (estacion.getSensores() != null) {
            for (Sensor s : estacion.getSensores()) {
                System.out.println(" - Sensor ID: " + s.getIdSensor() + " | Marca: " + s.getMarca() + " | Estado: " + s.getEstado());
            }
        }
    }
}
