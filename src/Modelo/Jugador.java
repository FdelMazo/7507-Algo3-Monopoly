package Modelo;

import Modelo.Casilleros.Barrio;
import Modelo.Casilleros.Casillero;

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

    //public int tirarDados

    public void empezarTurno(){ casillaActual.accionAlPartir(this); }

    public void caeEn(Casillero casillero, int numDado){
        casillaActual = casillero;
        casillaActual.accionAlCaer(this, numDado);
    }

    //public void casilleroActual(){ return casillaActual; }

    public void cobrar_ingreso(int monto){
        capital += monto;
    }

    public int capital(){
        return capital;
    }

    public void pedir_dinero( int dinero_solicitado){ capital -= dinero_solicitado;   }
    public boolean solicitar_dinero( int dinero_solicitado)    {
        if (capital>dinero_solicitado){
           pedir_dinero(dinero_solicitado);
           return true;
        }
        return false;
    }


    public void agregar_propiedad(Barrio barrio){
        propiedades.add(barrio);
    }

    public String nombre(){
        return nombre;
    }
}
