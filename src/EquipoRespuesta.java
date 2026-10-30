public class EquipoRespuesta {
    //Atributos
    private int idEquipo;
    private String nombreEquipo;
    private boolean disponible;

    //Constructor
    public EquipoRespuesta(int idEquipo,String nombreEquipo,boolean disponible){
        this.idEquipo=idEquipo;
        this.nombreEquipo=nombreEquipo;
        this.disponible=disponible;
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

    //metodo
    public void agregarIntegrante(r: ResponsableTecnico){

    }
}
