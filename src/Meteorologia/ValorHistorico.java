package Meteorologia;

public class ValorHistorico {
    //atributos
    private int mes;
    private double acumuladoMedio;

    //constructor
    public ValorHistorico(int mes,double acumuladoMedio){
        this.mes=mes;
        this.acumuladoMedio=acumuladoMedio;
    }

    //getters y setters

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getAcumuladoMedio() {
        return acumuladoMedio;
    }

    public void setAcumuladoMedio(double acumuladoMedio) {
        this.acumuladoMedio = acumuladoMedio;
    }
}
