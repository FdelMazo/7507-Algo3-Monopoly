package Modelo;

public class Edificacion {
    int precio;
    int alquiler;
    boolean estado;

    public Edificacion(int unPrecio, int unAlquiler){
        precio = unPrecio;
        alquiler = unAlquiler;
        estado = false;
    }

    public int getPrecio(){
        return precio;
    }

    public int getAlquiler(){
        return alquiler;
    }

    public boolean estaEdificado(){
        return estado;
    }

    public void cambiarEstadoDeEdificacionATrue(){
        estado = true;
    }

    public void cambiarEstadoDeEdificacionAFalse(){
        estado = false;
    }
}
