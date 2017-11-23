package Modelo.Casilleros;

import Modelo.Jugador;
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
    public int casasTotales;
    public int valor_mercado;

    public Barrio(String unNombre, int valor_propiedad, int elAlquilerOriginal, List edificacionesCasas){
        nombre = unNombre;
        propietario  = null;
        costo = valor_propiedad;
        listaCasas = edificacionesCasas;
        alquilerActual = elAlquilerOriginal;
        alquilerOriginal = elAlquilerOriginal;
        casasTotales = 0;
        valor_mercado = costo;
    }

    public boolean vender(Jugador jugador){
        if(!jugador.solicitarDinero(valor_mercado)) return false;
        cambiarPropietario(jugador);
        valor_mercado = costo * 85 /100;
        return true;
        }

    public void cambiarPropietario(Jugador jugador){
        propietario = jugador;
        jugador.agregarPropiedad(this);
        destruirCasasConstruidas();
        alquilerActual = alquilerOriginal;
    }

    public void accionAlCaer(Jugador jugador) {

        if (propietario == null){
            this.vender(jugador);
        }
        else if (propietario != jugador){
            jugador.solicitarDinero(alquilerActual);
            propietario.cobrar(alquilerActual);
        }
    }

    public boolean todasLasCasasFueronConstruidas(){
        for (Edificacion casa : listaCasas) {
            if (!casa.estaEdificado()) return false;
        }
        return true;
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
        if (! jugador.solicitarDinero(listaCasas.get(casasTotales).getPrecio())) return false;
        alquilerActual = listaCasas.get(casasTotales).getAlquiler();
        listaCasas.get(casasTotales).construir();
        casasTotales += 1;
        return true;
    }

    public void cederAlBanco(Jugador jugador){

        propietario = null;
        this.destruirCasasConstruidas();
        jugador.cobrar(valor_mercado);

    }

    public String nombre() {
        return nombre;
    }

    public Paint color() { return Color.ORANGE;  }

}
