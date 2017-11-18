package Modelo.Casilleros;

import Modelo.Edificacion;
import Modelo.Jugador;

import java.util.List;

public class BarrioDoble extends Barrio{
    BarrioDoble hermano;
    List<Edificacion> listaHoteles;

    public BarrioDoble(String unNombre, int valor_propiedad, int elAlquilerOriginal, List edificacionesCasas, List edificacionesHoteles) {
        super(unNombre,valor_propiedad, elAlquilerOriginal, edificacionesCasas);
        listaHoteles = edificacionesHoteles;
    }

    public void setHermano(BarrioDoble barrioHermano){
        hermano = barrioHermano;
    }

    public boolean tienenMismoPropietario(BarrioDoble barrioHermano){
        return propietario == barrioHermano.duenio();
    }

    public boolean puedeEdificarCasa(Jugador jugador) {
        return (jugador.capital() >= listaCasas.get(0).getPrecio() && !todasLasCasasFueronConstruidas() && tienenMismoPropietario(hermano));
    }

    public boolean puedeEdificarHotel(Jugador jugador){
        return (jugador.capital() >= listaHoteles.get(0).getPrecio() && todasLasCasasFueronConstruidas() && tienenMismoPropietario(hermano) && hermano.todasLasCasasFueronConstruidas());
    }

    public boolean edificarHotel(Jugador jugador){
        if (puedeEdificarHotel(jugador)){
            alquilerActual = listaHoteles.get(0).getAlquiler();
            jugador.solicitar_dinero(listaHoteles.get(0).getPrecio());
            return true;
        }
        return false;
    }
}
