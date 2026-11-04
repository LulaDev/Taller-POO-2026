package meteorologia;

import meteorologia.aplication.SistemaMeteorologico;
import meteorologia.domain.enums.*;
import meteorologia.domain.models.*;
import meteorologia.exception.LecturaInvalidaException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaMeteorologico sistema = new SistemaMeteorologico();
        Scanner scanner = new Scanner(System.in);


        EquipoRespuesta equipo1 = new EquipoRespuesta(1, "Equipo Alfa - Rescate Fluvial", true, new ArrayList<>());
        ZonaGeografica zonaCentro = new ZonaGeografica(1, "Cuenca Centro", NivelVulnerabilidad.ALTO, NivelAlerta.VERDE, 50.0, 100.0, 150.0);
        ResponsableTecnico resp1 = new ResponsableTecnico(35123456, "Juan", "Pérez", "juan@met.com", "3454123456", "Hidrología", "LIC-9988", new ArrayList<>(), equipo1);

        Sensor sensor1 = new Sensor(101, "PluvioTech", "A1", 0.1, EstadoOperativo.OPERATIVO, LocalDate.now().minusMonths(6));
        List<Sensor> sensoresEstacion = new ArrayList<>();
        sensoresEstacion.add(sensor1);

        EstacionMeteorologica estacion1 = new EstacionMeteorologica(1, "Estación Salto Grande", -31.3, -58.0, 50.0, EstadoOperativo.OPERATIVO, TipoEstacion.AUTOMATICA, resp1);
        zonaCentro.getEstaciones().add(estacion1);

        sistema.agregarZona(zonaCentro);
        sistema.agregarEstacion(estacion1);
        sistema.agregarResponsable(resp1);
        sistema.agregarEquipo(equipo1);


        int opcion = 0;
        do {
            System.out.println("SISTEMA DE GESTIÓN METEOROLÓGICA (EL NIÑO) ");
            System.out.println("1. Registrar medición en sensor");
            System.out.println("2. Evaluar riesgo y verificar alertas de Zona");
            System.out.println("3. Ver Ranking de Estaciones por Volumetría");
            System.out.println("4. Ver Informe de Fallas y Calibraciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese milímetros caídos (0 - 500): ");
                        double mm = Double.parseDouble(scanner.nextLine());
                        sensor1.registrar(mm, LocalDateTime.now());
                        System.out.println("¡Medición registrada con éxito!");
                        break;
                    case 2:
                        NivelAlerta riesgo = zonaCentro.evaluarRiesgo();
                        System.out.println("Lluvia acumulada 24h: " + zonaCentro.lluviaAcumulada24h() + " mm");
                        System.out.println("Nivel de riesgo evaluado: " + riesgo);
                        if (riesgo == NivelAlerta.NARANJA || riesgo == NivelAlerta.ROJA) {
                            zonaCentro.emitirAlerta(TipoEventoClimatico.LLUVIA_COPIOSA, equipo1);
                            System.out.println("¡Alerta emitida automáticamente y asignada al equipo de respuesta!");
                        }
                        break;
                    case 3:
                        sistema.mostrarRankingEstaciones();
                        break;
                    case 4:
                        sistema.mostrarInformeFallasYCalibracion();
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (LecturaInvalidaException e) {
                System.out.println("Excepción controlada: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Ocurrió un error inesperado: " + e.getMessage());
            }
        } while (opcion != 5);

        scanner.close();
    }
}