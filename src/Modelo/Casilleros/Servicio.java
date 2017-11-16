package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public class Servicio implements Casillero, Propiedades{

    private int valor;
    private int cobro_regular;
    private  int cobro_plus;
    private int cobro;
    private Jugador propietario;
    private String nombre;
    private String clase_hermana;

    Servicio(String nombre_servicio, int valor_serv , int cobro_regular_serv, int cobro_plus_serv, String nombre_hermana){
        nombre = nombre_servicio;
        valor = valor_serv;
        cobro_plus = cobro_plus_serv;
        cobro_regular = cobro_regular_serv;
        propietario = null ;
        cobro = cobro_regular;
        clase_hermana = nombre_hermana;
    }

    public void agregarPropietario(Jugador jugador){
        propietario = jugador;
    }

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero){
        if (propietario == null) {
            jugador.solicitar_dinero(valor);
            this.agregarPropietario(jugador);
            jugador.agregar_propiedad(this);
            if (jugador.posee(clase_hermana)){
                cobro = cobro_plus;
            }
        }
        else if (propietario != jugador){
            jugador.solicitar_dinero(numDado * cobro);
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

    public String nombre() {
        return nombre;
    }
}
