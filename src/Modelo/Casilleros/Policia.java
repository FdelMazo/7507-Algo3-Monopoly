package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

import java.util.HashMap;

public class Policia implements Casillero {

    public void accionAlPartir(Jugador jugador) {
    }

    private boolean pagarFianza(Jugador jugador) {
        return jugador.solicitar_dinero(45000);
    }

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        Casillero carcel = tablero.desplazarCasillero(this, -2, jugador);
        jugador.caeEn(carcel, numDado, tablero);
    }

    public boolean permiteSalida(Jugador jugador) { return true;  }



}
