package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Municipio;
import Modelo.Tablero;
import Modelo.Edificacion;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.List;

public class Barrio implements Casillero, Propiedades {

    public Jugador propietario;
    public String nombre;
    public int costo;
    public List<Edificacion> listaCasas;
    public int alquilerActual;
    public int alquilerOriginal;
    public int valor_mercado;
    Municipio municipio = Municipio.getInstance();

    public Barrio(String unNombre, int valor_propiedad, int elAlquilerOriginal, List edificacionesCasas){
        nombre = unNombre;
        propietario  = null;
        costo = valor_propiedad;
        listaCasas = edificacionesCasas;
        alquilerActual = elAlquilerOriginal;
        alquilerOriginal = elAlquilerOriginal;
        valor_mercado = costo;
    }

    public boolean comprar(Jugador jugador){
        if (jugador.capital() >= costo){
            jugador.comprar(costo, this);
            municipio.cambiar_propietario(jugador, this);
            propietario = jugador;
            return true;
        }
        return false;
    }

    public boolean vender(Jugador jugador){
        if(!jugador.comprar(costo,this)) return false;
        cambiarPropietario(jugador);
        valor_mercado = costo * 85 /100;
        return true;
    }

    public int getValorMercado(){
        return valor_mercado;
    }

    public void cambiarPropietario(Jugador jugador){
        propietario = jugador;
        municipio.cambiar_propietario(jugador,this);
        jugador.agregarPropiedad(this);
        destruirCasasConstruidas();
        alquilerActual = alquilerOriginal;
    }

    public void accionAlCaer(Jugador jugador) {
        if (propietario != jugador && propietario != null){
            jugador.solicitarDinero(alquilerActual);
            propietario.cobrar(alquilerActual);
        }
    }

    public boolean todasLasCasasFueronConstruidas(){
        int cantidad = municipio.edificacionesExistentes(this);

        return cantidad == listaCasas.size();
    }

    public void destruirCasasConstruidas(){
        for (Edificacion casa : listaCasas) {
            casa.destruir();
        }
    }

    public boolean puedeEdificarCasa(Jugador jugador){
        return (jugador.capital() >= listaCasas.get(0).getPrecio() && !todasLasCasasFueronConstruidas());
    }

    public boolean edificarCasa(Jugador jugador) {

        if (! puedeEdificarCasa(jugador)) return false;
        int casasTotales = municipio.edificacionesExistentes(this);
        if (! jugador.solicitarDinero(listaCasas.get(casasTotales).getPrecio())) return false;
        alquilerActual = listaCasas.get(casasTotales).getAlquiler();
        listaCasas.get(casasTotales).construir();
        municipio.agregarEdificacion(this);
        return true;

    }

    public void cederAlBanco(Jugador jugador){

        propietario = null;
        this.destruirCasasConstruidas();
        jugador.cobrar(valor_mercado);
        alquilerActual = alquilerOriginal;

    }

    public String nombre() {
        return nombre;
    }

    public Paint color() { return Color.ORANGE;  }

    public int getCosto(){
        return costo;
    }

}