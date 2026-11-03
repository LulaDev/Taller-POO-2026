package meteorologia.domain.models;
import meteorologia.domain.enums.NivelAlerta;
import meteorologia.domain.enums.NivelVulnerabilidad;
import meteorologia.domain.enums.TipoEventoClimatico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class ZonaGeografica {
    //atributos
    private int idZona;
    private String nombre;
    private NivelVulnerabilidad nivelVulnerabilidad;
    private NivelAlerta nivelAlertaActual ;
    private List<EstacionMeteorologica> estaciones;
    private List<ValorHistorico> valoresHistoricos;
    private List<Alerta> alertas;
    private double umbralAmarilla;
    private double umbralNaranja;
    private double umbralRoja;

    //constructor
    public ZonaGeografica(int idZona,String nombre,NivelVulnerabilidad nivelVunerabilidad,NivelAlerta nivelAlertaActual,List<EstacionMeteorologica> estaciones,List<Alerta> alertas,double umbralAmarilla,double umbralNaranja,double umbralRoja){
        this.idZona=idZona;
        this.nombre=nombre;
        this.nivelVulnerabilidad=nivelVunerabilidad;
        this.nivelAlertaActual=nivelAlertaActual;
        this.estaciones = (estaciones != null) ? estaciones : new ArrayList<>();
        this.valoresHistoricos = new ArrayList<>();
        this.alertas = (alertas != null) ? alertas : new ArrayList<>();
        this.umbralAmarilla=umbralAmarilla;
        this.umbralNaranja=umbralNaranja;
        this.umbralRoja=umbralRoja;
    }
    //getters y setters
    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelVulnerabilidad getNivelVulnerabilidad() {
        return nivelVulnerabilidad;
    }

    public void setNivelVulnerabilidad(NivelVulnerabilidad nivelVulnerabilidad) {
        this.nivelVulnerabilidad = nivelVulnerabilidad;
    }

    public NivelAlerta getNivelAlerta() {
        return nivelAlertaActual;
    }

    public void setNivelAlertaActual(NivelAlerta nivelAlertaActual) {

        this.nivelAlertaActual = nivelAlertaActual;
    }

    public List<EstacionMeteorologica> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(List<EstacionMeteorologica> estaciones) {
        this.estaciones = estaciones;
    }

    public List<ValorHistorico> getValoresHistoricos() {
        return valoresHistoricos;
    }

    public void setValoresHistoricos(List<ValorHistorico> valoresHistoricos) {
     this.valoresHistoricos = valoresHistoricos;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    public double getUmbralAmarilla() {return umbralAmarilla;}

    public void setUmbralAmarilla(double umbralAmarilla) {this.umbralAmarilla = umbralAmarilla;}

    public double getUmbralNaranja() {return umbralNaranja;}

    public void setUmbralNaranja(double umbralNaranja) {this.umbralNaranja = umbralNaranja;}

    public double getUmbralRoja() {return umbralRoja;}

    public void setUmbralRoja(double umbralRoja) {this.umbralRoja = umbralRoja;}

    //metodos
    public void agregarValorHistorico(int mes, double acumuladoMedio){
        this.valoresHistoricos.add(new ValorHistorico(mes, acumuladoMedio));
    }
}
    public double lluviaAcumulada24h(){
        LocalDateTime limite24h = LocalDateTime.now().minusHours(24);
        double totalAcumulado =0.0;

        for (EstacionMeteorologica estacion : estaciones){
            if(estacion.estaOperativa()){
                for(Sensor sensor : estacion.getSensores()){
                    for (Medicion medicion : sensor.getMediciones()){
                        if(medicion.getFechaHora().isAfter(limite24h)){
                            totalAcumulado += medicion.getMilimetros();
                        }
                    }
                }
            }
        }
        return totalAcumulado;
    }

    public NivelAlerta evaluarRiesgo(){
        double acumulada = this.lluviaAcumulada24h();
        if(acumulada >= this.umbralRoja){
            return NivelAlerta.ROJA;
        } else if (acumulada >= this.umbralNaranja) {
            return NivelAlerta.NARANJA;
        } else if (acumulada >= this.umbralAmarilla) {
            return NivelAlerta.AMARILLA;
        } else {
            return NivelAlerta.VERDE;
        }
    }

    public Alerta emitirAlerta(TipoEventoClimatico ev, EquipoRespuesta equipo) {
        NivelAlerta nuevoNivel = evaluarRiesgo();
        this.nivelAlertaActual = nuevoNivel;

        if ((nuevoNivel == NivelAlerta.NARANJA || nuevoNivel == NivelAlerta.ROJA) && equipo == null) {
            throw new IllegalArgumentException("Error: Una alerta de nivel " + nuevoNivel + " requiere la asignación obligatoria de un equipo de respuesta.");
        }

        int nuevoId = this.alertas.size() + 1;
        String desc = "Alerta emitida automáticamente por acumulación de lluvia en 24h: " + lluviaAcumulada24h() + " mm.";
        
        boolean atendida = (equipo != null);
        Alerta nuevaAlerta = new Alerta(nuevoId, LocalDateTime.now(), nuevoNivel, ev, desc, atendida, equipo);
        
        this.alertas.add(nuevaAlerta);
        return nuevaAlerta;
    }

    public Alerta registrarAlertaOperador(NivelAlerta nivel, TipoEventoClimatico evento, String descripcion, EquipoRespuesta equipo) {
        // Regla: Alertas de nivel NARANJA o ROJA requieren asignación obligatoria de equipo
        if ((nivel == NivelAlerta{.NARANJA || nivel == NivelAlerta.ROJA) && equipo == null) {
            throw new IllegalArgumentException("Error: Las alertas de nivel " + nivel + " registradas por operador requieren un equipo de respuesta obligatorio.");
        }

        int nuevoId = this.alertas.size() + 1;
        boolean atendida = (equipo != null);
        
        Alerta nuevaAlerta = new Alerta(nuevoId, LocalDateTime.now(), nivel, evento, descripcion, atendida, equipo);
        
        // Se actualiza el nivel de alerta vigente de la zona y se añade a la lista
        this.nivelAlertaActual = nivel;
        this.alertas.add(nuevaAlerta);
        
        return nuevaAlerta;
    }
}
