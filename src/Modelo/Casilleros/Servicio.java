package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero){

        if (propietario == null) {
            jugador.solicitarDinero(valor);
            cambiarPropietario(jugador);
            jugador.agregarPropiedad(this);
        }
        else if (propietario != jugador){
            if (propietario.posee(clase_hermana)) {
                cobro = cobro_plus;
            }
            jugador.solicitarDinero(numDado * cobro);
            propietario.cobrar(numDado*cobro);
        }
    }

    public void cederAlBanco( Jugador jugador){

        propietario = null;
        jugador.cobrar(valor_mercado);

    }

    public void cambiarPropietario(Jugador jugador){
        propietario = jugador;
    }

    public String nombre() {
        return nombre;
    }

    public Paint color() { return Color.RED;  }}
