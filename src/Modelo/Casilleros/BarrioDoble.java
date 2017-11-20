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

    public boolean duenioDeAmbosHermanos(){
        return propietario.posee(hermano.nombre());
    }

    public boolean puedeEdificarCasa(Jugador jugador) {
        return (super.puedeEdificarCasa(jugador) && duenioDeAmbosHermanos());
    }

    public boolean puedeEdificarHotel(Jugador jugador){
        return (todasLasCasasFueronConstruidas() && hermano.todasLasCasasFueronConstruidas()) && duenioDeAmbosHermanos();

    }

    public boolean edificarHotel(Jugador jugador){
        if (! puedeEdificarHotel(jugador))return false;
        if (!jugador.solicitarDinero(listaHoteles.get(0).getPrecio())) return false;
        alquilerActual = listaHoteles.get(0).getAlquiler();
        return true;
    }
}
