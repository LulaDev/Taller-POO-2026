package Meteorologia;
import java.util.List;
public class EquipoRespuesta {
    //Atributos
    private int idEquipo;
    private String nombreEquipo;
    private boolean disponible;
    private List<ResponsableTecnico> integrantes;

    //Constructor
    public EquipoRespuesta(int idEquipo,String nombreEquipo,boolean disponible,List<ResponsableTecnico> integrantes){
        this.idEquipo=idEquipo;
        this.nombreEquipo=nombreEquipo;
        this.disponible=disponible;
        this.integrantes=integrantes;
    }

    //getters y setters

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<ResponsableTecnico> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<ResponsableTecnico> integrantes) {
        this.integrantes = integrantes;
    }

    //metodo
    public void agregarIntegrante(ResponsableTecnico r){

    }
}
