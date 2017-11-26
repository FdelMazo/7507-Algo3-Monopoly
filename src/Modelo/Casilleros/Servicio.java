package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Municipio;
import Modelo.Tablero;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Servicio implements Casillero, Propiedades{

    private int valor;
    private int valor_mercado;
    private String nombre;
    Municipio municipio = Municipio.getInstance();

    public Servicio(String nombre_servicio, int valor_serv){

        nombre = nombre_servicio;
        valor = valor_serv;
        valor_mercado = valor*85/100;

    }

    public int getValorMercado(){
        return valor_mercado;
    }

    public void accionAlCaer(Jugador jugador){

        Jugador propietario = municipio.devolverPropietario(this);

        if (propietario == null) {
            jugador.comprar(valor,this);
            municipio.cambiar_propietario(jugador,this);
        }
        else if (propietario != jugador){
            int cobro = municipio.devolverAlquilerServicio(this);
            jugador.solicitarDinero(2 * cobro);
            propietario.cobrar(2*cobro);
        }
    }

    public void cederAlBanco( Jugador jugador){

        jugador.cobrar(valor_mercado);


    }

    public void cambiarPropietario(Jugador jugador){
        municipio.cambiar_propietario(jugador,this);
    }

    public String nombre() {
        return nombre;
    }

    public Paint color() { return Color.CRIMSON;  }

    public int calcularCobro(int numDado){
        int cobro = municipio.devolverAlquilerServicio(this);
        return numDado*cobro;
    }

    public int getCosto(){
        return valor;
    }
}
