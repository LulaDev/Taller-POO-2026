package Meteorologia;

public class ZonaGeografica {
    //atributos
    private int idZona;
    private String nombre;
    private NivelVulnerabilidad nivelVulnerabilidad;
    private NivelAlerta nivelAlertaActual ;
    //constructor
    public ZonaGeografica(int idZona,String nombre,NivelVulnerabilidad nivelVunerabilidad,NivelAlerta nivelAlertaActual){
        this.idZona=idZona;
        this.nombre=nombre;
        this.nivelVulnerabilidad=nivelVunerabilidad;
        this.nivelAlertaActual=nivelAlertaActual;
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
        nivelVulnerabilidad = nivelVulnerabilidad;
    }

    public NivelAlerta getNivelAlerta() {
        return nivelAlertaActual;
    }

    public void setNivelAlertaActual(NivelAlerta nivelAlertaActual) {

        this.nivelAlertaActual = nivelAlertaActual;
    }

    //metodos
    public double lluviaAcumulada24h(){

    }

    public NivelAlerta evaluarRiesgo(){

    }
    public Alerta emitirAlerta(TipoEventoClimatico ev){

    }
}
