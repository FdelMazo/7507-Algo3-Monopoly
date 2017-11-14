package Modelo;

import Modelo.Casilleros.Barrio;
import Modelo.Casilleros.Servicio;
import Modelo.Casilleros.Casillero;

import java.util.ArrayList;

public class Jugador {

    private int capital;
    private ArrayList<Barrio> propiedades;
    private Casillero casilleroActual;
    private String nombre;
    private ArrayList<Servicio> servicios;

    public Jugador(String nombre_jugador) {
        this.capital = 100000;
        propiedades = new ArrayList<>();
        casilleroActual = null ;  //debería ser la de salida
        nombre = nombre_jugador;
        servicios = new ArrayList<>();
    }

    public int devolverCantPropiedades(){
        return propiedades.size() ;
    }

    public void empezarTurno(){ casilleroActual.accionAlPartir(this); }

    public void caeEn(Casillero casillero, int numDado, Tablero tablero){
        casilleroActual = casillero;
        casilleroActual.accionAlCaer(this, numDado, tablero);
    }

    public Casillero actual(){ return casilleroActual; }

    public void cobrar_ingreso(int monto){
        capital += monto;
    }

    public int capital(){
        return capital;
    }

    public boolean solicitar_dinero( int dinero_solicitado)    {
        if (capital>dinero_solicitado){
            capital -= dinero_solicitado;
           return true;
        }
        return false;
    }

    public void agregar_propiedad(Barrio barrio){
        propiedades.add(barrio);
    }

    public void agregar_servicio(Servicio servicio){
        servicios.add(servicio);
    }

    public String nombre(){
        return nombre;
    }
}
