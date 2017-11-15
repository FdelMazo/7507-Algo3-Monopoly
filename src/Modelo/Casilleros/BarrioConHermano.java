package Modelo.Casilleros;

import Modelo.Jugador;

import java.util.ArrayList;

public class BarrioConHermano extends Barrio{
    BarrioConHermano hermano;

    public BarrioConHermano(String unNombre, int valor_propiedad, ArrayList listaalquileres, int edificacionDeCasa, int edificacionDeHotel) {
        super(unNombre, valor_propiedad, listaalquileres, edificacionDeCasa, edificacionDeHotel);
    }

    public void setHermano(BarrioConHermano barrioHermano){
        hermano = barrioHermano;
    }

    public boolean tienenMismoPropietario(BarrioConHermano barrioHermano){
        return propietario == barrioHermano.duenio();
    }

    public boolean puedeEdificarCasa(Jugador jugador) {
        return (jugador.capital() >= edificacionCasa && casasTotales < casasMaximas && tienenMismoPropietario(hermano));
    }

    public boolean puedeEdificarHotel(Jugador jugador){
        return (jugador.capital() >= edificacionHotel && this.hayCapacidadMaximaDeCasas() && tienenMismoPropietario(hermano) && hermano.hayCapacidadMaximaDeCasas());
    }
}
