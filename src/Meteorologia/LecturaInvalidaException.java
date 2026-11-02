package Meteorologia;

public class LecturaInvalidaException  extends RuntimeException{

    //constructor
    public LecturaInvalidaException(){
        super();
    }
    public LecturaInvalidaException(String mensaje){
        super(mensaje);
    }
    public LecturaInvalidaException(String mensaje,Throwable causa){
        super(mensaje,causa);
    }
    public LecturaInvalidaException(Throwable causa){
        super(causa);
    }
}
