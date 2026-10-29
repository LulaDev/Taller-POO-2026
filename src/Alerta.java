import java.time.LocalDateTime;
public class Alerta { 
    //atributos
    private int idAlerta;
    private LocalDataTime fechaHoraEmision;
    private NivelAlerta nivel;
    private TipoEventoClimatico evento;
    private String descripcion;
    private boolean atendida;

    //constructor
    public Alerta(int idAlerta, LocalDataTime fechaHoraEmision, NivelAlerta nivel, TipoEventoClimatico evento, String descripcion, boolean atendida){
        this.idAlerta = idAlerta;
        this.fechaHoraEmision = fechaHoraEmision;
        this.nivel = nivel;
        this.evento = evento;
        this.descripcion = descripcion;
        this.atendida = atendida
    }

    //metodos
    public void asignarEquipo(e: EquipoRespuesta){
    }

    public boolean requiereEquipo(){
    }
    
    //getters y setters
    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public LocalDataTime getFechaHoraEmision() {
        return fechaHoraEmision;
    }

    public void setFechaHoraEmision(LocalDataTime fechaHoraEmision) {
        this.fechaHoraEmision = fechaHoraEmision;
    }

    public NivelAlerta getNivel() {
        return nivel;
    }

    public void setNivel(NivelAlerta nivel) {
        this.nivel = nivel;
    }

    public TipoEventoClimatico getEvento() {
        return evento;
    }

    public void setEvento(TipoEventoClimatico evento) {
        this.evento = evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }
}
