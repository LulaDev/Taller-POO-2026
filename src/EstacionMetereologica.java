public class EstacionMetereologica {
    //atributos
    private int idEstacion;
    private String nombre;
    private double latitud;
    private double longitud;
    private double altitud;
    private EstadoOperativo estado;
    private TipoEstacion tipo;

    //constructor
    public EstacionMetereologica(int idEstacion,String nombre,double latitud,double longitud,double altitud,EstadoOperativo estado,TipoEstacion tipo){
        this.idEstacion=idEstacion;
        this.nombre=nombre;
        this.latitud=latitud;
        this.longitud=longitud;
        this.altitud=altitud;
        this.estado=estado;
        this.tipo=tipo;
    }
    //getters y setters

    public int getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    public EstadoOperativo getEstado() {
        return estado;
    }

    public void setEstado(EstadoOperativo estado) {
        this.estado = estado;
    }

    public TipoEstacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstacion tipo) {
        this.tipo = tipo;
    }

    //metodos
    public void instalarSensor(s: Sensor){

    }
    public void retirarSensor(s: Sensor){

    }
    public boolean estaOperativa(){

    }

}
