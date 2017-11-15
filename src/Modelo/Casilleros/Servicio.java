package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public class Servicio implements Casillero{

    private int valor;
    private int cobro_regular;
    private  int cobro_plus;
    private Jugador propietario;
    private String nombre;

    Servicio(String nombre_servicio, int valor_serv , int cobro_regular_serv, int cobro_plus_serv){
        nombre = nombre_servicio;
        valor = valor_serv;
        cobro_plus = cobro_plus_serv;
        cobro_regular = cobro_regular_serv;
        propietario = null ;
    }

    public void agregarPropietario(Jugador jugador){
        propietario = jugador;
    }

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero){
        if (propietario == null) {
            jugador.solicitar_dinero(valor);
            this.agregarPropietario(jugador);
            jugador.agregar_servicio(this);
        }
        else{
            jugador.solicitar_dinero(numDado * cobro_regular);
        }

    }

    public boolean permiteSalida(Jugador jugador){
        return true;
    }

    public void accionAlPartir(Jugador jugador){
        return;
    }

    public int resetear(){
        propietario = null;
        return valor*85/100;
    }

}
