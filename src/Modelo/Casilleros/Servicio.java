package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Municipio;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Servicio implements Casillero, Propiedades{

    private int costo;
    private int costoMercado;
    private String nombre;
    Municipio municipio = Municipio.getInstance();

    public Servicio(String nombre_servicio, int valor_serv){

        nombre = nombre_servicio;
        costo = valor_serv;
        costoMercado = costo *85/100;

    }

    public boolean comprar(Jugador jugador){
        if (jugador.capital() >= costo){
            jugador.comprar(costo, this);
            return true;
        }
        return false;
    }

    public int getValorMercado(){
        return costoMercado;
    }

    public void accionAlCaer(Jugador jugador){
        Jugador propietario = municipio.devolverPropietario(this);
        if (propietario != jugador && propietario != null){
            int cobro = municipio.devolverAlquilerServicio(this);
            jugador.solicitarDinero(2 * cobro);
            propietario.cobrar(2*cobro);
        }
    }

    public void cederAlBanco( Jugador jugador){
        jugador.cobrar(costoMercado);
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
        return costo;
    }

    public boolean edificarCasa(Jugador jugador){ return false; }

}
