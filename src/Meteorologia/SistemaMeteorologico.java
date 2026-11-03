package Meteorologia;
import java.util.ArrayList;
import java.util.List;

public class SistemaMeteorologico {
    private List<ZonaGeografica> zonas;
    private List<EstacionMeteorologica> estaciones;
    private List<ResponsableTecnico> responsables;
    private List<EquipoRespuesta> equipos;

    public SistemaMeteorologico() {
        this.zonas = new ArrayList<>();
        this.estaciones = new ArrayList<>();
        this.responsables = new ArrayList<>();
        this.equipos = new ArrayList<>();
    }


        public void mostrarRankingEstaciones() {
            System.out.println(" Ranking de estaciones por volumetria");

            estaciones.stream()
                    .sorted((e1, e2) -> {
                        double suma1 = e1.getSensores().stream().flatMap(s -> s.getMediciones().stream()).mapToDouble(Medicion::getMilimetros).sum();
                        double suma2 = e2.getSensores().stream().flatMap(s -> s.getMediciones().stream()).mapToDouble(Medicion::getMilimetros).sum();
                        return Double.compare(suma2, suma1); // Mayor a menor
                    })
                    .forEach(e -> {
                        double total = e.getSensores().stream().flatMap(s -> s.getMediciones().stream()).mapToDouble(Medicion::getMilimetros).sum();
                        System.out.println("Estación: " + e.getNombre() + " | Acumulado Total: " + total + " mm");
                    });
        }


        public void mostrarInformeFallasYCalibracion() {
            System.out.println("\n--- INFORME DE FALLAS Y CALIBRACIÓN ---");
            for (EstacionMeteorologica est : estaciones) {
                for (Sensor sen : est.getSensores()) {
                    if (sen.getEstado() != EstadoOperativo.OPERATIVO) {
                        System.out.println("[FUERA DE SERVICIO / MANTENIMIENTO] Estación: " + est.getNombre() + " - Sensor ID: " + sen.getIdSensor());
                    }
                    if (sen.requiereCalibracion()) {
                        System.out.println("[REQUIERE CALIBRACIÓN (>12 meses)] Estación: " + est.getNombre() + " - Sensor ID: " + sen.getIdSensor());
                    }
                }
            }
        }

        // Getters
        public void agregarZona(ZonaGeografica z) { zonas.add(z); }
        public void agregarEstacion(EstacionMeteorologica e) { estaciones.add(e); }
        public void agregarResponsable(ResponsableTecnico r) { responsables.add(r); }
        public void agregarEquipo(EquipoRespuesta eq) { equipos.add(eq); }

        public List<ZonaGeografica> getZonas() { return zonas; }
        public List<EstacionMeteorologica> getEstaciones() { return estaciones; }
    }

