package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public class Servicio implements Casillero, Propiedades{

    private int valor;
    private int valor_mercado;
    private int cobro_regular;
    private  int cobro_plus;
    private int cobro;
    private Jugador propietario;
    private String nombre;
    private String clase_hermana;

    public Servicio(String nombre_servicio, int valor_serv, int cobro_regular_serv, int cobro_plus_serv, String nombre_hermana){
        nombre = nombre_servicio;
        valor = valor_serv;
        cobro_plus = cobro_plus_serv;
        cobro_regular = cobro_regular_serv;
        propietario = null ;
        cobro = cobro_regular;
        clase_hermana = nombre_hermana;
        valor_mercado = valor * 85 / 100;
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
            if (propietario.posee(clase_hermana)) {
                cobro = cobro_plus;
            }
            jugador.solicitar_dinero(numDado * cobro);
            propietario.cobrar_ingreso(numDado*cobro);
        }

    }

    public int resetear(){
        propietario = null;
        return valor_mercado;
    }

    public boolean vender(Jugador jugador){
        if(!jugador.solicitar_dinero(valor_mercado)) return false;
        jugador.agregar_propiedad(this);
        propietario = jugador;
        return true;
    }

    public int valorMercado(){return valor_mercado;}

    public void cambiarPropietario(Jugador jugador){
        propietario = jugador;
    }

    public String nombre() {
        return nombre;
    }

    public Jugador devolverDuenio(){
        return propietario;
    }
}
