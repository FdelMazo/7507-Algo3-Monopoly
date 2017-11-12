package Modelo.Casilleros;

import Modelo.Jugador;
import Modelo.Tablero;

public class Salida implements Casillero {
    public void accionAlPartir(Jugador jugador) { }

    public void accionAlCaer(Jugador jugador, int numDado, Tablero tablero) {
        jugador.cobrar_ingreso(2000);
    }

    public boolean permiteSalida(Jugador jugador) {  return true;    }



}
