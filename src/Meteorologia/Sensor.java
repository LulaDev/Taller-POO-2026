package Meteorologia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
public class Sensor {
    private int idSensor;
    private String marca;
    private String modelo;
    private double precision;
    private EstadoOperativo estado;
    private LocalDate ultimaCalibracion;
    private List<Medicion> mediciones;

    //constructor
    public Sensor(int idSensor, String marca, String modelo, double precision, EstadoOperativo estado, LocalDate ultimaCalibracion,List<Medicion> mediciones) {
        this.idSensor = idSensor;
        this.marca = marca;
        this.modelo = modelo;
        this.precision = precision;
        this.estado = estado;
        this.ultimaCalibracion = ultimaCalibracion;
        this.mediciones=mediciones;
    }

    //metodos
    public Medicion registrar( double  mm , LocalDateTime fh){
    
    }

    public boolean validar(double mm){
        
    }

    public boolean requiereCalibracion(){
    
    }

    //getters y setters
    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecision() {
        return precision;
    }
    
    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public EstadoOperativo getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoOperativo estado) {
        this.estado = estado;
    }

    public LocalDate getUltimaCalibracion() {
        return ultimaCalibracion;
    }

    public void setUltimaCalibracion(LocalDate ultimaCalibracion) {
        this.ultimaCalibracion = ultimaCalibracion;
    }
    public List<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(List<Medicion> mediciones) {
        this.mediciones = mediciones;
    }
}
