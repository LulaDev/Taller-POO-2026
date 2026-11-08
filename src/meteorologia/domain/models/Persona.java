/*
 * Nombre de la clase: Persona.java
 * Versión: 1.0
 * Fecha: 2026-11-05
 * Copyright: POO Taller 2026 - FCAD UNER
 */

package meteorologia.domain.models;

/**
 * Clase abstracta que representa los datos básicos de identificación de una persona 
 * dentro del sistema, sirviendo como clase base para el personal técnico.
 * 
 * @author Lautaro Joaquin Fernandez; Ludmila Mildemberger
 * @version 1.0
 */
public abstract class Persona {

    // Atributos protegidos de instancia
    protected int dni;
    protected String nombre;
    protected String apellido;
    protected String correoElectronico;
    protected String celular;
    
    /**
     * Constructor con parámetros para inicializar los datos generales de la persona.
     * 
     * @param dni Documento Nacional de Identidad.
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param correoElectronico Correo electrónico de contacto.
     * @param celular Número de teléfono celular.
     */
    public Persona(int dni,String nombre,String apellido,String correoElectronico,String celular){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.correoElectronico=correoElectronico;
        this.celular=celular;
    }

    /**
     * Retorna el nombre completo uniendo el nombre y el apellido.
     * 
     * @return Cadena de texto con el nombre completo.
     */
    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }
    
    // Getters y Setters
    public int getDni() {return dni;}

    public void setDni(int dni) {this.dni = dni;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getCorreoElectronico() {return correoElectronico;}

    public void setCorreoElectronico(String correoElectronico) {this.correoElectronico = correoElectronico;}

    public String getCelular() {return celular;}

    public void setCelular(String celular) {this.celular = celular;}
}
