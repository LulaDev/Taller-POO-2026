package meteorologia.domain.models;
import java.util.List;
import java.util.ArrayList;

public class ResponsableTecnico extends Persona{
    //atributos
    private String especialidad;
    private String numeroLicencia;
    private List<EstacionMeteorologica> estacionesACargo;
    private List<Mantenimiento> mantenimientosRealizados;
    private EquipoRespuesta equipoRespuesta;

    //constructor
    public ResponsableTecnico(int dni, String nombre, String apellido, String correoElectronico, String celular, String especialidad, String numeroLicencia, EquipoRespuesta equipoRespuesta){
        super(dni, nombre, apellido, correoElectronico, celular);
        this.especialidad=especialidad;
        this.numeroLicencia=numeroLicencia;
        this.estacionesACargo = new ArrayList<EstacionMeteorologica>();
        this.mantenimientosRealizados = new ArrayList<Mantenimiento>();
        this.equipoRespuesta = equipoRespuesta;
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

    public void setMantenimientosRealizados(List<Mantenimiento> mantenimientosRealizados){
        this.mantenimientosRealizados = mantenimientosRealizados;
    }

    public EquipoRespuesta getEquipoRespuesta(){
        return equipoRespuesta;
    }

    public void setEquipoRespuesta(EquipoRespuesta equipoRespuesta){
        this.equipoRespuesta = equipoRespuesta;
    }


    //metodos
    public void agregarEstacionMeteorologica(EstacionMeteorologica em){
        this.estacionesACargo.add(em);
    }
    public void agregarMantenimiento(Mantenimiento ma){
        this.mantenimientosRealizados.add(ma);
    }
}
