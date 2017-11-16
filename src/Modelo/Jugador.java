package Modelo;


import Modelo.Casilleros.Propiedades;
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

    public boolean comprar(Propiedades propiedad, Jugador jugador){
        if (capital >= propiedad.valorMercado()){
            propiedad.vender(this);
            jugador.cobrar_ingreso(propiedad.valorMercado());
            return true;
        }
        return false;
    }

    public boolean vender (Jugador jugador,Propiedades propiedad){

        boolean resultado = jugador.comprar(propiedad,this);
        if(resultado == true){
            propiedades.remove(0);
            return true;
        }
        return false;
    }

    public void venderAlBanco(){

        Propiedades propiedad = propiedades.remove(0);
        int costo = propiedad.resetear();
        this.cobrar_ingreso(costo);
    }

    public Propiedades propiedadParaIntercambiar(){
        return  propiedades.remove(0);
    }

    public void intercambiarPropiedades(Jugador jugador){

        Propiedades propiedad1 = this.propiedadParaIntercambiar();
        Propiedades propiedad2 = jugador.propiedadParaIntercambiar();
        jugador.agregar_propiedad(propiedad1);
        this.agregar_propiedad(propiedad2);
    }

    public boolean solicitar_dinero( double dinero_solicitado)    {
        if ( capital > dinero_solicitado){
            capital -= dinero_solicitado;
           return true;
        }
        boolean resultado = this.vender_propiedades((int)(dinero_solicitado), null);
        return resultado;
    }

    public boolean vender_propiedades(int dinero_solicitado, Jugador jugador) {

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
