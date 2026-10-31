package Meteorologia;
import java.util.List;

public class ResponsableTecnico extends Persona{
    //atributos
    private String especialidad;
    private String numeroLicencia;
    private List<EstacionMeteorologica> estacionesACargo;
    private List<Mantenimiento> mantenimientosRealizados;
    private EquipoRespuesta equipoRespuesta;

    //constructor
    public ResponsableTecnico(int dni, String nombre, String apellido, String correoElectronico, String celular, String especialidad, String numeroLicencia, List<EstacionMeteorologica> estacionesACargo, List<Mantenimiento> mantenimientosRealizados, EquipoRespuesta equipoRespuesta){
        super(dni, nombre, apellido, correoElectronico, celular);
        this.especialidad=especialidad;
        this.numeroLicencia=numeroLicencia;
        this.estacionesACargo = estacionesACargo;
        this.mantenimientosRealizados = mantenimientosRealizados;
    }
    
    //getters y  setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public List<EstacionMeteorologica> getEstacionesACargo(){
        return estacionesACargo;
    }

    public void setEstacionesACargo(List<EstacionMeteorologica> estacionesACargo){
        this.estacionesACargo = estacionesACargo;
    }

    public List<Mantenimiento> getMantenimientosRealizados(){
        return mantenimientosRealizados;
    }

    public void setMantimientosRealizados(List<Mantenimiento> mantenimientosRealizados){
        this.mantenimientosRealizados = mantenimientosRealizados;
    }

    public EquipoRespuesta getEquipoRespuesta(){
        return equipoRespuesta;
    }

    public void setEquipoRespuesta(EquipoRespuesta equipoRespuesta){
        this.equipoRespuesta = equipoRespuesta;
    }
}
