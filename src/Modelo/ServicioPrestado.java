
package Modelo;

import java.io.Serializable;

public class ServicioPrestado implements Serializable {
    private Moto moto;
    private Cliente cliente;
    private String fecha;
    private String tipoServicio;

    public ServicioPrestado(Moto moto, Cliente cliente, String fecha, String tipoServicio) {
        this.moto = moto;
        this.cliente = cliente;
        this.fecha = fecha;
        this.tipoServicio = tipoServicio;
    }

    public ServicioPrestado() {
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString() {
        return "ServicioPrestado{" + "moto=" + moto + ", cliente=" + cliente + ", fecha=" + fecha + ", tipoServicio=" + tipoServicio + '}';
    }

   

    
}    








