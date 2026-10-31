package Meteorologia;

public abstract class Persona {
    //Atributos
    protected int dni;
    protected String nombre;
    protected String apellido;
    protected String correoElectronico;
    protected String celular;
    //constructor
    public Persona(int dni,String nombre,String apellido,String correoElectronico,String celular){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.correoElectronico=correoElectronico;
        this.celular=celular;
    }
    //getters y setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    //metodo
    public String getNombreCompleto(){

    }
}
