package meteorologia.domain.models;

import meteorologia.domain.enums.TipoMantenimiento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mantenimiento {
    //Atributos
    private int idMantenimiento;
    private LocalDate fecha;
    private TipoMantenimiento tipo;
    private String descripcion;
    private ResponsableTecnico responsable;
    private Sensor sensor;

    //Constructor
    public Mantenimiento(int idMantenimiento,LocalDate fecha,TipoMantenimiento tipo,String descripcion,ResponsableTecnico responsable, Sensor sensor){
        this.idMantenimiento=idMantenimiento;
        this.fecha=fecha;
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.responsable=responsable;
        this.sensor = sensor;
    }

    public Mantenimiento(int idMantenimiento,LocalDate fecha,TipoMantenimiento tipo,String descripcion,ResponsableTecnico responsable){
        this.idMantenimiento=idMantenimiento;
        this.fecha=fecha;
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.responsable=responsable;
    }

    //getters y setters

    public int getIdMantenimiento() {return idMantenimiento;}

    public void setIdMantenimiento(int idMantenimiento) {this.idMantenimiento = idMantenimiento;}

    public LocalDate getFecha() {return fecha;}

    public void setFecha(LocalDate fecha) {this.fecha = fecha;}

    public TipoMantenimiento getTipo() {return tipo;}

    public void setTipo(TipoMantenimiento tipo) {this.tipo = tipo;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public ResponsableTecnico getResponsable() {return responsable;}

    public void setResponsable(ResponsableTecnico responsable) {this.responsable = responsable;}

    public Sensor getSensor() {return sensor;}

    public void setSensor(Sensor sensor) {this.sensor = sensor;}


}
