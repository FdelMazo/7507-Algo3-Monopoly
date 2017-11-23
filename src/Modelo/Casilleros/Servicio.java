package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Municipio;
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
        valor_mercado = valor * 85 / 100;

    }

    public void accionAlCaer(Jugador jugador){

        Jugador propietario = municipio.devolverPropietario(this);
        if (propietario == null) {
            jugador.solicitarDinero(valor);
            municipio.cambiar_propietario(jugador,this);
        }
        else if (propietario != jugador){
            int dineroACobrar = calcularCobro(jugador.sumaDados());
            jugador.solicitarDinero(dineroACobrar);
            propietario.cobrar(dineroACobrar);
        }
    }

    public int calcularCobro(int numDado){
        int cobro = municipio.devolverAlquilerServicio(this);
        return numDado*cobro;
    }

    public void cederAlBanco( Jugador jugador){

        municipio.cambiar_propietario(null,this);
        jugador.cobrar(valor_mercado);

    }

    public void cambiarPropietario(Jugador jugador){
        municipio.cambiar_propietario(jugador,this);
    }

    public String nombre() {
        return nombre;
    }

    public Paint color() { return Color.RED;  }}
