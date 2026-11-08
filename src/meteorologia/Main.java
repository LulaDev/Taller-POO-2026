/*
 * Nombre de la clase: Main.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia;

import meteorologia.aplication.ReporteService;
import meteorologia.aplication.SistemaMeteorologico;
import meteorologia.domain.enums.*;
import meteorologia.domain.models.*;
import meteorologia.exception.LecturaInvalidaException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Clase principal del sistema que inicializa el entorno de datos de prueba,
 * administra la interacción con el usuario mediante un menú por consola y
 * permite explorar de forma guiada todos los módulos y reglas de negocio.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class Main {

    private static SistemaMeteorologico sistema = new SistemaMeteorologico();
    private static ReporteService reporteService = new ReporteService();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Punto de entrada principal de la aplicación.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        inicializarDatosDePrueba();

        boolean salir = false;
        System.out.println("===============================================================");
        System.out.println("   SISTEMA DE GESTIÓN Y ALERTA TEMPRANA METEOROLÓGICA (POO)");
        System.out.println("===============================================================");

        while (!salir) {
            mostrarMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            String entrada = scanner.nextLine().trim();

            switch (entrada) {
                case "1":
                    menuInfraestructura();
                    break;
                case "2":
                    menuPersonal();
                    break;
                case "3":
                    menuRegistrarMedicion();
                    break;
                case "4":
                    menuAlertas();
                    break;
                case "5":
                    menuReportes();
                    break;
                case "0":
                    salir = true;
                    System.out.println("\n¡Gracias por utilizar el Sistema Meteorológico!");
                    break;
                default:
                    System.out.println("\n[!] Opción no válida. Por favor, reintente.");
            }
        }
    }

    /**
     * Muestra las opciones del menú principal.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n-------------------- MENÚ PRINCIPAL --------------------");
        System.out.println("1. Infraestructura (Ver Zonas, Estaciones y Sensores)");
        System.out.println("2. Personal Técnico y Equipos de Respuesta");
        System.out.println("3. Registrar Nueva Lectura de Precipitación");
        System.out.println("4. Sistema de Alertas Tempranas y Emergencias");
        System.out.println("5. Reportes Estadísticos y Fichas Técnicas");
        System.out.println("0. Salir del Sistema");
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Precarga el escenario de datos requerido para las pruebas de evaluación.
     */
    private static void inicializarDatosDePrueba() {
        // 1. Personal y Equipos
        ResponsableTecnico rt1 = new ResponsableTecnico(38450123, "Carlos", "Gómez", "cgomez@meteorologia.gob.ar", "3454112233", "Hidrología", "LIC-8841");
        ResponsableTecnico rt2 = new ResponsableTecnico(40112944, "María", "López", "mlopez@meteorologia.gob.ar", "3454998877", "Instrumentación", "LIC-9932");
        sistema.agregarResponsable(rt1);
        sistema.agregarResponsable(rt2);

        EquipoRespuesta equipoAlpha = new EquipoRespuesta(1, "Escuadrón Alpha - Rescate Hídrico", true);
        equipoAlpha.agregarIntegrante(rt1);
        equipoAlpha.agregarIntegrante(rt2);
        sistema.agregarEquipo(equipoAlpha);

        // 2. Zona Geográfica y Valores Históricos
        ZonaGeografica zonaCuenca = new ZonaGeografica(1, "Cuenca Río Uruguay (Concordia)", NivelVulnerabilidad.ALTO, NivelAlerta.VERDE);
        zonaCuenca.agregarValorHistorico(11, 130.5); // Noviembre: 130.5 mm medio
        sistema.agregarZona(zonaCuenca);

        // 3. Estación y Sensores
        EstacionMeteorologica estConcordia = new EstacionMeteorologica(101, "Estación Central Concordia", -31.392, -58.020, 35.0, EstadoOperativo.OPERATIVO, TipoEstacion.AUTOMATICA, rt1);
        rt1.agregarEstacionMeteorologica(estConcordia);

        // Sensor Operativo (Última calibración hace 2 meses)
        Sensor s1 = new Sensor(501, "Campbell Scientific", "P-2025", 0.1, EstadoOperativo.OPERATIVO, LocalDate.now().minusMonths(2));
        s1.registrar(20.0, LocalDateTime.now().minusHours(5));
        s1.registrar(35.0, LocalDateTime.now().minusHours(2));

        // Sensor que requiere calibración (Hace 14 meses)
        Sensor s2 = new Sensor(502, "Vaisala", "RG-100", 0.2, EstadoOperativo.OPERATIVO, LocalDate.now().minusMonths(14));

        estConcordia.instalarSensor(s1);
        estConcordia.instalarSensor(s2);
        zonaCuenca.agregarEstacionMeteorologica(estConcordia);
        sistema.agregarEstacion(estConcordia);
    }

    // =========================================================================
    // MODULO 1: INFRAESTRUCTURA
    // =========================================================================
    private static void menuInfraestructura() {
        System.out.println("\n=== INFRAESTRUCTURA REGISTRADA ===");
        for (ZonaGeografica z : sistema.getZonas()) {
            System.out.println("Zona ID: " + z.getIdZona() + " | Nombre: " + z.getNombre() + " | Vulnerabilidad: " + z.getNivelVulnerabilidad() + " | Alerta Actual: " + z.getNivelAlerta());
            System.out.println("  Umbrales configurados: Amarilla >= " + z.getUmbralAmarilla() + "mm, Naranja >= " + z.getUmbralNaranja() + "mm, Roja >= " + z.getUmbralRoja() + "mm");
            
            for (EstacionMeteorologica e : z.getEstaciones()) {
                System.out.println("   └── Estación ID: " + e.getIdEstacion() + " | " + e.getNombre() + " [" + e.getEstado() + "]");
                for (Sensor s : e.getSensores()) {
                    System.out.println("        └── Sensor ID: " + s.getIdSensor() + " | Modelo: " + s.getModelo() + " | Estado: " + s.getEstado() + " | Calibración: " + s.getUltimaCalibracion());
                }
            }
        }
    }

    // =========================================================================
    // MODULO 2: PERSONAL TÉCNICO Y EQUIPOS
    // =========================================================================
    private static void menuPersonal() {
        System.out.println("\n=== PERSONAL TÉCNICO REGISTRADO ===");
        for (ResponsableTecnico rt : sistema.getResponsables()) {
            System.out.println("• " + rt.getNombreCompleto() + " | DNI: " + rt.getDni() + " | Especialidad: " + rt.getEspecialidad() + " | Licencia: " + rt.getNumeroLicencia());
        }

        System.out.println("\n=== EQUIPOS DE RESPUESTA EN EMERGENCIA ===");
        for (EquipoRespuesta eq : sistema.getEquipos()) {
            System.out.println("• Equipo ID: " + eq.getIdEquipo() + " | Nombre: " + eq.getNombreEquipo() + " | Disponible: " + (eq.isDisponible() ? "SÍ" : "NO"));
            System.out.print("  Integrantes: ");
            for (ResponsableTecnico rt : eq.getIntegrantes()) {
                System.out.print("[" + rt.getNombreCompleto() + "] ");
            }
            System.out.println();
        }
    }

    // =========================================================================
    // MODULO 3: REGISTRO Y VALIDACIÓN DE MEDICIONES
    // =========================================================================
    private static void menuRegistrarMedicion() {
        System.out.println("\n=== REGISTRO DE MEDICIONES DE PRECIPITACIÓN ===");
        if (sistema.getEstaciones().isEmpty()) {
            System.out.println("[!] No hay estaciones registradas.");
            return;
        }

        System.out.println("Seleccione la estación meteorológica:");
        for (int i = 0; i < sistema.getEstaciones().size(); i++) {
            EstacionMeteorologica est = sistema.getEstaciones().get(i);
            System.out.println((i + 1) + ". " + est.getNombre() + " (Estado: " + est.getEstado() + ")");
        }
        System.out.print("Opción: ");
        int optEst = Integer.parseInt(scanner.nextLine().trim()) - 1;
        EstacionMeteorologica estacionSel = sistema.getEstaciones().get(optEst);

        if (!estacionSel.estaOperativa()) {
            System.out.println("[!] ERROR: No se permite registrar lecturas en estaciones no operativas (Regla de Negocio).");
            return;
        }

        if (estacionSel.getSensores().isEmpty()) {
            System.out.println("[!] La estación seleccionada no posee sensores instalados.");
            return;
        }

        System.out.println("\nSeleccione el sensor:");
        for (int i = 0; i < estacionSel.getSensores().size(); i++) {
            Sensor s = estacionSel.getSensores().get(i);
            System.out.println((i + 1) + ". Sensor ID: " + s.getIdSensor() + " (" + s.getMarca() + " - " + s.getModelo() + ")");
        }
        System.out.print("Opción: ");
        int optSen = Integer.parseInt(scanner.nextLine().trim()) - 1;
        Sensor sensorSel = estacionSel.getSensores().get(optSen);

        System.out.print("\nIngrese los milímetros de precipitación registrados (0 - 500 mm): ");
        try {
            double mm = Double.parseDouble(scanner.nextLine().trim());
            
            // Intenta registrar la lectura invocando la lógica con validaciones y detección de anomalías
            sensorSel.registrar(mm, LocalDateTime.now());
            System.out.println("✓ Medicion registrada con éxito.");

            // Disparo automático de evaluación de alerta en la zona
            for (ZonaGeografica z : sistema.getZonas()) {
                if (z.getEstaciones().contains(estacionSel)) {
                    NivelAlerta nivelRiesgo = z.evaluarRiesgo();
                    System.out.println("• Evaluación de cuenca en 24h: " + z.lluviaAcumulada24h() + " mm acumulados.");
                    System.out.println("• Nivel de Alerta resultante: [" + nivelRiesgo + "]");

                    if (nivelRiesgo != NivelAlerta.VERDE) {
                        z.emitirAlerta(TipoEventoClimatico.LLUVIA_COPIOSA);
                        System.out.println("  ↳ [ALERTA AUTOMÁTICA DISPARADA] Se ha emitido una alerta por LLUVIA COPIOSA.");
                    }
                }
            }

        } catch (LecturaInvalidaException e) {
            System.out.println("\n[X] EXCEPCION DE NEGOCIO: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("\n[X] ERROR DE ESTADO OPERATIVO: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("\n[!] Formato numérico inválido.");
        }
    }

    // =========================================================================
    // MODULO 4: ALERTAS TEMPRANAS Y REGISTRO DE OPERADOR
    // =========================================================================
    private static void menuAlertas() {
        System.out.println("\n=== SISTEMA DE ALERTAS TEMPRANAS Y EMERGENCIAS ===");
        System.out.println("1. Registrar Alerta Manual de Operador (Crecida de Río / Tormenta Severa)");
        System.out.println("2. Asignar Equipo de Respuesta a Alerta Pendiente");
        System.out.println("3. Ver Historial de Alertas Emitidas");
        System.out.print("Seleccione una opción: ");
        String subOp = scanner.nextLine().trim();

        if (sistema.getZonas().isEmpty()) {
            System.out.println("[!] No existen zonas registradas.");
            return;
        }
        ZonaGeografica zona = sistema.getZonas().get(0);

        switch (subOp) {
            case "1":
                System.out.println("\n--- ALERTA MANUAL POR OPERADOR ---");
                System.out.println("Seleccione Nivel: 1. AMARILLA | 2. NARANJA | 3. ROJA");
                int nOpt = Integer.parseInt(scanner.nextLine().trim());
                NivelAlerta nivel = (nOpt == 3) ? NivelAlerta.ROJA : (nOpt == 2) ? NivelAlerta.NARANJA : NivelAlerta.AMARILLA;

                System.out.println("Seleccione Tipo de Evento: 1. CRECIDA_RIO | 2. TORMENTA_SEVERA");
                int eOpt = Integer.parseInt(scanner.nextLine().trim());
                TipoEventoClimatico evento = (eOpt == 1) ? TipoEventoClimatico.CRECIDA_RIO : TipoEventoClimatico.TORMENTA_SEVERA;

                System.out.print("Ingrese descripción operativa: ");
                String desc = scanner.nextLine();

                EquipoRespuesta eqAsignado = null;
                if (nivel == NivelAlerta.NARANJA || nivel == NivelAlerta.ROJA) {
                    System.out.println("\n[!] El nivel " + nivel + " REQUIERE un Equipo de Respuesta OBLIGATORIO.");
                    if (!sistema.getEquipos().isEmpty()) {
                        eqAsignado = sistema.getEquipos().get(0);
                        System.out.println("-> Se ha asignado automáticamente el equipo disponible: " + eqAsignado.getNombreEquipo());
                    }
                }

                try {
                    Alerta a = zona.registrarAlertaOperador(nivel, evento, desc, eqAsignado);
                    System.out.println("✓ Alerta ingresada correctamente con ID #" + a.getIdAlerta());
                } catch (IllegalArgumentException e) {
                    System.out.println("\n[X] REGLA DE NEGOCIO VIOLADA: " + e.getMessage());
                }
                break;

            case "2":
                System.out.println("\n--- ASIGNACIÓN DE RECURSOS A ALERTAS ---");
                if (zona.getAlertas().isEmpty()) {
                    System.out.println("No hay alertas emitidas.");
                    return;
                }
                for (Alerta al : zona.getAlertas()) {
                    System.out.println("Alerta #" + al.getIdAlerta() + " | Nivel: " + al.getNivel() + " | Atendida: " + al.isAtendida());
                    if (!al.isAtendida() && al.requiereEquipo()) {
                        if (!sistema.getEquipos().isEmpty()) {
                            al.asignarEquipo(sistema.getEquipos().get(0));
                            System.out.println("  ↳ ¡Equipo " + sistema.getEquipos().get(0).getNombreEquipo() + " asignado con éxito!");
                        }
                    }
                }
                break;

            case "3":
                System.out.println("\n--- HISTORIAL DE ALERTAS ---");
                for (Alerta al : zona.getAlertas()) {
                    System.out.println("ID #" + al.getIdAlerta() + " | Emisión: " + al.getFechaHoraEmision() + " | Nivel: " + al.getNivel() + " | Evento: " + al.getEvento() + " | Atendida: " + al.isAtendida());
                    System.out.println("  Detalle: " + al.getDescripcion());
                }
                break;
        }
    }

    // =========================================================================
    // MODULO 5: REPORTES ESTADÍSTICOS Y OPERATIVOS
    // =========================================================================
    private static void menuReportes() {
        System.out.println("\n=== SALIDAS ESTADÍSTICAS Y REPORTES OPERATIVOS ===");
        System.out.println("1. Ranking de Estaciones por Volumetría Acumulada");
        System.out.println("2. Informe de Fallas, Anomalías y Calibraciones Pendientes");
        System.out.println("3. Ficha Técnica Operativa de Estación");
        System.out.println("4. Estadística de Anomalía Climática (Desviación Histórica Mensual)");
        System.out.print("Seleccione una opción: ");
        String subOp = scanner.nextLine().trim();

        switch (subOp) {
            case "1":
                reporteService.mostrarRankingEstaciones(sistema.getEstaciones());
                break;

            case "2":
                reporteService.mostrarInformeFallasYCalibracion(sistema.getEstaciones());
                break;

            case "3":
                if (!sistema.getEstaciones().isEmpty()) {
                    reporteService.mostrarFichaTecnicaOperativa(sistema.getEstaciones().get(0));
                }
                break;

            case "4":
                if (!sistema.getZonas().isEmpty()) {
                    ZonaGeografica z = sistema.getZonas().get(0);
                    double acumuladoPrueba = z.lluviaAcumulada24h();
                    int mesActual = LocalDate.now().getMonthValue();
                    double desv = reporteService.calcularDesviacionHistorica(z, mesActual, acumuladoPrueba);
                    System.out.println("\n--- ANÁLISIS DE ANOMALÍA CLIMÁTICA MENS-UAL ---");
                    System.out.println("Zona: " + z.getNombre() + " | Mes: " + mesActual);
                    System.out.println("Acumulado evaluado: " + acumuladoPrueba + " mm");
                    System.out.println("Porcentaje de desviación respecto a la media histórica: " + String.format("%.2f", desv) + "%");
                }
                break;
        }
    }
}
