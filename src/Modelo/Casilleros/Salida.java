package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public class Salida implements Casillero {

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        jugador.cobrar(2000);
    }




}
