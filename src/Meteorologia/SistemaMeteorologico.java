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
        System.out.println("\n--- Ranking de estaciones por volumetría ---");
        
        if (estaciones == null || estaciones.isEmpty()) {
            System.out.println("No hay estaciones registradas.");
            return;
        }

        // Creamos una lista auxiliar para asociar cada estación con su total acumulado
        // O podemos usar un algoritmo de ordenamiento tradicional sobre la lista de estaciones.
        // Copiamos las estaciones a una nueva lista para no alterar el orden original de forma permanente
        List<EstacionMeteorologica> listaOrdenada = new ArrayList<>(estaciones);

        // Ordenamiento burbuja o usando Collections.sort con un Comparator tradicional
        listaOrdenada.sort(new java.util.Comparator<EstacionMeteorologica>() {
            @Override
            public int compare(EstacionMeteorologica e1, EstacionMeteorologica e2) {
                double suma1 = calcularTotalEstacion(e1);
                double suma2 = calcularTotalEstacion(e2);
                // Orden descendente (de mayor a menor)
                return Double.compare(suma2, suma1);
            }
        });

        // Mostrar resultados con bucle for clásico
        for (int i = 0; i < listaOrdenada.size(); i++) {
            EstacionMeteorologica est = listaOrdenada.get(i);
            double total = calcularTotalEstacion(est);
            System.out.println((i + 1) + ". Estación: " + est.getNombre() + " | Acumulado Total: " + total + " mm");
        }
    }

    // Método auxiliar privado para sumar los milímetros de una estación con estructuras básicas
    private double calcularTotalEstacion(EstacionMeteorologica estacion) {
        double total = 0.0;
        if (estacion.getSensores() != null) {
            for (Sensor sensor : estacion.getSensores()) {
                if (sensor.getMediciones() != null) {
                    for (Medicion medicion : sensor.getMediciones()) {
                        total += medicion.getMilimetros();
                    }
                }
            }
        }
        return total;
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

