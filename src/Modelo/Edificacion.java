package Modelo;

public class Edificacion {

    private int precio;
    private int alquiler;
    private boolean construido;

    public Edificacion(int unPrecio, int unAlquiler){

        precio = unPrecio;
        alquiler = unAlquiler;
    }

    public int getPrecio(){
        return precio;
    }

    public int getAlquiler(){
        return alquiler;
    }

}
