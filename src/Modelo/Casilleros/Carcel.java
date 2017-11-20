package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;
import Modelo.Preso;

public class Carcel implements Casillero {

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        jugador.actualizarEstado(new Preso());
    }

}
