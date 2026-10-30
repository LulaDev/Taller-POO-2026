public class ResponsableTecnico {
    //atributos
    private String especialidad;
    private String numeroLicencia;

    //constructor
    public ResponsableTecnico(String especialidad,String numeroLicencia){
        this.especialidad=especialidad;
        this.numeroLicencia=numeroLicencia;
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
}
