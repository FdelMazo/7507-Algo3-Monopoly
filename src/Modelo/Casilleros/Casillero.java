package Modelo.Casilleros;

import Modelo.Jugador;

public interface Casillero {

    void accionAlPartir(Jugador jugador);

    void accionAlCaer(Jugador jugador, int numDado);

    boolean permiteSalida(Jugador jugador);

}
