package meteorologia.domain.models;
import meteorologia.domain.enums.EstadoOperativo;
import meteorologia.domain.enums.TipoEstacion;

import java.util.List;

public class EstacionMeteorologica {
    //atributos
    private int idEstacion;
    private String nombre;
    private double latitud;
    private double longitud;
    private double altitud;
    private EstadoOperativo estado;
    private TipoEstacion tipo;
    private List<Sensor> sensores;
    private ResponsableTecnico responsableTecnico;

    //constructor
    public EstacionMeteorologica(int idEstacion, String nombre, double latitud, double longitud, double altitud, EstadoOperativo estado, TipoEstacion tipo, List<Sensor> sensores, ResponsableTecnico responsableTecnico){
        this.idEstacion=idEstacion;
        this.nombre=nombre;
        this.latitud=latitud;
        this.longitud=longitud;
        this.altitud=altitud;
        this.estado=estado;
        this.tipo=tipo;
        this.sensores = sensores;
        this.responsableTecnico = responsableTecnico;
    }
    //getters y setters

    public int getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    public EstadoOperativo getEstado() {
        return estado;
    }

    public void setEstado(EstadoOperativo estado) {
        this.estado = estado;
    }

    public TipoEstacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstacion tipo) {
        this.tipo = tipo;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores){
        this.sensores = sensores;
    }

    public ResponsableTecnico getResponsableTecnico() {
        return responsableTecnico;
    }

    public void setResponsableTecnico(ResponsableTecnico responsableTecnico) {
        this.responsableTecnico = responsableTecnico;
    }

    //metodos
    public void instalarSensor(Sensor s){
        if (s != null && !this.sensores.contains(s)) {
            this.sensores.add(s);
        }
    }
    public void retirarSensor(Sensor s){
        if (s != null) {
            this.sensores.remove(s);
        }
    }
    public boolean estaOperativa(){
        return this.estado == EstadoOperativo.OPERATIVO;
    }

}
