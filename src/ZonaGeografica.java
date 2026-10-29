public class ZonaGeografica {
    //atributos
    private int idZona;
    private String nombre;
    private nivelVulnerabilidad NivelVulnerabilidad;
    private nivelAlertaActual NivelAlerta;
    //constructor
    public ZonaGeografica(int idZona,String nombre,nivelVulnerabilidad NivelVunerabilidad,nivelAlerta NivelAlerta){
        this.idZona=idZona;
        this.nombre=nombre;
        this.NivelVulnerabilidad=NivelVunerabilidad;
        this.NivelAlerta=NivelAlerta;
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

    public nivelVulnerabilidad getNivelVulnerabilidad() {
        return NivelVulnerabilidad;
    }

    public void setNivelVulnerabilidad(nivelVulnerabilidad nivelVulnerabilidad) {
        NivelVulnerabilidad = nivelVulnerabilidad;
    }

    public nivelAlertaActual getNivelAlerta() {
        return NivelAlerta;
    }

    public void setNivelAlerta(nivelAlertaActual nivelAlerta) {
        NivelAlerta = nivelAlerta;
    }

    //metodos
    public double lluviaAcumulada24h(){

    }

    public NivelAlerta evaluarRiesgo(){

    }
    public Alerta emitirAlerta(ev: TipoEventoClimatico){

    }
}
