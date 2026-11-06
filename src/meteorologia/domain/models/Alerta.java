package meteorologia.domain.models;
import meteorologia.domain.enums.NivelAlerta;
import meteorologia.domain.enums.TipoEventoClimatico;

import java.time.LocalDateTime;

public class Alerta {
    //atributos
    private int idAlerta;
    private LocalDateTime fechaHoraEmision;
    private NivelAlerta nivel;
    private TipoEventoClimatico evento;
    private String descripcion;
    private boolean atendida;
    private EquipoRespuesta equipoRespuesta;
    private ZonaGeografica zona;

    //constructor
    public Alerta(int idAlerta, LocalDateTime fechaHoraEmision, NivelAlerta nivel, TipoEventoClimatico evento, String descripcion, boolean atendida, EquipoRespuesta equipoRespuesta, ZonaGeografica zona){
        this.idAlerta = idAlerta;
        this.fechaHoraEmision = fechaHoraEmision;
        this.nivel = nivel;
        this.evento = evento;
        this.descripcion = descripcion;
        this.atendida = atendida;
        this.equipoRespuesta = equipoRespuesta;
        this.zona = zona;
    }

    //constructor sin equipoRespuesta
    public Alerta(int idAlerta, LocalDateTime fechaHoraEmision, NivelAlerta nivel, TipoEventoClimatico evento, String descripcion, boolean atendida, ZonaGeografica zona){
        this.idAlerta = idAlerta;
        this.fechaHoraEmision = fechaHoraEmision;
        this.nivel = nivel;
        this.evento = evento;
        this.descripcion = descripcion;
        this.atendida = atendida;
        this.zona = zona;
    }

    //metodos
    public void asignarEquipo(EquipoRespuesta e){
        if (e != null) {
            this.equipoRespuesta = e;
            this.atendida = true;
        }
    }

    public boolean requiereEquipo(){
        return this.nivel == NivelAlerta.NARANJA || this.nivel == NivelAlerta.ROJA;
    }
    
    //getters y setters
    public int getIdAlerta() {return idAlerta;}

    public void setIdAlerta(int idAlerta) {this.idAlerta = idAlerta;}

    public LocalDateTime getFechaHoraEmision() {return fechaHoraEmision;}

    public void setFechaHoraEmision(LocalDateTime fechaHoraEmision) {this.fechaHoraEmision = fechaHoraEmision;}

    public NivelAlerta getNivel() {return nivel;}

    public void setNivel(NivelAlerta nivel) {this.nivel = nivel;}

    public TipoEventoClimatico getEvento() {return evento;}

    public void setEvento(TipoEventoClimatico evento) {this.evento = evento;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public boolean isAtendida() {return atendida;}

    public void setAtendida(boolean atendida) {this.atendida = atendida;}

    public EquipoRespuesta getEquipoRespuesta() {return equipoRespuesta;}

    public void setEquipoRespuesta(EquipoRespuesta equipoRespuesta) {this.equipoRespuesta = equipoRespuesta;}

    public ZonaGeografica getZona(){return zona;}

    public void setZona(ZonaGeografica zona){this.zona = zona;}
}
