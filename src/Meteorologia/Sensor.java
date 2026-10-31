package Meteorologia;

import java.util.LocalDateTime;

public class Sensor {
    private int idSensor;
    private String marca;
    private String modelo;
    private double precision;
    private EstadoOperativo estado;
    private LocalDate ultimaCalibracion;

    //constructor
    public Sensor(int idSensor, String marca, String modelo, double precision, EstadoOperativo estado, LocalDate ultimaCalibracion) {
        this.idSensor = idSensor;
        this.marca = marca;
        this.modelo = modelo;
        this.precision = precision;
        this.estado = estado;
        this.ultimaCalibracion = ultimaCalibracion;
    }

    //metodos
    public Medicion registrar(mm: double, fh: LocalDateTime){
    
    }

    public boolean validar(mm: double){
        
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
}
