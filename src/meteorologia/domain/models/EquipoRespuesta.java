package meteorologia.domain.models;
import java.util.List;
import java.util.ArrayList;

public class EquipoRespuesta {
    //Atributos
    private int idEquipo;
    private String nombreEquipo;
    private boolean disponible;
    private List<ResponsableTecnico> integrantes;
    private List<Alerta> alertas;

    //Constructor
    public EquipoRespuesta(int idEquipo,String nombreEquipo,boolean disponible){
        this.idEquipo=idEquipo;
        this.nombreEquipo=nombreEquipo;
        this.disponible=disponible;
        this.integrantes = new ArrayList<ResponsableTecnico>();
        this.alertas = new ArrayList<Alerta>();
    }

    //metodo
    public void agregarIntegrante(ResponsableTecnico r){
        this.integrantes.add(r);
    }

    public void agregarAlerta(Alerta a){
        this.alertas.add(a);
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

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas){
        this.alertas = alertas;
    }
}
