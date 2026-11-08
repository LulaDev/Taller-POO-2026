/*
 * Nombre de la clase: ZonaGeografica.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.models;

import meteorologia.domain.enums.NivelAlerta;
import meteorologia.domain.enums.NivelVulnerabilidad;
import meteorologia.domain.enums.TipoEventoClimatico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa una zona geográfica o cuenca hidrográfica expuesta a riesgos climáticos,
 * encargada de gestionar sus estaciones meteorológicas, valores históricos, el registro 
 * de alertas emitidas y la evaluación de umbrales críticos de precipitación.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public class ZonaGeografica {

    // Constantes estáticas con los valores de referencia estándar para los umbrales de precipitación (en mm)   
    public static final double UMBRAL_DEFECTO_AMARILLA = 50.0;
    public static final double UMBRAL_DEFECTO_NARANJA = 100.0;
    public static final double UMBRAL_DEFECTO_ROJA = 150.0;
    
    // Atributos de instancia
    private int idZona;
    private String nombre;
    private NivelVulnerabilidad nivelVulnerabilidad;
    private NivelAlerta nivelAlertaActual ;
    private List<ValorHistorico> valoresHistoricos;
    private List<EstacionMeteorologica> estaciones;
    private List<Alerta> alertas;
    private double umbralAmarilla;
    private double umbralNaranja;
    private double umbralRoja;

    /**
     * Constructor principal con parámetros para configurar umbrales personalizados por zona.
     * 
     * @param idZona Identificador único de la zona.
     * @param nombre Nombre descriptivo de la cuenca o región.
     * @param nivelVulnerabilidad Grado de vulnerabilidad climática asociado.
     * @param nivelAlertaActual Nivel de alerta vigente en la zona.
     * @param umbralAmarilla Límite inferior en milímetros para activar el nivel amarillo.
     * @param umbralNaranja Límite inferior en milímetros para activar el nivel naranja.
     * @param umbralRoja Límite inferior en milímetros para activar el nivel rojo.
     */
    public ZonaGeografica(int idZona, String nombre, NivelVulnerabilidad nivelVunerabilidad, NivelAlerta nivelAlertaActual, double umbralAmarilla, double umbralNaranja, double umbralRoja){
        this.idZona=idZona;
        this.nombre=nombre;
        this.nivelVulnerabilidad=nivelVunerabilidad;
        this.nivelAlertaActual=nivelAlertaActual;
        this.valoresHistoricos = new ArrayList<ValorHistorico>();
        this.estaciones = new ArrayList<EstacionMeteorologica>();
        this.alertas = new ArrayList<Alerta>();
        this.umbralAmarilla=umbralAmarilla;
        this.umbralNaranja=umbralNaranja;
        this.umbralRoja=umbralRoja;
    }
    
    /**
     * Constructor sobrecargado que inicializa la zona utilizando los umbrales estándar predeterminados.
     * 
     * @param idZona Identificador único de la zona.
     * @param nombre Nombre descriptivo de la cuenca o región.
     * @param nivelVulnerabilidad Grado de vulnerabilidad climática asociado.
     * @param nivelAlertaActual Nivel de alerta vigente inicial.
     */
    public ZonaGeografica(int idZona, String nombre, NivelVulnerabilidad nivelVulnerabilidad, NivelAlerta nivelAlertaActual) {
        this(idZona, nombre, nivelVulnerabilidad, nivelAlertaActual, UMBRAL_DEFECTO_AMARILLA, UMBRAL_DEFECTO_NARANJA, UMBRAL_DEFECTO_ROJA);
    }
    
    /**
     * Incorpora un registro de valor histórico de precipitación media mensual a la zona.
     * 
     * @param mes Número correspondiente al mes del año (1 a 12).
     * @param acumuladoMedio Promedio histórico de precipitación en milímetros.
     */
    public void agregarValorHistorico(int mes, double acumuladoMedio){
        this.valoresHistoricos.add(new ValorHistorico(mes, acumuladoMedio));
    }

    /**
     * Añade una estación meteorológica bajo la jurisdicción de esta zona geográfica.
     * 
     * @param e Estación meteorológica a incorporar.
     */
    public void agregarEstacionMeteorologica(EstacionMeteorologica e){
        this.estaciones.add(e);
    }

    /**
     * Almacena una alerta generada dentro del historial de la zona.
     * 
     * @param a Objeto Alerta a registrar.
     */
    public void agregarAlerta(Alerta a){
        this.alertas.add(a);
    }

    /**
     * Calcula la cantidad total de lluvia acumulada en las últimas 24 horas 
     * sumando las mediciones de los sensores pertenecientes a estaciones operativas.
     * 
     * @return Total de milímetros acumulados en la zona en el último día.
     */
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

    /**
     * Evalúa el nivel de riesgo actual de la zona contrastando la lluvia acumulada 
     * en 24 horas frente a los umbrales configurados.
     * 
     * @return El NivelAlerta resultante (VERDE, AMARILLA, NARANJA o ROJA).
     */
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

/**
     * Emite una alerta de forma automática al superar los umbrales críticos de precipitación.
     * 
     * @param ev Tipo de evento climático detectado.
     * @return La Alerta generada y registrada en el sistema.
     */
    public Alerta emitirAlerta(TipoEventoClimatico ev) {
        NivelAlerta nuevoNivel = evaluarRiesgo();
        this.nivelAlertaActual = nuevoNivel;

        int nuevoId = this.alertas.size() + 1;
        String desc = "Alerta emitida automáticamente por acumulación de lluvia en 24h: " + lluviaAcumulada24h() + " mm.";

        boolean atendida = false; 

        Alerta nuevaAlerta = new Alerta(nuevoId, LocalDateTime.now(), nuevoNivel, ev, desc, atendida, this);

        this.alertas.add(nuevaAlerta);
        return nuevaAlerta;
    }

    /**
     * Registra manualmente una alerta ingresada por un operador del sistema 
     * aplicando los controles reglamentarios de asignación de emergencias.
     * 
     * @param nivel Nivel de severidad indicado por el operador.
     * @param evento Tipo de evento climático reportado.
     * @param descripcion Detalle textual de la situación.
     * @param equipo Equipo de respuesta técnica asignado.
     * @return La Alerta creada y registrada.
     * @throws IllegalArgumentException Si la alerta es de nivel Naranja o Roja y no posee equipo asignado.
     */
    public Alerta registrarAlertaOperador(NivelAlerta nivel, TipoEventoClimatico evento, String descripcion, EquipoRespuesta equipo) {
        if ((nivel == NivelAlerta.NARANJA || nivel == NivelAlerta.ROJA) && equipo == null) {
            throw new IllegalArgumentException("Error: Las alertas de nivel " + nivel + " registradas por operador requieren un equipo de respuesta obligatorio.");
        }

        int nuevoId = this.alertas.size() + 1;
        boolean atendida = (equipo != null);

        Alerta nuevaAlerta = new Alerta(nuevoId, LocalDateTime.now(), nivel, evento, descripcion, atendida, equipo, this);

        this.nivelAlertaActual = nivel;
        this.alertas.add(nuevaAlerta);

        return nuevaAlerta;
    }
    
    // Getters y Setters
    public int getIdZona() {return idZona;}

    public void setIdZona(int idZona) {this.idZona = idZona;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public NivelVulnerabilidad getNivelVulnerabilidad() {return nivelVulnerabilidad;}

    public void setNivelVulnerabilidad(NivelVulnerabilidad nivelVulnerabilidad) {this.nivelVulnerabilidad = nivelVulnerabilidad;}

    public NivelAlerta getNivelAlerta() {return nivelAlertaActual;}

    public void setNivelAlertaActual(NivelAlerta nivelAlertaActual) {this.nivelAlertaActual = nivelAlertaActual;}

    public List<EstacionMeteorologica> getEstaciones() {return estaciones;}

    public void setEstaciones(List<EstacionMeteorologica> estaciones) {this.estaciones = estaciones;}

    public List<ValorHistorico> getValoresHistoricos() {return valoresHistoricos;}

    public void setValoresHistoricos(List<ValorHistorico> valoresHistoricos) {this.valoresHistoricos = valoresHistoricos;}

    public List<Alerta> getAlertas() {return alertas;}

    public void setAlertas(List<Alerta> alertas) {this.alertas = alertas;}

    public double getUmbralAmarilla() {return umbralAmarilla;}

    public void setUmbralAmarilla(double umbralAmarilla) {this.umbralAmarilla = umbralAmarilla;}

    public double getUmbralNaranja() {return umbralNaranja;}

    public void setUmbralNaranja(double umbralNaranja) {this.umbralNaranja = umbralNaranja;}

    public double getUmbralRoja() {return umbralRoja;}

    public void setUmbralRoja(double umbralRoja) {this.umbralRoja = umbralRoja;}
}
