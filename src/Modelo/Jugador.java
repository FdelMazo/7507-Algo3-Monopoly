package Modelo;

import java.util.ArrayList;

public class Jugador {

    private int capital;
    private ArrayList<Barrio> propiedades;
    private Casillero casillaActual;
    private String nombre;

    public Jugador(String nombre_jugador) {

        this.capital = 100000;
        propiedades = new ArrayList<>();
        casillaActual = null ;  //debería ser la de salida
        nombre = nombre_jugador;
    }
    public int devolverCantPropiedades(){
        return propiedades.size() ;
    }

    public void cobrar_ingreso(int monto){
        capital += monto;
    }

    public void asignarCasilla ( Casillero nueva_casilla){
     casillaActual = nueva_casilla;
    }

    public int capital(){
        return capital;
    }

    public void pedir_dinero( int dinero_solicitado){
        capital -= dinero_solicitado;
    }

    public void agregar_propiedad(Barrio barrio){
        propiedades.add(barrio);
    }

    public String nombre(){
        return nombre;
    }
}
