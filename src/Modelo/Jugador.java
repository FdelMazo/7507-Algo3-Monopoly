package Modelo;

import Modelo.Casilleros.Barrio;
import Modelo.Casilleros.Propiedades;
import Modelo.Casilleros.Servicio;
import Modelo.Casilleros.Casillero;

import java.util.ArrayList;

public class Jugador {

    private int capital;
    private ArrayList<Propiedades> propiedades;
    private Casillero casilleroActual;
    private String nombre;

    public Jugador(String nombre_jugador) {
        this.capital = 100000;
        propiedades = new ArrayList<>();
        casilleroActual = null ;  //debería ser la de salida
        nombre = nombre_jugador;
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

    public boolean solicitar_dinero( double dinero_solicitado)    {
        if ( capital > dinero_solicitado){
            capital -= dinero_solicitado;
           return true;
        }
        boolean resultado = this.vender_propiedades((int)(dinero_solicitado));
        return resultado;
    }

    public boolean vender_propiedades(int dinero_solicitado) {

        int monto_a_alcanzar = dinero_solicitado - capital;
        int monto_conseguido = 0;

        for (int i = 0; i < propiedades.size(); i++) {
            monto_conseguido += propiedades.get(i).resetear();
            if (monto_conseguido >= monto_a_alcanzar) {
                this.cobrar_ingreso(monto_conseguido);
                this.solicitar_dinero(dinero_solicitado);
                return true;
            }
        }
        return false;
    }

    public void agregar_propiedad(Propiedades propiedad){
        propiedades.add(propiedad);
    }

    public String nombre(){
        return nombre;
    }

    public boolean posee(String propiedad){
        for ( int i=0 ; i < propiedades.size(); i++){
            if (propiedad == propiedades.get(i).nombre()){
                return true;
            }
        }
        return false;
    }
}
