package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public class Policia implements Casillero {


    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        Casillero carcel = tablero.desplazarCasillero(this, -10, jugador);
        jugador.caeEn(carcel, numDado, tablero);
    }

}
