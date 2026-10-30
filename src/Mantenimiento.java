import java.time.LocalDate;

public class Mantenimiento {
    //Atributos
    private int idMantenimiento;
    private LocalDate fecha;
    private TipoMantenimiento tipo;
    private String descripcion;


    //Constructor
    public Mantenimiento(int idMantenimiento,LocalDate fecha,TipoMantenimiento tipo,String descripcion){
        this.idMantenimiento=idMantenimiento;
        this.fecha=fecha;
        this.tipo=tipo;
        this.descripcion=descripcion;
    }

    //getters y setters

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoMantenimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMantenimiento tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
