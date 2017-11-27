package Modelo.Casilleros;

import Modelo.Edificacion;
import Modelo.Jugador;

import java.util.List;

public class BarrioDoble extends Barrio{

    private List<Edificacion> listaHoteles;

    public BarrioDoble(String unNombre, int valor_propiedad, int elAlquilerOriginal, List edificacionesCasas, List edificacionesHoteles) {
        super(unNombre,valor_propiedad, elAlquilerOriginal, edificacionesCasas);
        listaHoteles = edificacionesHoteles;
    }

    public boolean duenioDeAmbosHermanos(){
        return municipio.poseeLosDosHermanos(this);
    }

    public boolean puedeEdificarCasa(Jugador jugador) {
        return (super.puedeEdificarCasa(jugador) && duenioDeAmbosHermanos());
    }

    public boolean puedeEdificarHotel(Jugador jugador){

        boolean resultado =  municipio.puedeEdificarHotel(this);
        if (resultado){
                if (municipio.devolverPropietario(this)==jugador){
                    return true;
                }
        }
        return false;
    }

    public boolean edificarHotel(Jugador jugador){
        if (! puedeEdificarHotel(jugador))return false;
        if (!jugador.solicitarDinero(listaHoteles.get(0).getPrecio())) return false;
        alquilerActual = listaHoteles.get(0).getAlquiler();
        return true;
    }
}
