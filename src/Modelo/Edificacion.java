package Modelo;

public class Edificacion {

    int precio;
    int alquiler;
    boolean construido;

    public Edificacion(int unPrecio, int unAlquiler){
        precio = unPrecio;
        alquiler = unAlquiler;
        construido = false;
    }

    public int getPrecio(){
        return precio;
    }

    public int getAlquiler(){
        return alquiler;
    }

    public boolean estaEdificado(){
        return construido;
    }

    public void construir(){
        construido = true;
    }

    public void destruir(){
        construido = false;
    }
}
