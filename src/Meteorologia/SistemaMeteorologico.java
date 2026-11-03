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

    private double calcularTotalEstacion(EstacionMeteorologica estacion) {
        double total = 0.0;
        for (Sensor sensor : estacion.getSensores()) {
            for (Medicion medicion : sensor.getMediciones()) {
                total += medicion.getMilimetros();
            }
        }
        return total;
    }

    public void mostrarRankingEstaciones() {
        System.out.println("Ranking de estaciones por volumetría");

        List<EstacionMeteorologica> estacionesOrdenadas = new ArrayList<>(estaciones);

        estacionesOrdenadas.sort((e1, e2) -> {
            double suma1 = calcularTotalEstacion(e1);
            double suma2 = calcularTotalEstacion(e2);
            return Double.compare(suma2, suma1);
        });

        for (EstacionMeteorologica e : estacionesOrdenadas) {
            double total = calcularTotalEstacion(e);
            System.out.println("Estación: " + e.getNombre() + " | Acumulado Total: " + total + " mm");
        }
    }

    public void mostrarInformeFallasYCalibracion() {
        System.out.println("\n Informe de Fallas y Calibración");
        for (EstacionMeteorologica est : estaciones) {
            for (Sensor sen : est.getSensores()) {
                if (sen.getEstado() != EstadoOperativo.OPERATIVO) {
                    System.out.println("Fuerade Servicio / Mantenimiento - Estación: " + est.getNombre() + " - Sensor ID: " + sen.getIdSensor());
                }
                if (sen.requiereCalibracion()) {
                    System.out.println("Requiere Calibración (>12 meses) - Estación: " + est.getNombre() + " - Sensor ID: " + sen.getIdSensor());
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

