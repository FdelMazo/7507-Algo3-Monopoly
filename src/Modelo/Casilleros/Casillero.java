package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public interface Casillero {

    void accionAlPartir(Jugador jugador);

    void accionAlCaer(Jugador jugador, int numDado, Tablero tablero);

    boolean permiteSalida(Jugador jugador);

}
